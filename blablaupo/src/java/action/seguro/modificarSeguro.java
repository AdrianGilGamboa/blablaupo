/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.seguro;

import com.opensymphony.xwork2.ActionSupport;
import dao.SegurosDAO;
import entidades.Seguros;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author manum
 */
public class modificarSeguro extends ActionSupport {
     
     int idSeguro;
     private String empresa;
     private String tipo;
     private String descripcion;
     private SegurosDAO sDao = new SegurosDAO();
   HttpSession session = ServletActionContext.getRequest().getSession(false);

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public SegurosDAO getsDao() {
        return sDao;
    }

    public void setsDao(SegurosDAO sDao) {
        this.sDao = sDao;
    }
    
     
    public modificarSeguro() {
    }
    public String editar(){
        SegurosDAO daoSeguro = new SegurosDAO();
        Seguros s = daoSeguro.read(getIdSeguro());            
            s.setEmpresa(getEmpresa());
            s.setTipo(getTipo());
            s.setDescripcion(getDescripcion());
            daoSeguro.update(s);  
            
            return SUCCESS;
        
    }
    public String execute() throws Exception {
       
        return SUCCESS;
    }
    
}
