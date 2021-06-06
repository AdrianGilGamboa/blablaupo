/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.viaje;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.ReservasDAO;
import dao.ValoracionesDAO;
import dao.ViajesDAO;
import entidades.Reservas;
import entidades.Usuarios;
import entidades.Viajes;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class viajesReservados extends ActionSupport {

    List<Viajes> listaMisViajesReservados = new ArrayList<>();
    List<Reservas> listaReservas = new ArrayList<Reservas>();
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private ViajesDAO daoViajes = new ViajesDAO();
    private ReservasDAO daoReservas = new ReservasDAO();

    public List<Viajes> getListaMisViajesReservados() {
        return listaMisViajesReservados;
    }

    public void setListaMisViajesReservados(List<Viajes> listaMisViajesReservados) {
        this.listaMisViajesReservados = listaMisViajesReservados;
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

    public viajesReservados() {
    }

    public String execute() throws Exception {
        Usuarios usu = (Usuarios) session.getAttribute("usuario");
        listaReservas = daoReservas.listDNIPasajero(usu.getDni());
        List<Reservas> sinvalorar = new ArrayList<>();
        /*
        ValoracionesDAO daoValoraciones = new ValoracionesDAO();
        for (Reservas r : listaReservas) {
                Viajes v = daoViajes.read(r.getViajes().getIdViaje());
                if(daoValoraciones.readIDReserva(r.getIdReserva())==null){
                listaMisViajesReservados.add(v);
                }
        }
        setListaMisViajesReservados(listaMisViajesReservados);*/
        
        ValoracionesDAO daoValoraciones = new ValoracionesDAO();
        for(Reservas r: listaReservas){
            if(daoValoraciones.readIDReserva(r.getIdReserva()) == null){
                sinvalorar.add(r);
            }
        }
        setListaReservas(sinvalorar);
        return SUCCESS;
    }

}
