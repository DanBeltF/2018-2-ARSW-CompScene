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
import edu.eci.arsw.compscene.persistence.impl.Tupla;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author dcastiblanco
 */
public class Jugador {
    private int id;
    private String nombre;
    private String password;
    private float puntajeJugador;

    public Jugador(int id, String nombre, String password, float puntajeJugador) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.puntajeJugador = puntajeJugador;
    }
    
    /**
     * Calcula el puntaje específico del jugador 
     * @param respuestas Lista de respuestas que contienen tema, respuesta y el tiempo ejecutado en responder
     * @return  Puntaje de cada jugador por ronda
     */
    public float calcularPuntajeEspecifico(List<Tripla<String,Boolean,Timer>> respuestas){
        return 0;
    }
    
    public List<Tupla<String,Float>> calcularPuntajePorTema(List<Tripla<String,Boolean,Timer>> respuestas){
        return null;
    }
    
    public Timer calcularTiempoPromedioEspecifico(List<Tripla<String,Boolean,Timer>> respuestas){
        return new Timer();
    }
    
    public float calcularTematicaMasAcertada(){
        return 0;
    }
    
    public float calcularTematicaMasFallada(){
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getPuntajeJugador() {
        return puntajeJugador;
    }

    public void setPuntajeJugador(float puntajeJugador) {
        this.puntajeJugador = puntajeJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", puntajeJugador=" + puntajeJugador + '}';
    }
    
    
    
}
