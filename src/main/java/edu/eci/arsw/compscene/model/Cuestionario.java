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
package edu.eci.arsw.compscene.model;

import edu.eci.arsw.compscene.persistence.impl.Tripla;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author dbeltran
 */
public class Cuestionario {
    private int id;
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    private List<Tripla<String,Boolean,Float>> respuestas;

    /**
     * Constructor del cuestionario
     * 
     * @param id
     * @param preguntas
     * @param jugadores
     * @param respuestas
     */
    public Cuestionario(int id, List<Pregunta> preguntas, List<Jugador> jugadores,List<Tripla<String, Boolean, Float>> respuestas) {
        this.id = id;
        this.jugadores = jugadores;
        this.preguntas = preguntas;
        this.respuestas = respuestas;
    }
    
    /**
     * Genera un cuestionario
     * <p>A base de los jugadores y las preguntas</p>
     * @param jugadores
     * @param preguntas
     */
    public void generarCuestionario(List<Jugador> jugadores, List<Pregunta> preguntas){
        this.preguntas = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++){
            Random randomizer = new Random();
            Pregunta random = preguntas.get(randomizer.nextInt(preguntas.size()));
            this.preguntas.add(random);
        }        
    }

    /**
     *
     * @return los jugadores
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     *
     * @param jugadores - cambia jugadores
     */
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id - identificador 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     *
     * @return preguntas
     */
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     *
     * @param preguntas - cambia preguntas
     */
    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     *
     * @return respuestas hechas como: tema, correcta/incorrecta, puntaje
     */
    public List<Tripla<String,Boolean,Float>> getRespuestas() {
        return respuestas;
    }

    /**
     *
     * @param respuestas
     */
    public void setRespuestas(List<Tripla<String,Boolean,Float>> respuestas) {
        this.respuestas = respuestas;
    }    
    
}
