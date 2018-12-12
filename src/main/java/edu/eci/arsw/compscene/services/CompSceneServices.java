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
import edu.eci.arsw.compscene.model.impl.PreguntaRellenar;
import edu.eci.arsw.compscene.model.impl.PreguntaSeleccionMultiple;
import edu.eci.arsw.compscene.model.impl.PreguntaVerdaderoFalso;
import edu.eci.arsw.compscene.persistence.impl.Tripla;
import java.util.List;

/**
 *
 * @author dcastiblanco
 */
public interface CompSceneServices {
    
    void addPreguntaRellenar(PreguntaRellenar nueva_pregunta_rellenar) throws CompSceneServicesException;
    
    void addPreguntaSeleccion(PreguntaSeleccionMultiple nueva_pregunta_seleccion) throws CompSceneServicesException;
    
    void addPreguntaVerdaderoFalso(PreguntaVerdaderoFalso nueva_pregunta_verdadero_falso) throws CompSceneServicesException;
    
    
    PreguntaRellenar getPreguntaRellenar() throws CompSceneServicesException;
    
    PreguntaSeleccionMultiple getPreguntaSeleccion() throws CompSceneServicesException;
    
    PreguntaVerdaderoFalso getPreguntaVerdaderoFalso() throws CompSceneServicesException;
    
    
    void deletePreguntaRellenar(PreguntaRellenar pregunta_rellenar) throws CompSceneServicesException;
    
    void deletePreguntaSeleccion(PreguntaSeleccionMultiple pregunta_seleccion) throws CompSceneServicesException;
    
    void deletePreguntaVerdaderoFalso(PreguntaVerdaderoFalso pregunta_verdadero_falso) throws CompSceneServicesException;
        
    
    List<Tripla<String,Boolean,Float>> getRespuestas() throws CompSceneServicesException;
    
    float getPuntaje() throws CompSceneServicesException;
    
    void addJugador(String nombre)throws CompSceneServicesException;
    int getIdJugador (String nombre)throws CompSceneServicesException;
    
    Jugador getJUgador(int id)throws CompSceneServicesException;
 
    String jugadorToString(String nombre)throws CompSceneServicesException;
    
    List<Jugador> allJugadores()throws CompSceneServicesException;
}
