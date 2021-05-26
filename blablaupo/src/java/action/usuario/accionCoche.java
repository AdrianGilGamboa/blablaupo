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
 * @author manum
 */
public class accionCoche extends ActionSupport {
    private String matricula;
    private String marca;
    private String color;
    private String modelo;
    private Usuarios u;
    private UsuariosDAO dao = new UsuariosDAO();
    private Coche c = new Coche();
    private CocheDAO cocheDAO = new CocheDAO();
     HttpSession session = ServletActionContext.getRequest().getSession(false);

    public Coche getC() {
        return c;
    }

    public void setC(Coche c) {
        this.c = c;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

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
    
    public accionCoche() {
    }
    
    public String crearCoche(){
        u = (Usuarios) session.getAttribute("usuario");
        c.setMatricula(getMatricula());
        c.setColor(getColor());
        c.setModelo(getModelo());
        c.setMarca(getMarca());
        c.setUsuarios(u);
        dao.create(u);
        cocheDAO.create(c);
        return SUCCESS;
    }
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public void validate() {      
        if (this.getMatricula().equals("")){
            addFieldError("matricula", "Matricula is required.");
        }
        
        if(this.getMarca().equals("")){
            addFieldError("color", "Matricula is required.");
        }
        
        if(this.getColor().equals("")){
            addFieldError("marca", "Matricula is required.");
        }
        
        if(this.getModelo().equals("")){
            addFieldError("modelo", "Matricula is required.");
        }
     }
    
}
