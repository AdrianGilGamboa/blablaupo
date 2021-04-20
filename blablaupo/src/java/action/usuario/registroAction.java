/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.usuario;

import com.opensymphony.xwork2.ActionSupport;
import entidades.Usuarios;

/**
 *
 * @author manum
 */
public class registroAction extends ActionSupport {
    Usuarios usuario = new Usuarios();
    
     private String dni;
     private String nombre;
     private String apellidos;
     private int telefono;
     private String email;
     private String password;
    public registroAction() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
