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
 * @author dbeltran
 */
public class Resultado {
    private int cantRespuestasCorrectas;

    public Resultado(int cantRespuestasCorrectas) {
        this.cantRespuestasCorrectas = cantRespuestasCorrectas;
    }
    
    public float calcularPuntajeGeneral(List<Tupla<String,Float>> puntajeTema){
        return 0;
    }
    
    public Timer calcularTiempoPromedioRespuestaGeneral(List<Timer> tiempos){
        return new Timer();
    }

    public int getCantRespuestasCorrectas() {
        return cantRespuestasCorrectas;
    }

    public void setCantRespuestasCorrectas(int cantRespuestasCorrectas) {
        this.cantRespuestasCorrectas = cantRespuestasCorrectas;
    }
    
    
}
