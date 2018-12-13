
/* global apiclient, postUser */
var username;
var susers;
var appIndex = (function () {

    var api = apiclient;

    class Jugador {
        constructor(nombre) {
            this.nombre = nombre;
        }
    }
    var getUsers = function () {
            
        var susers = api.getAllUser();
        ;

    };    
    var postUser = function () {
        
        sessionStorage.setItem("player", document.getElementById("username").value);
        
        var newPlayer = new Jugador(sessionStorage.getItem("player"));
        
        var postPromise = api.postUser(newPlayer);
        postPromise.then(
                function () {
                    var newURL = window.location.protocol + "//" + window.location.host + "/" + "/preguntaGeneral.html";
                    window.location.replace(newURL);
                },
                function () {
                    alert("You can't play with this username, it's playing");
                }
        );

    };


    return {
        addUser: function () {
            var username = document.getElementById("username").value;
            if (username === "") {
                alert("Escriba un usuario valido");
            }
            else{
                postUser();
            }   
        },
        getAllUser: function(){
            
            getUsers();
            
        }
    };

}());
