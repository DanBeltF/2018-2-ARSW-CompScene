/* JavaScript for websocket client */
var stompClient = null;

var nombre=null;

/* Connect to topic using web sockets */
function connect() {
    var socket = new SockJS('/weather');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/weatherinfo', function(weather){
            showWeather(JSON.parse(weather.body));
        });
    });
}

/* Disconnect */
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/* Send place  location.href ="/preguntaGeneral.html";*/
function sendPlace() {
   
    var name = document.getElementById('username').value;
    stompClient.send("/app/respJugador", {},  JSON.stringify({'username': name}));
}

/* Show weather info */
function showWeather(wInfo) {
    var response = document.getElementById('weatherInfo');
    var newInfo = "<p>[" + wInfo.localDateTimeStr + "](" + wInfo.place + "): " + wInfo.type + "</p>"
    var content = response.innerHTML;
    response.innerHTML = content + newInfo;
}

