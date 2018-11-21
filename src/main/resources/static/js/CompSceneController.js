
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
 * THE SOFTWARE.
 */
var preguntas={};

var respuesta=[];

var txt_respuestas="";
var rellenar=0;
var total=0;

var information=( function Information() {
    
    function getRespuestas(){
        txt_respuestas.length=0;
        txt_respuestas="";
        axios.get('/respuestas').then(function (respuesta) { 
                document.getElementById("respuesta").innerHTML= "";
                var a=0;
                //console.log(respuesta.data) 
                respuestas=preguntas.opcionesDeRespuesta;
                console.log(respuestas) ;
                //alert(rellenar);
                if(rellenar==0){
                    for (i in respuestas){
                        a++;
                                    //var temp=$("input[type=radio]:checked").val();       
                        var temp='<input type="radio" class="form-check-input" name="rell" id=materialUnchecked'+a+' '+'value="'+respuestas[i]+'"><label class="form-check-label" for=materialUnchecked'+a+'>';
                        //alert(temp);
                        txt_respuestas += temp+respuestas[i]+'</label><br>'; 
                    
                    }
                }else{
                    txt_respuestas += '<input type="text" class="form-control" name="rell" id=materialUnchecked value="" placeholder="Campo de texto" ><label class="form-control" for=materialUnchecked>';                     
                    rellenar=0;
                }
                total=a;
                var temp='';

                
                document.getElementById("respuesta").innerHTML=txt_respuestas;
                document.getElementsByName("formulario").innerHTML=txt_respuestas;
//              document.getElementById("respuesta").true; 
                

            })
        .catch(function (errorr) {
            console.log(errorr);
        })

    }
    function getPreguntaSeleccionMultiple() {        
        rellenar=0;
        txt_respuestas.length=0;
        txt_respuestas="";
        document.getElementById("respuesta").innerHTML= "";
        axios.get('/preguntas/psm').then(function (response) {
            this.preguntas=response.data;
            document.getElementById("enun").innerHTML = "Pregunta Seleccion : "+preguntas.enunciado;
            document.getElementById("respuesta").innerHTML = "Respuesta Seleccion : ";
            console.log(response.data);
            information.getRespuestas();
            //information.getRespuesta();

        })
        .catch(function (error) {
            console.log(error);
        })
    }
    function getPreguntasVerdaderoFalso(){
        rellenar=0;
        txt_respuestas.length=0;
        txt_respuestas="";
        document.getElementById("respuesta").innerHTML= "";
        axios.get('/preguntas/pvf').then(function (response) {
            this.preguntas=response.data;
            document.getElementById("enun").innerHTML = "Pregunta Falso o verdadero : "+preguntas.enunciado;
            document.getElementById("respuesta").innerHTML = "Respuesta F/V : ";
            console.log(response.data);
            information.getRespuestas();
            //information.getRespuesta();
        })
        .catch(function (error) {
            console.log(error);
        });
    }
    
    
    function getPereguntasRellenar(){
        axios.get('/preguntas/pr').then(function (response) {
            this.preguntas=response.data;
            document.getElementById("enun").innerHTML = "Pregunta Rellenar : "+preguntas.enunciado;            
            document.getElementById("respuesta").innerHTML = "Respuesta Rellenar : ";
            rellenar=1;
            console.log(response.data)
            information.getRespuestas();
            //information.getRespuesta();
        })
        .catch(function (error) {
            console.log(error);
        });       
    }
    
    function getRespuesta(){
        
        //$(document).ready(function(){    
        // $('#boton').click(function(){        
        /*Captura de datos escrito en los inputs*/        
        //var resp = document.getElementById("materialUnchecked1").value;
        //alert(resp);
        /*Guardando los datos en el LocalStorage*/

        /*Limpiando los campos o inputs*/
  //  });   
//});
       for(i=0;i<document.formulario.rell.length;i++){
            alert(document.formulario.rell.checked);
            if(document.formulario.checked){
                alert("sI PUTOS");
            }
            
            
        }
        
        
        
        
        
        
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //for(i=0;i<document.formulario.length;i++){
          //  alert(document.formulario.checked);
            //if(document.formulario.checked){
             //   alert("sI PUTOS");
            //}
            
            
        //}

            
            
        
        
        
        
        
        
        
        
        
        //for(i=0;i<ctrl.length;i++){
          //  if(ctrl[i].checked) {
        //	alert(ctrl[i].value);
        //	return ctrl[i].value;                
          //  }

            
        //}
        
        //var o='materialUnchecked';
        //var t=0;
        //$(document).ready(function(){
          //  alert("llegamos");
           // $('#boton').click(function(){
            //    alert("si llegamos");
             //   var prueba=document.getElementById("materialUnchecked1").value;
              //  alert("ver"+prueba);
        //        for(i in prueba){
          //          var oo=o+t;
            //        alert("VEMOS CADA COSITO"+oo);
                    
                    //var prueba=document.respuesta.respuesta;
                    //var respu=document.getElementById(oo).value;
                    
                    //if(respu[0].checked){
              //      alert("qUES ES ESTO"+prueba[i]);
                //    if(prueba[i].checked){
                  //      alert("pasamos");
                        
//                    }
  //                  alert("hola");
    //                alert(prueba.checked);
      //              t++;
                //document.getElementById("materialUnchecked1").value=""; 
            
                  
      
    
    
    
    
    return {
        getPreguntaSeleccionMultiple:getPreguntaSeleccionMultiple,
        getPreguntasVerdaderoFalso:getPreguntasVerdaderoFalso,
        getPereguntasRellenar:getPereguntasRellenar,
        getRespuestas:getRespuestas,
        getRespuesta:getRespuesta
    };
})();
seg=15;
var numero=null;
var pregunta=(function Pregunta(){
    var numero=null; 
    function getNumero(){
        numero = Math.round(Math.random()*3);
        //alert("Número aleatorio es:"+ numero);
        
    }
    function selectQUestion(){
        
        pregunta.getNumero();
        //alert("QUe numero es:"+ numero);
        if(numero==1){
            information.getPreguntaSeleccionMultiple();
        }else if(numero==2){
            information.getPereguntasRellenar();
        }else if(numero==3){
            information.getPreguntasVerdaderoFalso();
        }else{
            information.getPreguntaSeleccionMultiple();
        }
    }
    function hacer(){
        pregunta.selectQUestion();
        pregunta.hora();

    }

    
    function hora(){
        
        int =setInterval(function(){
            seg--;
            document.getElementById('i').innerHTML=seg;
            if(seg==0){
                seg=15;
                alert("Se acabo el tiempo");
                information.getRespuesta();
                //alert("Se GUARDO");
                pregunta.selectQUestion();
                
            }   
            
        },1000);
        seg++;
    }
    
    return {
        getNumero:getNumero,
        selectQUestion:selectQUestion,
        hora:hora,
        hacer:hacer
    };    
    })(); 