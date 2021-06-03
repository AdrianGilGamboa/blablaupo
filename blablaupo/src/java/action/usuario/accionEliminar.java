/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.usuario;

import com.opensymphony.xwork2.ActionSupport;
import dao.CocheDAO;
import dao.UsuariosDAO;
import entidades.Coche;
import entidades.Usuarios;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author adrii_gil99
 */
public class accionEliminar extends ActionSupport {

    HttpSession session = ServletActionContext.getRequest().getSession(false);
    private String dni;
    CocheDAO daoCoche = new CocheDAO();
    UsuariosDAO daoUsuarios = new UsuariosDAO();
    Usuarios usuario = (Usuarios) session.getAttribute("usuario");

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public accionEliminar() {
    }

    public String execute() throws Exception {
        Coche coche = daoCoche.readDniUsuario(usuario.getDni());
        if (coche != null) {
            daoCoche.delete(coche);
        }
        daoUsuarios.delete(usuario);
        session.invalidate();
        return SUCCESS;
    }

}
