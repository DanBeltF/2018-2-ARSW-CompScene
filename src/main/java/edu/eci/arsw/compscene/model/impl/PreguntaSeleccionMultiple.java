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
package edu.eci.arsw.compscene.model.impl;

import edu.eci.arsw.compscene.model.Pregunta;
import java.util.List;

/**
 *
 * @author dbeltran
 */
public class PreguntaSeleccionMultiple extends Pregunta{
    
    private int respuestaCorrecta;

    public PreguntaSeleccionMultiple(int respuestaCorrecta, int id, String enunciado, String tema, List<String> opcionesDeRespuesta, Float tiempo) {
        super(id, enunciado, tema, opcionesDeRespuesta, tiempo);
                                    //lista de String hay 4 string(opciones)
                                    //la respuesta correcta esta en la poscicion x
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override                       //tipo entero               tipo entero
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta) {
        Boolean respuesta=false;
        int respJUgador=(int)respuestaJugador;
        int respCorrecta=(int)this.respuestaCorrecta;
        List<String> re=getOpcionesDeRespuesta();        
        if((re.get(respJUgador).equals(re.get(respCorrecta)))&& respJUgador==respCorrecta){
            respuesta=true;
        }

        return respuesta;
    }

    @Override
    public Object getRespuestaJugador() {
        return super.getRespuestaJugador(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setRespuestaJugador(Object ob){
        super.setRespuestaJugador(ob);
    }    
    @Override
    public void setTiempo(Float tiempo) {
        super.setTiempo(tiempo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float getTiempo() {
        return super.getTiempo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOpcionesDeRespuesta(List<String> opcionesDeRespuesta) {
        super.setOpcionesDeRespuesta(opcionesDeRespuesta); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getOpcionesDeRespuesta() {
        return super.getOpcionesDeRespuesta(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTema(String tema) {
        super.setTema(tema); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTema() {
        return super.getTema(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEnunciado(String enunciado) {
        super.setEnunciado(enunciado); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEnunciado() {
        return super.getEnunciado(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    
    @Override
    public String toString() {
        return super.toString();
    }
}
