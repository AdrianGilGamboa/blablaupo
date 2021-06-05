/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.viaje;

import com.opensymphony.xwork2.ActionSupport;
import dao.SegurosDAO;
import dao.ViajesDAO;
import entidades.Usuarios;
import entidades.Viajes;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class crearViaje extends ActionSupport {

    HttpSession session = ServletActionContext.getRequest().getSession(false);
    ViajesDAO daoViajes = new ViajesDAO();
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private Float coste;
    private int numPasajeros;
    private String seguro;

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public ViajesDAO getDaoViajes() {
        return daoViajes;
    }

    public void setDaoViajes(ViajesDAO daoViajes) {
        this.daoViajes = daoViajes;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Float getCoste() {
        return coste;
    }

    public void setCoste(Float coste) {
        this.coste = coste;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public crearViaje() {
    }

    public String execute() throws Exception {
        Viajes v = new Viajes();
        v.setCoste(coste);
        v.setOrigen(origen);
        v.setDestino(destino);
        v.setHoraLlegada(fechaLlegada);
        v.setHoraSalida(fechaSalida);
        v.setNumPasajeros(numPasajeros);
        Usuarios u = (Usuarios) session.getAttribute("usuario");
        v.setUsuarios(u);
        SegurosDAO daoSeguros = new SegurosDAO();
        if (daoSeguros.readTipo(seguro) != null) {
            v.setSeguros(daoSeguros.readTipo(seguro));
            daoViajes.create(v);
        }else{
            return ERROR;
        }
        return SUCCESS;
    }

}
