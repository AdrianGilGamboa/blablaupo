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

/**
 *
 * @author adrii_gil99
 */
public class eliminarReserva extends ActionSupport {
    
    List<Viajes> listaMisViajes = new ArrayList<>();
        List<Reservas> listaReservas = new ArrayList<>();
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private ViajesDAO daoViajes = new ViajesDAO();
    private ReservasDAO daoReservas = new ReservasDAO();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Viajes> getListaMisViajes() {
        return listaMisViajes;
    }

    public void setListaMisViajes(List<Viajes> listaMisViajes) {
        this.listaMisViajes = listaMisViajes;
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
    
    
    
    public eliminarReserva() {
    }
    
    public String execute() throws Exception {
       listaReservas = daoReservas.list();
       Usuarios usu = (Usuarios) session.getAttribute("usuario");
        System.out.println(id);
        for (Reservas r : listaReservas) {
            System.out.println("Hola");
            if (r.getViajes().getIdViaje().equals(id) && usu.getDni().equals(r.getUsuarios().getDni())) {
                daoReservas.delete(r);
            }
        }
        return SUCCESS;
    }
    
}
