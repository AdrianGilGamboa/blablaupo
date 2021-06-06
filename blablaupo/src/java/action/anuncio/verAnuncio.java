/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.anuncio;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.AnunciosDAO;
import entidades.Anuncios;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;


public class verAnuncio extends ActionSupport {
    List<Anuncios> lista = new ArrayList();
     private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private AnunciosDAO anuncioDAO = new AnunciosDAO();

    public List<Anuncios> getLista() {
        return lista;
    }

    public void setLista(List<Anuncios> lista) {
        this.lista = lista;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public AnunciosDAO getAnuncioDAO() {
        return anuncioDAO;
    }

    public void setAnuncioDAO(AnunciosDAO anuncioDAO) {
        this.anuncioDAO = anuncioDAO;
    }
    
    public verAnuncio() {
    }
    
    public String verAnuncio(){
                Anuncios anuncio = new Anuncios();
        lista = anuncioDAO.list();
        setLista(lista);
        session.setAttribute("lista", lista);
        return SUCCESS;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
