/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.usuario;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.UsuariosDAO;
import entidades.Usuarios;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author manum
 */
public class accionLogin extends ActionSupport {
    private String email;
     private String password;
     private Usuarios u;
     private UsuariosDAO dao = new UsuariosDAO();

    public Usuarios getU() {
        return u;
    }

    public void setU(Usuarios u) {
        this.u = u;
    }

    public UsuariosDAO getDao() {
        return dao;
    }

    public void setDao(UsuariosDAO dao) {
        this.dao = dao;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    
    public accionLogin() {
    }
    
     public String login(){
         u = dao.comprobarLogin(this. getEmail(),this.getPassword());
           if(u== null)
            return ERROR;
           else{
               return SUCCESS;
           }
    }
     
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
