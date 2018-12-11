var app = (function () {

    
    
    var id = 0;
    var stompClient = null; 

    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        
        //subscribe to /topic/newpoint when connections succeed
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/newpoint.' + id, function (eventbody) {
                var point=JSON.parse(eventbody.body);
                addPointToCanvas(point);
            });
            stompClient.subscribe('/topic/newpolygon.' + id, function (eventbody) {
                var polygon=JSON.parse(eventbody.body);
                addPolygonToCanvas(polygon);
            });
        });

    };
    
    

    return {

       

        disconnect: function () {
            if (stompClient !== null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        },
        
        connect: function (identifier) {
            id = identifier;
            app.init();
        }
    };

})();