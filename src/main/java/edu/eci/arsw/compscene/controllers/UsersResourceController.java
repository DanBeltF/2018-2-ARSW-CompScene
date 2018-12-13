/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.compscene.controllers;


import com.google.gson.Gson;
import edu.eci.arsw.compscene.model.Jugador;
import edu.eci.arsw.compscene.mom.STOMPMessagesHandler;
import edu.eci.arsw.compscene.services.CompSceneServices;
import edu.eci.arsw.compscene.services.CompSceneServicesException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping("/question")
public class UsersResourceController {
private static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(STOMPMessagesHandler.class);
    @Autowired
    private CompSceneServices compserv;
    
    /**
     * 
     * @param user
     * @return 
     */
    @RequestMapping(path = "/{user}",method = RequestMethod.GET)
    public ResponseEntity<?> getUsuario(@PathVariable String user) {
        try {
            //Obtener datos
            return new ResponseEntity<>(compserv.getJUgador(user), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(UsersResourceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * 
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsuarios() {
        try {
            //Obtener datos
            
            List<String> k=compserv.allJugadores();
            for(int i=0;i<k.size();i++){
                String j=k.get(i);
                System.out.println("mmiremos"+j);
            
            }
            
            
            return new ResponseEntity<>(compserv.allJugadores(), HttpStatus.ACCEPTED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(UsersResourceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
    /**
     * 
     * @param u
     * @return 
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUsuario(@RequestBody String u) {
        try {
            
            Gson gson = new Gson();
            logger.info("llegamos");
            Jugador p =gson.fromJson(u,Jugador.class );
            System.out.println("adicionamos"+p);
            System.out.println("a quien metimos"+p.getNombre());
            //Registrar dato
            compserv.addJugador(p.getNombre());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(UsersResourceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }

    }
    

    
    /**
     * 
     * @param user
     * @return 
     */
    @RequestMapping(path = "/{user}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUsuario(@PathVariable String user) {
        try {
            //Borrar dato
            compserv.deleteJugador(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CompSceneServicesException ex) {
            Logger.getLogger(UsersResourceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


    
    
}
