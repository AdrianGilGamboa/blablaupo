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
     String id;
     int ide;
     private String empresa;
     private String tipo;
     private float descuento;
     private SegurosDAO sDao = new SegurosDAO();
   HttpSession session = ServletActionContext.getRequest().getSession(false);

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public SegurosDAO getsDao() {
        return sDao;
    }

    public void setsDao(SegurosDAO sDao) {
        this.sDao = sDao;
    }
    
     
    public modificarSeguro() {
    }
    
    public String execute() throws Exception {
        SegurosDAO seguroDAO = new SegurosDAO();
        Seguros seguro = new Seguros();
        seguro = seguroDAO.read(Integer.parseInt(getId()));
        seguro.setTipo(getTipo());
        seguro.setDescuento(getDescuento());
        seguro.setEmpresa(getEmpresa());
        sDao.update(seguro);
        return SUCCESS;
    }
    
}
