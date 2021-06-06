/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.usuario;

import com.opensymphony.xwork2.ActionSupport;
import dao.CocheDAO;
import dao.ReservasDAO;
import dao.UsuariosDAO;
import dao.ValoracionesDAO;
import dao.ViajesDAO;
import entidades.Coche;
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
public class accionEliminar extends ActionSupport {

    HttpSession session = ServletActionContext.getRequest().getSession(false);
    private String dni;
    CocheDAO daoCoche = new CocheDAO();
    ValoracionesDAO daoValoraciones = new ValoracionesDAO();
    UsuariosDAO daoUsuarios = new UsuariosDAO();
    Usuarios usuario = (Usuarios) session.getAttribute("usuario");
    private ViajesDAO daoViajes = new ViajesDAO();
    private ReservasDAO daoReservas = new ReservasDAO();
    List<Viajes> listaViajes = new ArrayList<>();
    List<Reservas> listaReservas = new ArrayList<>();

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public CocheDAO getDaoCoche() {
        return daoCoche;
    }

    public void setDaoCoche(CocheDAO daoCoche) {
        this.daoCoche = daoCoche;
    }

    public UsuariosDAO getDaoUsuarios() {
        return daoUsuarios;
    }

    public void setDaoUsuarios(UsuariosDAO daoUsuarios) {
        this.daoUsuarios = daoUsuarios;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public accionEliminar() {
    }

    public String execute() throws Exception {
        Coche coche = daoCoche.readDniUsuario(usuario.getDni());
        if (coche != null) {
            daoCoche.delete(coche);
        }
        listaViajes = daoViajes.listPorDNIConductor(usuario.getDni());
        listaReservas = daoReservas.listDNIPasajero(usuario.getDni());
        for(Reservas r:listaReservas){
            
            if(daoValoraciones.readIDReserva(r.getIdReserva())==null){
                daoReservas.delete(r);
            }else{
                daoValoraciones.delete(daoValoraciones.readIDReserva(r.getIdReserva()));
            }                   
        }
        for(Viajes v:listaViajes){
            daoViajes.delete(v);
        }
        daoUsuarios.delete(usuario);
        session.invalidate();
        return SUCCESS;
    }

}
