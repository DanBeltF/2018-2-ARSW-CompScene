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

/**
 *
 * @author dcastiblanco
 */
public class Resultado {
    private int cantRespuestasCorrectas;

    /**
     * Constructor de resultado
     * @param cantRespuestasCorrectas - cantidad de respuestas correctas por todos los usuarios
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
        float puntajeGeneral=0;
        for(int i=0; i<puntajeTema.size(); i++){
            puntajeGeneral+=puntajeTema.get(i).getElem2();
        }
        return puntajeGeneral;
    }
    
    
    /**
     * Calcula el tiempo promedio de respuesta general
     * @param tiempos - tiempos tomados por cada usuario
     * @return Tiempo promedio de respuesta general
     */
    public float calcularTiempoPromedioRespuestaGeneral(List<Float> tiempos){
        float total=0;
        for (int i=0; i<tiempos.size();i++){
            total+=tiempos.get(i);
        }
        float promedio = total/tiempos.size();
        return promedio;
    }
    

    /**
     * Obtiene las respuestas correctas
     * @return Respuestas correctas
     */ 
    public int getCantRespuestasCorrectas() {
        return cantRespuestasCorrectas;
    }

    /**
     * Configura respuestas correctas
     * @param cantRespuestasCorrectas - cantidad de respuestas correctas por el grupo
     */
    public void setCantRespuestasCorrectas(int cantRespuestasCorrectas) {
        this.cantRespuestasCorrectas = cantRespuestasCorrectas;
    }

    @Override
    public String toString() {
        return "Resultado{" + "cantRespuestasCorrectas=" + cantRespuestasCorrectas + '}';
    }
    
    
    
}
