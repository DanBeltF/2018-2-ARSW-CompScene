
/* 
 * The MIT License
 *
 * Copyright 2018 Pivotal Software, Inc..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.  jspdf.min.js
 */
var preguntas = {};
var respuesta;
var rellenar = 0;
var txt_respuestas = "";

var total = 0;
var idp;
var numPreguntas=7;
var pag2='/Estadisticas.html';


var information = (function Information() {
    function final(){
        
        
        axios.get('/question/re'+'pepe')
                .then(function (response) {
                    
                    console.log('saved successfully')
                }); 

    }
    
    
    function load(url){
        location.href ="/Estadisticas.html";
          }

    function setRespuestas() {
 
        axios.get('/res/concretas/'+respuesta+'/'+idp)
                .then(function (response) {
                    console.log('saved successfully')
                });
    }
    function tiempo() {
        
        axios.post('/tiempo', seg+"")
                .then(function (response) {
                    console.log('saved successfully')
                })
                .catch(function (error) {
                    console.log(error);
                });

    }

    function getRespuestas() {
        txt_respuestas.length = 0;
        txt_respuestas = "";
        axios.get('/respuestas').then(function (respuesta) {
            document.getElementById("respuesta").innerHTML = "";
            var a = 0;
            respuestas = preguntas.opcionesDeRespuesta;
            if (rellenar == 0) {
                for (i in respuestas) {
                    a++;
                    var temp = '<input type="radio" class="form-check-input" name="rell" id=materialUnchecked' + a + ' ' + 'value="' + respuestas[i] + '"><label class="form-check-label" for=materialUnchecked' + a + '>';
                    txt_respuestas += temp + respuestas[i] + '</label><br>';
                }
            } else {
                txt_respuestas += '<input type="text" name="rell" id=materialUnchecked class="form-control" value="" placeholder="Campo de texto" ><label class="form-control" for=materialUnchecked>';
            }
            total = a;
            var temp = '';
            document.getElementById("respuesta").innerHTML = txt_respuestas;
            document.getElementsByName("formulario").innerHTML = txt_respuestas;
        })
                .catch(function (errorr) {
                    console.log(errorr);
                })
    }
    function getPreguntaSeleccionMultiple() {
        rellenar = 0;
        txt_respuestas.length = 0;
        txt_respuestas = "";
        document.getElementById("respuesta").innerHTML = "";
        axios.get('/preguntas/psm').then(function (response) {
            this.preguntas = response.data;
            document.getElementById("enun").innerHTML = "Pregunta Seleccion : " + preguntas.enunciado;
            idp=preguntas.id;
            document.getElementById("respuesta").innerHTML = "Respuesta Seleccion : ";
            console.log(response.data);
            information.getRespuestas();
        })
                .catch(function (error) {
                    console.log(error);
                })
    }
    function getPreguntasVerdaderoFalso() {
        rellenar = 0;
        txt_respuestas.length = 0;
        txt_respuestas = "";
        document.getElementById("respuesta").innerHTML = "";
        axios.get('/preguntas/pvf').then(function (response) {
            this.preguntas = response.data;
            document.getElementById("enun").innerHTML = "Pregunta Falso o verdadero : " + preguntas.enunciado;
            idp=preguntas.id;
            document.getElementById("respuesta").innerHTML = "Respuesta F/V : ";
            console.log(response.data);
            information.getRespuestas();
        })
                .catch(function (error) {
                    console.log(error);
                });
    }
    function getPereguntasRellenar() {
        axios.get('/preguntas/pr').then(function (response) {
            this.preguntas = response.data;
            document.getElementById("enun").innerHTML = "Pregunta Rellenar : " + preguntas.enunciado;
            idp=preguntas.id;
            document.getElementById("respuesta").innerHTML = "Respuesta Rellenar : ";
            rellenar = 1;
            console.log(response.data)
            information.getRespuestas();
        })
                .catch(function (error) {
                    console.log(error);
                });
    }
    function getRespuesta() {
        if (rellenar == 0) {
            respuesta = $("input[type=radio]:checked").val();
            //alert("Que es respuesta nonono"+respuesta);
            if(respuesta==null){
                respuesta="SINRESPUESTA";
                idp=-1;
            }            
            information.setRespuestas();
            information.tiempo();
            pregunta.selectQUestion();
        } else {          
            respuesta = $("input[type=text]").val();
            if(respuesta==""){
                respuesta="SINRESPUESTA";
                idp=-1;
            }
            information.setRespuestas();
            information.tiempo();
            pregunta.selectQUestion();
        }
    }
    function setRellenar(num) {
        rellenar = num;      
    }
    function getAllJugadores(){
        var a;
        axios.get('/question').then(function (response) {           
            a=response.data;

            document.getElementById("pl").innerHTML = "Jugadores : " + response.data;
            console.log(response.data)
            information.getRespuestas();
        })
                .catch(function (error) {
                    console.log(error);
                });
        
    }
    
    return {
        getAllJugadores:getAllJugadores,
        getPreguntaSeleccionMultiple: getPreguntaSeleccionMultiple,
        getPreguntasVerdaderoFalso: getPreguntasVerdaderoFalso,
        getPereguntasRellenar: getPereguntasRellenar,
        getRespuestas: getRespuestas,
        getRespuesta: getRespuesta,
        setRellenar: setRellenar,
        setRespuestas: setRespuestas,
        tiempo: tiempo,
        load:load,
        final:final

    };
})();
var seg=15;
var numero = null;
var pregunta = (function Pregunta() {
    var numero = null;
    function getNumero() {
        numero = Math.round(Math.random() * 3);
    }
    function selectQUestion() {
        pregunta.getNumero();
        if(numPreguntas>0){
            if (numero == 1) {
                information.getPreguntaSeleccionMultiple();
                information.setRellenar(0);
                numPreguntas--;
            } else if (numero == 2) {
                information.getPereguntasRellenar();
                information.setRellenar(1);
                numPreguntas--;
            } else if (numero == 3) {
                information.getPreguntasVerdaderoFalso();
                information.setRellenar(0);
                numPreguntas--;
            } else {
                information.getPreguntaSeleccionMultiple();
                information.setRellenar(0);
                numPreguntas--;
            }
        }else{
            information.load(pag2);
            
            
        }
    }
    function hacer() {
        pregunta.selectQUestion();
        pregunta.hora();
        information.getAllJugadores();
    }
    function hora() {
        int = setInterval(function () {
            seg--;
            document.getElementById('i').innerHTML = seg;
            if (seg == 0) {
                seg = 15;
                alert("Se acabo el tiempo");
                pregunta.selectQUestion();
            }
        }, 1000);
        seg++;
    }
    return {
        getNumero: getNumero,
        selectQUestion: selectQUestion,
        hora: hora,
        hacer: hacer
    };
})();