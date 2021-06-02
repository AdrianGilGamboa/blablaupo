/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.usuario;

import com.mchange.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;
import dao.AnunciosDAO;
import entidades.Anuncios;
import freemarker.core.ParseException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author manum
 */
public class accionAnuncio extends ActionSupport {


    private float coste;
    private String anunciante;
    private Date fechaInicio;
    private Date fechaFin;
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private AnunciosDAO anuncioDAO;
    private Anuncios anuncio = new Anuncios();
    private String multimedia;
    private String fotoPerfilContentType;
    private String fotoPerfilFileName;

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

    
    public Anuncios getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncios anuncio) {
        this.anuncio = anuncio;
    }

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

    public accionAnuncio() {
    }

    public String crearAnuncio() throws ParseException, IOException, java.text.ParseException {
        
        anuncio.setCoste(getCoste());
        SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
        anuncio.setFechaInicio(parseador.parse(parseador.format(getFechaInicio())));
        anuncio.setFechaFin(parseador.parse(parseador.format(getFechaFin())));
        anuncio.setAnunciante(getAnunciante());
        anuncio.setMultimedia(getMultimedia());
        anuncioDAO.create(anuncio);
        return SUCCESS;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

}

    

