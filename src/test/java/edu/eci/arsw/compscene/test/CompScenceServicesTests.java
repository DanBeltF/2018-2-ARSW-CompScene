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
package edu.eci.arsw.compscene.test;

import edu.eci.arsw.compscene.model.Cuestionario;
import edu.eci.arsw.compscene.model.Jugador;
import edu.eci.arsw.compscene.model.Pregunta;
import edu.eci.arsw.compscene.model.Resultado;
import edu.eci.arsw.compscene.model.impl.PreguntaRellenar;
import edu.eci.arsw.compscene.persistence.impl.Tripla;
import edu.eci.arsw.compscene.persistence.impl.Tupla;
import edu.eci.arsw.compscene.services.CompSceneServices;
import edu.eci.arsw.compscene.services.CompSceneServicesException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.maven.surefire.booter.ForkedBooter;
import org.assertj.core.groups.Tuple;
import org.junit.Assert;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertSame;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;

/**
 *
 * @author dbeltran
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CompScenceServicesTests {
    
    @Autowired
    private CompSceneServices compserv;
    private PreguntaRellenar pr;
        private PreguntaRellenar pr1;
    private List<String> respuestaCorrectaRellenar1;
    private  List<String> respuestaCorrectaRellenar;
    
    private List<Tripla<String, Boolean, Float>> respuestas;
    
    private List<Pregunta> listaPreguntas;
    private List<Jugador> jugador;
    @Test
    public void contextLoads() throws CompSceneServicesException {
    }
    
    @Test
    public void debeCrearCuestionario() throws CompSceneServicesException {
       
        
    }
    
    @Test
    public void modeloC()throws CompSceneServicesException {
        jugador= new CopyOnWriteArrayList<>();
        List<Tupla<String, Float>>puntajeTemas =new ArrayList<Tupla<String, Float>>();
          
        Tupla t=new Tupla("MATEMATICAS", 12.0);
        Tupla t1=new Tupla("Programacion", 15.0);
        Tupla t2=new Tupla("Logica", 5.0);        
        puntajeTemas.add(t);
        puntajeTemas.add(t1);
        puntajeTemas.add(t2);
        
        Jugador jug1= new Jugador (12, "Daniel",  12.2f, puntajeTemas);
        Jugador jug2= new Jugador (13, "beltran", 12.2f, puntajeTemas);
        Jugador jug3= new Jugador (15, "Cesar", 12.2f, puntajeTemas);
        respuestas = new CopyOnWriteArrayList<>();
        listaPreguntas= new CopyOnWriteArrayList<>();
        respuestaCorrectaRellenar= new CopyOnWriteArrayList<>();
        respuestaCorrectaRellenar.add("22.3");
        respuestaCorrectaRellenar.add("10");
        pr = new PreguntaRellenar(respuestaCorrectaRellenar,1,"Raiz cuadrada de 500 es {} y la de 100 es {}", "Matemática", null, 6.7f);
        pr1 = new PreguntaRellenar(respuestaCorrectaRellenar,1,"La derivada de x2 es {} ", "Matemática", null, 6.7f);
        respuestaCorrectaRellenar.add("2x");
        listaPreguntas.add(pr);
        //jugador
        jugador.add(jug1);
        jugador.add(jug2);
        jugador.add(jug3);
        List<Tripla<String, Boolean, Float>>  tripla=new CopyOnWriteArrayList<>(); 
        
        Tripla tr1=new Tripla ("LA matematica es delociosa",true,15.0f);
        Tripla tr2=new Tripla ("Esto es de otro mundo",false,12.0f);
        tripla.add(tr1);
        tripla.add(tr2);
        //Cuestionario c1= new Cuestionario(1, listaPreguntas, jugador,tripla);

//       assertSame("Sorpresa",jugador,c1.getJugadores());
        
    
    
    }
    
     @Test
    public void modeloJ()throws CompSceneServicesException {
        List<Tupla<String, Float>>puntajeTemas =new ArrayList<Tupla<String, Float>>();  
        Tupla t=new Tupla("MATEMATICAS", 12.0);
        Tupla t1=new Tupla("Programacion", 15.0);
        Tupla t2=new Tupla("Logica", 5.0);        
        puntajeTemas.add(t);
        puntajeTemas.add(t1);
        puntajeTemas.add(t2);
        List<Tripla<String, Boolean, Float>>  tripla=new CopyOnWriteArrayList<>(); 
        
        Tripla tr1=new Tripla ("LA matematica es delociosa",true,125.0f);
        Tripla tr2=new Tripla ("Esto es de otro mundo",false,11.0f);
        tripla.add(tr1);
        tripla.add(tr2);        
        
        Jugador j1=new Jugador(1, "Daniel",  5.0f, puntajeTemas);
    
         Assert.assertEquals(-25.0f, j1.calcularPuntajeEspecifico(tripla), 0);
        
    }
    @Test
    public void modeloR()throws CompSceneServicesException {
        Resultado re= new Resultado(12);
        
        
        List<Tupla<String, Float>>puntajeTemas =new ArrayList<Tupla<String, Float>>();  
        Tupla t=new Tupla("MATEMATICAS", 12.0f);
        Tupla t1=new Tupla("Programacion", 15.0f);
        Tupla t2=new Tupla("Logica", 5.0f);        
        puntajeTemas.add(t);
        puntajeTemas.add(t1);
        puntajeTemas.add(t2);
        Assert.assertEquals(32.0f, re.calcularPuntajeGeneral(puntajeTemas), 0);
        
    }
    
}
