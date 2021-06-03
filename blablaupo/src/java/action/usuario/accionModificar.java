/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.usuario;

import static action.usuario.accionRegistro.COCHE;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.CocheDAO;
import dao.UsuariosDAO;
import entidades.Usuarios;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author adrii_gil99
 */
public class accionModificar extends ActionSupport {

    public static final String COCHE = "coche";
    Usuarios usuario = new Usuarios();
    UsuariosDAO dao = new UsuariosDAO();
    HttpSession session = ServletActionContext.getRequest().getSession(false);

    private String dni;
    private int telefono;
    private String password;

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPasswordNueva() {
        return passwordNueva;
    }

    public void setPasswordNueva(String passwordNueva) {
        this.passwordNueva = passwordNueva;
    }
    private String tipo;
    private String passwordNueva;

    public accionModificar() {
    }

    public String execute() throws Exception {
        usuario = (Usuarios) session.getAttribute("usuario");
        if (usuario.getPassword().equals(this.getPassword())) {
            usuario.setTelefono(getTelefono());
            if (getPasswordNueva().length() != 0) {
                usuario.setPassword(getPasswordNueva());
            }
            if (!usuario.getTipo().equals(this.getTipo())) {
                if (getTipo().equals("Si")) {
                    usuario.setTipo("Si");
                    dao.update(usuario);
                    return COCHE;
                } else {
                    usuario.setTipo("No");
                    CocheDAO daoCoche = new CocheDAO();
                    daoCoche.delete(daoCoche.readDniUsuario(usuario.getDni()));
                }
            }
            dao.update(usuario);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
