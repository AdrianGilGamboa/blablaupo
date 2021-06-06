/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.viaje;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservasDAO;
import dao.ValoracionesDAO;
import dao.ViajesDAO;
import entidades.Reservas;
import entidades.Usuarios;
import entidades.Valoraciones;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class crearValoracion extends ActionSupport {

     HttpSession session = ServletActionContext.getRequest().getSession(false);
    private int id;
    private int puntuacion;
    private String descripcion;
    ValoracionesDAO daoValoraciones = new ValoracionesDAO();
    ViajesDAO daoViajes = new ViajesDAO();
    ReservasDAO daoReservas = new ReservasDAO();

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public ValoracionesDAO getDaoValoraciones() {
        return daoValoraciones;
    }

    public void setDaoValoraciones(ValoracionesDAO daoValoraciones) {
        this.daoValoraciones = daoValoraciones;
    }

    public ViajesDAO getDaoViajes() {
        return daoViajes;
    }

    public void setDaoViajes(ViajesDAO daoViajes) {
        this.daoViajes = daoViajes;
    }

    public ReservasDAO getDaoReservas() {
        return daoReservas;
    }

    public void setDaoReservas(ReservasDAO daoReservas) {
        this.daoReservas = daoReservas;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public crearValoracion() {
    }
    
    public String guardarId(){
        session.setAttribute("idV", id);
        return SUCCESS;
    }

    public String execute() throws Exception {
        System.out.println("El id del viaje es: " + id);
        System.out.println("El id del viaje es: " + session.getAttribute("idV"));
        Valoraciones val = new Valoraciones();
        val.setDescripcion(descripcion);
        val.setPuntuacion(puntuacion);
        Usuarios usu = (Usuarios) session.getAttribute("usuario");
        Reservas res = daoReservas.readUnique((Integer) session.getAttribute("idV"), usu.getDni());
        val.setReservas(res);
        daoValoraciones.create(val);
        return SUCCESS;
    }

}
