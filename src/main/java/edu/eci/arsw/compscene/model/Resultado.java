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

import edu.eci.arsw.compscene.persistence.impl.Tupla;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author dcastiblanco
 */
public class Resultado {
    private int cantRespuestasCorrectas;

    /**
     * Constructor de resultado
     * @param cantRespuestasCorrectas
     */
    public Resultado(int cantRespuestasCorrectas) {
        this.cantRespuestasCorrectas = cantRespuestasCorrectas;
    }
    
    
    /**
     * Calcula el puntaje general por tema, obtenido por todos los jugadores
     * @param puntajeTema Lista de puntajes de cada jugador por tema
     * @return Puntaje general por tema
     */
    public float calcularPuntajeGeneral(List<Tupla<String,Float>> puntajeTema){
        for(int i=0; i<puntajeTema.size(); i++){
            
        }
        return 0;
    }
    
    /**
     *
     * @param tiempos
     * @return
     */
    public Timer calcularTiempoPromedioRespuestaGeneral(List<Timer> tiempos){
        return new Timer();
    }

    /**
     *
     * @return
     */
    public int getCantRespuestasCorrectas() {
        return cantRespuestasCorrectas;
    }

    /**
     *
     * @param cantRespuestasCorrectas
     */
    public void setCantRespuestasCorrectas(int cantRespuestasCorrectas) {
        this.cantRespuestasCorrectas = cantRespuestasCorrectas;
    }
    
    
}
