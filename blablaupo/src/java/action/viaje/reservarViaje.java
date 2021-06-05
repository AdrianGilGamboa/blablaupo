/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.viaje;

import com.opensymphony.xwork2.ActionSupport;
import dao.CuponesDAO;
import dao.ReservasDAO;
import dao.ViajesDAO;
import entidades.Cupones;
import entidades.Reservas;
import entidades.Usuarios;
import entidades.Viajes;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;


public class reservarViaje extends ActionSupport {

    HttpSession session = ServletActionContext.getRequest().getSession(false);
    private int id;
    private String cupon;
    ViajesDAO daoViajes = new ViajesDAO();
    ReservasDAO daoReservas = new ReservasDAO();

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
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

    public reservarViaje() {
    }

    public String execute() throws Exception {
        System.out.println(cupon);
        Viajes via = new Viajes();
        via = daoViajes.read(id);
        Reservas res = new Reservas();
        CuponesDAO daoCupones = new CuponesDAO();
        Cupones cup = new Cupones();
        cup = daoCupones.read(cupon);
        if (cup == null) {
            res.setCosteFinal(via.getCoste());
        } else {
            res.setCosteFinal(via.getCoste() * (1-(cup.getDescCupon() / 100)));
            res.setCupones(cup);
        }

        res.setFReserva(via.getHoraSalida());
        Usuarios usu = (Usuarios) session.getAttribute("usuario");
        res.setUsuarios(usu);
        res.setViajes(via);
        System.out.println(daoReservas.readUnique(id, usu.getDni()));
        if(daoReservas.readUnique(id, usu.getDni())==null){
        daoReservas.create(res);
        }
        return SUCCESS;
    }

}
