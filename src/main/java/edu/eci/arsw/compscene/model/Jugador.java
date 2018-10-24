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
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author dcastiblanco
 */
public class Jugador {

    private int id;
    private String nombre;
    private String password;
    private float puntajeJugador;

    /**
     *
     * @param id
     * @param nombre
     * @param password
     * @param puntajeJugador
     */
    public Jugador(int id, String nombre, String password, float puntajeJugador) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.puntajeJugador = puntajeJugador;
    }

    /**
     * Calcula el puntaje específico del jugador
     *
     * @param respuestas Lista de respuestas que contienen tema, respuesta y el
     * tiempo ejecutado en responder
     * @return Puntaje de cada jugador por ronda
     */
    public float calcularPuntajeEspecifico(List<Tripla<String, Boolean, Float>> respuestas) {
        float correctas = 0;
        for (int i = 0; i < respuestas.size(); i++) {
            if (respuestas.get(i).getElem2() == true) {
                correctas += 100;
                correctas = correctas - respuestas.get(i).getElem3();
            }
        };
        return correctas;
    }

    
    /**
     * Calcula el puntaje del jugador por tema
     *
     * @param respuestas Lista de respuestas que contienen tema, respuesta y el
     * tiempo ejecutado en responder
     * @return Lista de tuplas que contienen los temas y sus respectivos
     * puntajes
     */
    public List<Tupla<String, Float>> calcularPuntajePorTema(List<Tripla<String, Boolean, Float>> respuestas) {
        List<Tupla<String, Float>> puntajeTemas = new CopyOnWriteArrayList<Tupla<String, Float>>();
        Tupla<String, Float> matematica; 
        Tupla<String, Float> logica;
        Tupla<String, Float> programacion;
        float correctaMate = 0;
        float correctaLogi = 0;
        float correctaProg = 0;
        for (int i = 0; i < respuestas.size(); i++) {
            if (null != respuestas.get(i).getElem1()) switch (respuestas.get(i).getElem1()) {
                case "Matematica":
                    if (respuestas.get(i).getElem2() == true) {
                        correctaMate += 100;
                        correctaMate = correctaMate - respuestas.get(i).getElem3();
                    }   break;
            
                case "Lógica":
                    if (respuestas.get(i).getElem2() == true) {
                        correctaLogi += 100;
                        correctaLogi = correctaLogi - respuestas.get(i).getElem3();
                    }   break;
                case "Programación":
                    if (respuestas.get(i).getElem2() == true) {
                        correctaProg += 100;
                        correctaProg = correctaProg - respuestas.get(i).getElem3();
                    }   break;
                default:
                    break;
            }
        }
        //Agregar puntajes y temas a la tuplas respectivas
        //Agregar tuplas a las lista puntajeTemas

        return puntajeTemas;
    }

    
    /**
     * Calcula el tiempo promedio en responder todas las preguntas
     * @param respuestas Lista de respuestas que contienen tema, respuesta y el
     * tiempo ejecutado en responder
     * @return Un float con el tiempo promedio de respuesta
     */
    public float calcularTiempoPromedioEspecifico(List<Tripla<String, Boolean, Float>> respuestas) {        
        float tiempos=0;
        for(int i=0; i<respuestas.size();i++){
            tiempos+=respuestas.get(i).getElem3();
        }
        float promedio=tiempos/respuestas.size();
        return promedio;
    }

    
    /**
     *
     * @return
     */
    public float calcularTematicaMasAcertada() {
        return 0;
    }

    /**
     *
     * @return
     */
    public float calcularTematicaMasFallada() {
        return 0;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public float getPuntajeJugador() {
        return puntajeJugador;
    }

    /**
     *
     * @param puntajeJugador
     */
    public void setPuntajeJugador(float puntajeJugador) {
        this.puntajeJugador = puntajeJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", puntajeJugador=" + puntajeJugador + '}';
    }

}
