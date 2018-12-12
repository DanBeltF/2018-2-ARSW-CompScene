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
package edu.eci.arsw.compscene.services;

import edu.eci.arsw.compscene.model.Jugador;
import edu.eci.arsw.compscene.model.Pregunta;
import edu.eci.arsw.compscene.model.impl.PreguntaRellenar;
import edu.eci.arsw.compscene.model.impl.PreguntaSeleccionMultiple;
import edu.eci.arsw.compscene.model.impl.PreguntaVerdaderoFalso;
import edu.eci.arsw.compscene.persistence.impl.Tripla;
import edu.eci.arsw.compscene.persistence.impl.Tupla;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author dcastiblanco
 */

@Service
public class CompSceneServicesStub implements CompSceneServices {

    public CompSceneServicesStub() {
    }

    @Override
    public void addPreguntaRellenar(PreguntaRellenar nueva_pregunta_rellenar) throws CompSceneServicesException {
        if (listaPreguntas.contains(nueva_pregunta_rellenar)) {
            throw new CompSceneServicesException("La pregunta de rellenar ya existe: " + nueva_pregunta_rellenar.getEnunciado());
        }
        listaPreguntas.add(nueva_pregunta_rellenar);
    }

    @Override
    public void addPreguntaSeleccion(PreguntaSeleccionMultiple nueva_pregunta_seleccion) throws CompSceneServicesException {
        if (listaPreguntas.contains(nueva_pregunta_seleccion)) {
            throw new CompSceneServicesException("La pregunta de seleccion multiple ya existe: " + nueva_pregunta_seleccion.getEnunciado());
        }
        listaPreguntas.add(nueva_pregunta_seleccion);
    }

    @Override
    public void addPreguntaVerdaderoFalso(PreguntaVerdaderoFalso nueva_pregunta_verdadero_falso) throws CompSceneServicesException {
        if (listaPreguntas.contains(nueva_pregunta_verdadero_falso)) {
            throw new CompSceneServicesException("La pregunta verdadero falso ya existe: " + nueva_pregunta_verdadero_falso.getEnunciado());
        }
        listaPreguntas.add(nueva_pregunta_verdadero_falso);
    }

    @Override
    public PreguntaRellenar getPreguntaRellenar() throws CompSceneServicesException {
        if (!listaPreguntas.contains(pr)) {
            throw new CompSceneServicesException("La pregunta de rellenar no existe: " + pr.getEnunciado());
        } 
        double valIndice=Math.floor(Math.random()*listasPreguntasRellenar.size());
        PreguntaRellenar temp=listasPreguntasRellenar.get((int)valIndice);
        return temp;
    }

    @Override
    public PreguntaSeleccionMultiple getPreguntaSeleccion() throws CompSceneServicesException {
        if (!listaPreguntas.contains(psm)) {
            throw new CompSceneServicesException("La pregunta de seleccion multiple no existe: " + psm.getEnunciado());
        }
        //listasPreguntaSeleccionMultiple
        double valIndice=Math.floor(Math.random()*listasPreguntaSeleccionMultiple.size());
        PreguntaSeleccionMultiple temp=listasPreguntaSeleccionMultiple.get((int)valIndice);
        return temp;
    }

    @Override
    public PreguntaVerdaderoFalso getPreguntaVerdaderoFalso() throws CompSceneServicesException {
        if (!listaPreguntas.contains(pvf)) {
            throw new CompSceneServicesException("La pregunta de verdadero falso no existe: " + pvf.getEnunciado());
        }
        return pvf;
    }

    @Override
    public void deletePreguntaRellenar(PreguntaRellenar pregunta_rellenar) throws CompSceneServicesException {
        if(!listaPreguntas.contains(pregunta_rellenar)){
            throw new CompSceneServicesException("La pregunta de rellenar no existe: " + pregunta_rellenar.getEnunciado());
        }
        listaPreguntas.remove(pregunta_rellenar);
    }

    @Override
    public void deletePreguntaSeleccion(PreguntaSeleccionMultiple pregunta_seleccion) throws CompSceneServicesException {
        if(!listaPreguntas.contains(pregunta_seleccion)){
            throw new CompSceneServicesException("La pregunta de seleccion multiple no existe: " + pregunta_seleccion.getEnunciado());
        }
        listaPreguntas.remove(pregunta_seleccion);
    }

    @Override
    public void deletePreguntaVerdaderoFalso(PreguntaVerdaderoFalso pregunta_verdadero_falso) throws CompSceneServicesException {
        if(!listaPreguntas.contains(pregunta_verdadero_falso)){
            throw new CompSceneServicesException("La pregunta de verdadero falso no existe: " + pregunta_verdadero_falso.getEnunciado());
        }
        listaPreguntas.remove(pregunta_verdadero_falso);
    }


    @Override
    public List<Tripla<String, Boolean, Float>> getRespuestas() throws CompSceneServicesException {
        return respuestas;
    }

    @Override
    public float getPuntaje() throws CompSceneServicesException {
        float puntajetotal=0;
        for(int i=0;i<puntaje.size();i++){
            puntajetotal+=puntaje.get(i);
        }
        return puntajetotal;
    }
        @Override
    public void addJugador(String nombre) throws CompSceneServicesException {
        jugadores.add(new Jugador(jugadores.size()+1,nombre, 0, puntajeTemas));
        
    }
    @Override
    public int getIdJugador(String nombre) throws CompSceneServicesException {
        int resp=0;
        for(int i=0; i<jugadores.size();i++){
            Jugador temp=jugadores.get(i);
            if(temp.getNombre().equalsIgnoreCase(nombre)){
                resp=temp.getId();
            }
        }
        return resp ;
        
    }

      @Override
    public Jugador getJUgador(int id) throws CompSceneServicesException {
        return jugadores.get(id);
    }
    
    
    private static final List<PreguntaRellenar> listasPreguntasRellenar;
    private static final List<PreguntaSeleccionMultiple> listasPreguntaSeleccionMultiple;
    //private static final List<PreguntaVerdaderoFalso> listasPreguntaVerdaderoFalso;
    private static final List<Jugador> jugadores;
     private static final List<Tupla<String, Float>> puntajeTemas;
    private static final List<Tripla<String, Boolean, Float>> respuestas;
    private static final Tripla<String, Boolean, Float> respuesta1;
    private static final Tripla<String, Boolean, Float> respuesta2;
    private static final List<String> respuestaCorrectaRellenar;
    //Segunda pregunta
    private static final List<String> respuestaCorrectaRellenar1;
    private static final List<String> respuestaCorrectaRellenar2;
    private static final List<String> respuestaCorrectaRellenar3;
    private static final List<String> respuestaCorrectaRellenar4;
      
      
    private static final List<String> opcionesRespuestaSeleccion;
    private static final List<String> opcionesRespuestaSeleccion1;
    private static final List<String> opcionesRespuestaSeleccion2;
    private static final List<String> opcionesRespuestaSeleccion3;
    private static final List<String> opcionesRespuestaSeleccion4;        
    private static final List<String> opcionesRespuestaSeleccion5;    
 
    private static final List<String> opcionesRespuestaVF;
    
    private static final PreguntaRellenar pr;
    private static final PreguntaRellenar pr1;
    private static final PreguntaRellenar pr2;    
    private static final PreguntaRellenar pr3;        
    private static final PreguntaRellenar pr4;        
    
    private static final PreguntaSeleccionMultiple psm;
    private static final PreguntaSeleccionMultiple psm1;
    private static final PreguntaSeleccionMultiple psm2;
    private static final PreguntaSeleccionMultiple psm3;
    private static final PreguntaSeleccionMultiple psm4;    
    private static final PreguntaSeleccionMultiple psm5;    
    
    private static final PreguntaVerdaderoFalso pvf;
    //private static final PreguntaVerdaderoFalso pvf1;
    private static final List<Pregunta> listaPreguntas;//Esto es general y toca ponerlas segun el tipo de pregunta
    private static final List<Float> puntaje;
    
    static {
         jugadores = new CopyOnWriteArrayList<>();
          puntajeTemas=new CopyOnWriteArrayList<>();
      //Agregando puntajes temas
        Tupla t=new Tupla("MATEMATICAS", 43.0);
        Tupla t1=new Tupla("Programacion", 25.0);
        Tupla t2=new Tupla("Logica", 35.0);         
        puntajeTemas.add(t1);
        puntajeTemas.add(t2);
        puntajeTemas.add(t);
        
        respuestas = new CopyOnWriteArrayList<>();
        listaPreguntas= new CopyOnWriteArrayList<>();
        puntaje= new CopyOnWriteArrayList<>();
        //Primer tipo de pregunta rellenar
        respuestaCorrectaRellenar= new CopyOnWriteArrayList<>();
        respuestaCorrectaRellenar.add("2");
        respuestaCorrectaRellenar.add("9");
        pr = new PreguntaRellenar(respuestaCorrectaRellenar,1,"Raiz cuadrada de 4 es {} y la de 81 es {}", "Matemática", null, 6.7f);
        //Segunda pregunta de rellenar
        respuestaCorrectaRellenar1= new CopyOnWriteArrayList<>();        
        respuestaCorrectaRellenar1.add("x es mayor a 42");
        pr1=new PreguntaRellenar(respuestaCorrectaRellenar,2,"El número de niños (x) superó los 42 asientos del micro. ¿Cuál es la expresión que indica esta situación?", "Matemática", null, 6.7f);
        //Tercer pregunta a rellenar
        respuestaCorrectaRellenar2= new CopyOnWriteArrayList<>();        
        respuestaCorrectaRellenar2.add("lenguaje artificial que puede ser usado para escribir programas");
        pr2=new PreguntaRellenar(respuestaCorrectaRellenar,2,"¡Que es un lenguaje de programacion?", "Programacion", null, 6.7f);        
        //Cuarta pregunta rellenar
        respuestaCorrectaRellenar3= new CopyOnWriteArrayList<>(); 
        respuestaCorrectaRellenar3.add("son normas lexicas gramaticales parecidas a los lenguajes de programación");
        pr3=new PreguntaRellenar(respuestaCorrectaRellenar,2,"¿A qué le llamamos pseudocódigo?", "Programacion", null, 6.7f);                
        //Quinta pr rellenar
        
        
        
        respuestaCorrectaRellenar4= new CopyOnWriteArrayList<>(); 
        respuestaCorrectaRellenar4.add("es el proceso pr el cual la informacin de una fuesnte es convertida en simbolos para ser comunicada");
        pr4=new PreguntaRellenar(respuestaCorrectaRellenar,2,"Que es la codificación?", "Programacion", null, 6.7f);                
        
        
        listasPreguntasRellenar= new CopyOnWriteArrayList<>();
        listasPreguntasRellenar.add(pr);
        listasPreguntasRellenar.add(pr1);
        listasPreguntasRellenar.add(pr2);
        listasPreguntasRellenar.add(pr3);
        listasPreguntasRellenar.add(pr4);
        
        
        
        //Segundo tipo de respuesta
        opcionesRespuestaSeleccion= new CopyOnWriteArrayList<>();
        opcionesRespuestaSeleccion.add("13");
        opcionesRespuestaSeleccion.add("76");
        opcionesRespuestaSeleccion.add("32");
        opcionesRespuestaSeleccion.add("65");
        psm = new PreguntaSeleccionMultiple(13,1,"8 + 5 =: ", "Matemática", opcionesRespuestaSeleccion, 3.5f);
        //Segunda pregunta de seleccion
        opcionesRespuestaSeleccion1= new CopyOnWriteArrayList<>();
        opcionesRespuestaSeleccion1.add("54");
        opcionesRespuestaSeleccion1.add("14");
        opcionesRespuestaSeleccion1.add("90");
        opcionesRespuestaSeleccion1.add("36");        
        psm1 = new PreguntaSeleccionMultiple(54,2,"El auto de Catalina carga 30 litros de combustible. Entra a la estación de servicio con 12 litros. El surtidor arroja 1 litro cada 3 segundos. ¿En cuántos segundos se llenará el tanque si el surtidor continúa funcionando al mismo ritmo?", "Matemática", opcionesRespuestaSeleccion1, 3.5f);
        
        
        opcionesRespuestaSeleccion2= new CopyOnWriteArrayList<>();        
        opcionesRespuestaSeleccion2.add("7");
        opcionesRespuestaSeleccion2.add("12");
        opcionesRespuestaSeleccion2.add("17");
        opcionesRespuestaSeleccion2.add("0");                
        psm2 = new PreguntaSeleccionMultiple(12,3,"Si en una pecera hay 12 peces y 5 de ellos se ahogan, ¿cuántos peces quedan?", "Matemática", opcionesRespuestaSeleccion2, 3.5f);
        //tercera
        opcionesRespuestaSeleccion3= new CopyOnWriteArrayList<>();        
        opcionesRespuestaSeleccion3.add("1 m");
        opcionesRespuestaSeleccion3.add("50 cm");
        opcionesRespuestaSeleccion3.add("30 cm");
        opcionesRespuestaSeleccion3.add("20 cm");                
        psm3 = new PreguntaSeleccionMultiple(20,4,"Si el radio de un círculo mide 10 cm, ¿Cuánto mide su diámetro?", "Matemática", opcionesRespuestaSeleccion3, 3.5f);        
        
        
        //cuarta 
        
        opcionesRespuestaSeleccion4= new CopyOnWriteArrayList<>();        
        opcionesRespuestaSeleccion4.add("8");
        opcionesRespuestaSeleccion4.add("5");
        opcionesRespuestaSeleccion4.add("7");
        opcionesRespuestaSeleccion4.add("6");                
        psm4 = new PreguntaSeleccionMultiple(6,5,"¿Cuántos lados tiene un hexágono?", "Matemática", opcionesRespuestaSeleccion4, 3.5f);        
        //quinta de seleccion
        opcionesRespuestaSeleccion5= new CopyOnWriteArrayList<>();        
        opcionesRespuestaSeleccion5.add("4");
        opcionesRespuestaSeleccion5.add("5");
        opcionesRespuestaSeleccion5.add("12");
        opcionesRespuestaSeleccion5.add("6");                
        psm5 = new PreguntaSeleccionMultiple(6,6,"¿Por cuánto tenemos que multiplicar el 6 para obtener 36?", "Matemática", opcionesRespuestaSeleccion5, 3.5f);        
        
        listasPreguntaSeleccionMultiple = new CopyOnWriteArrayList<>();
        
        listasPreguntaSeleccionMultiple.add(psm);
        listasPreguntaSeleccionMultiple.add(psm1);
        listasPreguntaSeleccionMultiple.add(psm2);
        listasPreguntaSeleccionMultiple.add(psm3);
        listasPreguntaSeleccionMultiple.add(psm4);        
        listasPreguntaSeleccionMultiple.add(psm5);                
        
        
        
        
        //Tercer topo de respesta
        opcionesRespuestaVF= new CopyOnWriteArrayList<>();
        //opcionesRespuestaVF.add("91");
        opcionesRespuestaVF.add("Falso");
        opcionesRespuestaVF.add("Verdadero");
        pvf = new PreguntaVerdaderoFalso(91,1,"9 elevado al cuadrado = 81", "Matemática", opcionesRespuestaVF, 2.9f);
        //Segunda pregunta falso y verdadero
        
        //pvf1 = new PreguntaVerdaderoFalso(91,2,"¿Hay 300 horas en 5 dias?", "Matemática", opcionesRespuestaVF, 2.9f);
        
        listaPreguntas.add(pr);
        listaPreguntas.add(pr1);
        listaPreguntas.add(pr2);
        listaPreguntas.add(pr3);
        listaPreguntas.add(pr4);
        
        
        listaPreguntas.add(psm);
        listaPreguntas.add(psm1);
        listaPreguntas.add(psm2);
        listaPreguntas.add(psm3);
        listaPreguntas.add(psm4);
        listaPreguntas.add(psm5);
        
        
        listaPreguntas.add(pvf);
        
        respuesta1 = new Tripla("Matemática",true,6.7f);
        respuesta2 = new Tripla("Lógica",false,8.2f);
        
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        
        for(int i=0;i<respuestas.size();i++){
            puntaje.add(respuestas.get(i).getElem3());
        }
    }
    
}
