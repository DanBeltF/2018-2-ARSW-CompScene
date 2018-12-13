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
package edu.eci.arsw.compscene.controllers;

import edu.eci.arsw.compscene.model.Pregunta;
import edu.eci.arsw.compscene.services.CompSceneServices;

import edu.eci.arsw.compscene.services.CompSceneServicesException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author dbeltran
 */
@Service
//@CrossOrigin("*")
@RestController(value = "/preguntas")
public class CompSceneController {
    
    @Autowired
    private CompSceneServices compserv;
    
    /**
     *
     * @return la pregunta de seleccion multiple como CopyOnWriteArrayList
     */ 
    @RequestMapping(method = RequestMethod.GET, path = "/preguntas/psm")
    public ResponseEntity<?> getPreguntaSeleccion(){
        try {
            Pregunta t=compserv.getPreguntaSeleccion();

            return new ResponseEntity<>(compserv.getPreguntaSeleccion(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    
      /**
     *
     * @return Retorna las respuesta como un array
     */
    @RequestMapping(method = RequestMethod.GET, path = "/respuestas")
    public ResponseEntity<?> getRespuestas(){
        try {
            return new ResponseEntity<>(compserv.getRespuestas(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }  
      /**
     *
     * @return Retorna las respuesta como un array
     */
    @RequestMapping(method = RequestMethod.GET, path = "/resultados")
    public ResponseEntity<?> getResultados(){
        try {
            return new ResponseEntity<>(compserv.punteador(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }      
    
    /**
     *
     * @return la pregunta de verdadero o falso como CopyOnWriteArrayList
     */
    @RequestMapping(method = RequestMethod.GET,path = "/preguntas/pvf")
    public ResponseEntity<?> getPreguntaVerdaderoFalso(){
        try {
            return new ResponseEntity<>(compserv.getPreguntaVerdaderoFalso(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     *
     * @return la pregunta de rellenar como CopyOnWriteArrayList
     */
    @RequestMapping(method = RequestMethod.GET, path = "/preguntas/pr")
    public ResponseEntity<?> getPreguntaRellenar(){
        try {
            return new ResponseEntity<>(compserv.getPreguntaRellenar(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    
    
        /**
     *
     * @return la pregunta de rellenar como CopyOnWriteArrayList
     */
    @RequestMapping(method = RequestMethod.GET, path = "/preguntas/jugadores")
    public ResponseEntity<?> getAllJugadores(){
        try {

            return new ResponseEntity<>(compserv.allJugadores(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
        @RequestMapping(method = RequestMethod.GET, path = "/prueba")
    public ResponseEntity<?> getAllresponse(){
        try {
   
            return new ResponseEntity<>(compserv.punteador(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(CompSceneController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    //@PathVariable String user
    @PostMapping(path = "/respuestas/concretas/{respuesta}/{idp}")
    public void setRespuesta(@PathVariable("respuesta") String respuesta, @PathVariable("idp") int idp){
           System.out.println("LA RESPUESTA ES"+respuesta+"pDSDSADSA"+idp);
           System.out.println("LA RESPUESTA ES"+respuesta+"PUYA"+idp);
           
    }
    @PostMapping(path = "/tiempo")
    public void setTiempo(@RequestBody String tiempo){

           System.out.println("el tiempo es"+tiempo);
    }
}