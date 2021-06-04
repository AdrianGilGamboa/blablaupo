/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.seguro;

import com.opensymphony.xwork2.ActionSupport;
import dao.SegurosDAO;
import entidades.Seguros;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author manum
 */
public class verSeguro extends ActionSupport {
     private List<Seguros> lista = new ArrayList();
     private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private SegurosDAO seguroDAO = new SegurosDAO();

    public List<Seguros> getLista() {
        return lista;
    }

    public void setLista(List<Seguros> lista) {
        this.lista = lista;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public SegurosDAO getSeguroDAO() {
        return seguroDAO;
    }

    public void setSeguroDAO(SegurosDAO seguroDAO) {
        this.seguroDAO = seguroDAO;
    }
    
    
    public verSeguro() {
    }
    
    public String verSeguros(){
        lista = seguroDAO.list();
        session.setAttribute("listaSeguros", lista);
        return SUCCESS;
        
        
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
