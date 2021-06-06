/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.viaje;

import com.opensymphony.xwork2.ActionSupport;
import dao.ReservasDAO;
import dao.ViajesDAO;
import entidades.Reservas;
import entidades.Usuarios;
import entidades.Viajes;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class eliminarViaje extends ActionSupport {

    List<Viajes> listaMisViajes = new ArrayList<>();
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private ViajesDAO daoViajes = new ViajesDAO();
    private ReservasDAO daoReservas = new ReservasDAO();
    List<Viajes> listaViajes = new ArrayList<>();
    List<Reservas> listaReservas = new ArrayList<>();
    private int id;

    public List<Viajes> getListaMisViajes() {
        return listaMisViajes;
    }

    public void setListaMisViajes(List<Viajes> listaMisViajes) {
        this.listaMisViajes = listaMisViajes;
    }

    public List<Viajes> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(List<Viajes> listaViajes) {
        this.listaViajes = listaViajes;
    }

    public List<Reservas> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reservas> listaReservas) {
        this.listaReservas = listaReservas;
    }

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

    public eliminarViaje() {
    }

    public String execute() throws Exception {
        listaReservas = daoReservas.list();
        System.out.println(id);
        for (Reservas r : listaReservas) {
            if (r.getViajes().getIdViaje().equals(id)) {
                daoReservas.delete(r);
            }
        }
        Viajes v = daoViajes.read(id);
        daoViajes.delete(v);
        Usuarios usu = (Usuarios) session.getAttribute("usuario");
        listaMisViajes = daoViajes.listPorDNIConductor(usu.getDni());
        setListaMisViajes(listaMisViajes);
        return SUCCESS;
    }

}
