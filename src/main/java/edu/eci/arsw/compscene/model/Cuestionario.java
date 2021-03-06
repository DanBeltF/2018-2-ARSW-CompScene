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
    //private List<Jugador> jugadores;
    private Jugador jugador;
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
    public Cuestionario(){
        preguntas=new CopyOnWriteArrayList<>();
        //jugadores=new CopyOnWriteArrayList<>();
    }
    //public Cuestionario(int id, List<Pregunta> preguntas, List<Jugador> jugadores,List<Tripla<String, Boolean, Float>> respuestas) {
    public Cuestionario(int id, List<Pregunta> preguntas, Jugador jugador,List<Tripla<String, Boolean, Float>> respuestas) {
        this.id = id;
        //this.jugadores = jugadores;
        this.jugador=jugador;
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
    //public List<Jugador> getJugadores() {
    public Jugador getJugador() {
        //return jugadores;
        return jugador;
    }

    /**
     *
     * @param jugadores - cambia jugadores
     */
    //public void setJugadores(List<Jugador> jugadores) {
    public void setJugador(Jugador jugador) {
        //this.jugadores = jugadores;
        this.jugador = jugador;
        
    }

    /**
     *
<<<<<<< HEAD
     * @return id
=======
     * @return id - id del cuestionario
>>>>>>> cd6518c9d091db229dae10daf7285950ae8ac11e
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
<<<<<<< HEAD
     * @return preguntas
=======
     * @return preguntas - lista de preguntas a generar
>>>>>>> cd6518c9d091db229dae10daf7285950ae8ac11e
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
    public void setAddPreguntas(Pregunta pre){
        preguntas.add(pre);
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
<<<<<<< HEAD
     * @param respuestas
=======
     * @param respuestas - cambia respuestas
>>>>>>> cd6518c9d091db229dae10daf7285950ae8ac11e
     */
    public void setRespuestas(List<Tripla<String,Boolean,Float>> respuestas) {
        this.respuestas = respuestas;
    }    
    
}