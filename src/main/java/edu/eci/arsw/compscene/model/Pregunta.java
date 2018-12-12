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

import java.util.List;

/**
 *
 * @author dbeltran
 */
public abstract class Pregunta {
    
    private int id;
    private String enunciado;
    private String tema;
    private List<String> opcionesDeRespuesta;
    private Float tiempo;
    private Object respJUgador;

    public Pregunta(int id, String enunciado, String tema, List<String> opcionesDeRespuesta, Float tiempo) {
        this.id = id;
        this.enunciado = enunciado;
        this.tema = tema;
        this.opcionesDeRespuesta = opcionesDeRespuesta;
        this.tiempo = tiempo;
        this.respJUgador=null;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<String> getOpcionesDeRespuesta() {
        return opcionesDeRespuesta;
    }

    public void setOpcionesDeRespuesta(List<String> opcionesDeRespuesta) {
        this.opcionesDeRespuesta = opcionesDeRespuesta;
    }

    public Float getTiempo() {
        return tiempo;
    }

    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }
    
    public Object getRespuestaJugador(){
        return respJUgador;
    }
    public void setRespuestaJugador(Object ob){
        respJUgador=ob;
    }    
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta){
        return false;
    }
    
}
