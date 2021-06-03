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
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author manum
 */
public class eliminarAnuncio extends ActionSupport {
    int id;
    private float coste;
    private String anunciante;
    private Date fechaInicio;
    private Date fechaFin;
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private AnunciosDAO anuncioDAO = new AnunciosDAO();
    private String multimedia;
    private String fotoPerfilContentType;
    private String fotoPerfilFileName;
    private List<Anuncios> lista = new ArrayList();

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public String getFotoPerfilContentType() {
        return fotoPerfilContentType;
    }

    public void setFotoPerfilContentType(String fotoPerfilContentType) {
        this.fotoPerfilContentType = fotoPerfilContentType;
    }

    public String getFotoPerfilFileName() {
        return fotoPerfilFileName;
    }

    public void setFotoPerfilFileName(String fotoPerfilFileName) {
        this.fotoPerfilFileName = fotoPerfilFileName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Anuncios> getLista() {
        return lista;
    }

    public void setLista(List<Anuncios> lista) {
        this.lista = lista;
    }

    public eliminarAnuncio() {
    }
    
    
    public String borrarAnuncio(){
        List a = new ArrayList();
        a = (List) session.getAttribute("lista");
        System.out.println(anuncioDAO.read(this.id));
            Anuncios anuncio = anuncioDAO.read(this.id);
                anuncioDAO.delete(anuncio);

        return SUCCESS;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
