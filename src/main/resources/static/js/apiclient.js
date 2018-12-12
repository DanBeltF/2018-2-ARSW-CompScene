/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var apiclient = (function () {

    return {
        postUser: function (user) {
            return $.ajax({
                url: "/question/",
                type: "POST",
                data: JSON.stringify(user),
                contentType: "application/json"});
        },
        deleteUser: function (user) {
            return $.ajax({
                url: "/Usuarios/" + user,
                type: "DELETE"});
        },
        putUser: function (user) {
            return $.ajax({
                url: "/Usuarios/",
                type: "PUT",
                data: JSON.stringify(user),
                contentType: "application/json"});
        },
        getUser: function (user, callback) {
            return $.get("/Usuarios/" + user, callback);
        },
        getAllUser: function (user, callback) {
            return $.get("/Usuarios", callback);
        }
    };

}());

