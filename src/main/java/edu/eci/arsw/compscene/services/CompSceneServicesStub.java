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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPreguntaSeleccion(PreguntaSeleccionMultiple nueva_pregunta_seleccion) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPreguntaVerdaderoFalso(PreguntaVerdaderoFalso nueva_pregunta_verdadero_falso) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreguntaRellenar getPreguntaRellenar() throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreguntaSeleccionMultiple getPreguntaSeleccion() throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreguntaVerdaderoFalso getPreguntaVerdaderoFalso() throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePreguntaRellenar(PreguntaRellenar pregunta_rellenar) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePreguntaSeleccion(PreguntaSeleccionMultiple pregunta_seleccion) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePreguntaVerdaderoFalso(PreguntaVerdaderoFalso pregunta_verdadero_falso) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTema(String nuevoTema) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTema() throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTema(String tema) throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tripla<String, Boolean, Float>> getRespuestas() throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getPuntaje() throws CompSceneServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final List<Tripla<String, Boolean, Float>> respuestas;
    private static final Tripla<String, Boolean, Float> respuesta1;
    private static final Tripla<String, Boolean, Float> respuesta2;
    private static final List<String> respuestaCorrectaRellenar;
    private static final List<String> opcionesRespuestaSeleccion;
    private static final List<String> opcionesRespuestaVF;

    static {
        respuestas = new CopyOnWriteArrayList<>();
        respuestaCorrectaRellenar= new CopyOnWriteArrayList<>();
        respuestaCorrectaRellenar.add("2");
        PreguntaRellenar pr = new PreguntaRellenar(respuestaCorrectaRellenar,1,"Raiz cuadrada de 4: ", "Matemática", null, 6.7f);
        
        opcionesRespuestaSeleccion= new CopyOnWriteArrayList<>();
        opcionesRespuestaSeleccion.add("13");
        opcionesRespuestaSeleccion.add("76");
        opcionesRespuestaSeleccion.add("32");
        opcionesRespuestaSeleccion.add("65");
        PreguntaSeleccionMultiple psm = new PreguntaSeleccionMultiple(13,1,"8 + 5 =: ", "Matemática", opcionesRespuestaSeleccion, 3.5f);
        
        opcionesRespuestaVF= new CopyOnWriteArrayList<>();
        opcionesRespuestaVF.add("91");
        PreguntaVerdaderoFalso pvf = new PreguntaVerdaderoFalso(91,1,"9 elevado al cuadrado= ", "Matemática", opcionesRespuestaVF, 2.9f);
        
        respuesta1 = new Tripla("Matemática",true,6.7f);
        respuesta2 = new Tripla("Lógica",false,8.2f);
        
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
    }
    
}
