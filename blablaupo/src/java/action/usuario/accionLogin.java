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
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class accionLogin extends ActionSupport {

    private String email;
    private String password;
    private Usuarios u;
    private UsuariosDAO dao = new UsuariosDAO();
    HttpSession session = ServletActionContext.getRequest().getSession(false);

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

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
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
           if(u== null){
            addFieldError("login", getText("login.login"));                  
            return ERROR;

             }
           

         else{

               session.setAttribute("logado", "si");
               session.setAttribute("usuario", u);
               return SUCCESS;
           }

   

    }   
  

     
     
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public void validate() { 
        if (this.getEmail().equals("")){
            addFieldError("email", getText("login.email"));
        }
        if (this.getPassword().equals("")){
            addFieldError("password", getText("login.password"));
        }
    }
}
