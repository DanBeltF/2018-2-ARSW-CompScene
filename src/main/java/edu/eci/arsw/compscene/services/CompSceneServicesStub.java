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
        return pr;
    }

    @Override
    public PreguntaSeleccionMultiple getPreguntaSeleccion() throws CompSceneServicesException {
        if (!listaPreguntas.contains(psm)) {
            throw new CompSceneServicesException("La pregunta de seleccion multiple no existe: " + psm.getEnunciado());
        }
        return psm;
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
    
    private static final List<Tripla<String, Boolean, Float>> respuestas;
    private static final Tripla<String, Boolean, Float> respuesta1;
    private static final Tripla<String, Boolean, Float> respuesta2;
    private static final List<String> respuestaCorrectaRellenar;
    private static final List<String> opcionesRespuestaSeleccion;
    private static final List<String> opcionesRespuestaVF;
    private static final PreguntaRellenar pr;
    private static final PreguntaSeleccionMultiple psm;
    private static final PreguntaVerdaderoFalso pvf;
    private static final List<Pregunta> listaPreguntas;
    private static final List<Float> puntaje;
    
    static {
        respuestas = new CopyOnWriteArrayList<>();
        listaPreguntas= new CopyOnWriteArrayList<>();
        puntaje= new CopyOnWriteArrayList<>();
        //Primer tipo de pregunta
        respuestaCorrectaRellenar= new CopyOnWriteArrayList<>();
        respuestaCorrectaRellenar.add("2");
        respuestaCorrectaRellenar.add("9");
        pr = new PreguntaRellenar(respuestaCorrectaRellenar,1,"Raiz cuadrada de 4 es {} y la de 81 es {}", "Matemática", null, 6.7f);
        //Segundo tipo de respuesta
        opcionesRespuestaSeleccion= new CopyOnWriteArrayList<>();
        opcionesRespuestaSeleccion.add("13");
        opcionesRespuestaSeleccion.add("76");
        opcionesRespuestaSeleccion.add("32");
        opcionesRespuestaSeleccion.add("65");
        psm = new PreguntaSeleccionMultiple(13,1,"8 + 5 =: ", "Matemática", opcionesRespuestaSeleccion, 3.5f);
        //Tercer topo de respesta
        opcionesRespuestaVF= new CopyOnWriteArrayList<>();
        //opcionesRespuestaVF.add("91");
        opcionesRespuestaVF.add("Falso");
        opcionesRespuestaVF.add("Verdadero");
        pvf = new PreguntaVerdaderoFalso(91,1,"9 elevado al cuadrado = 81", "Matemática", opcionesRespuestaVF, 2.9f);
        
        listaPreguntas.add(pr);
        listaPreguntas.add(psm);
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
