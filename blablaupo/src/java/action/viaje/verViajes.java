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
public class verViajes extends ActionSupport {

    ArrayList<Viajes> listaViajes = new ArrayList<>();
    List<Reservas> listaReservas2 = new ArrayList<Reservas>();
    List<Reservas> listaReservas = new ArrayList<Reservas>();
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    private ViajesDAO daoViajes = new ViajesDAO();
    private ReservasDAO daoReservas = new ReservasDAO();
    private int cont = 0;

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

    public ArrayList<Viajes> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(ArrayList<Viajes> listaViajes) {
        this.listaViajes = listaViajes;
    }

    @Override
    public void addActionError(String anErrorMessage) {
        super.addActionError(anErrorMessage); //To change body of generated methods, choose Tools | Templates.
    }

    public verViajes() {

    }

    public String execute() throws Exception {
        listaViajes = (ArrayList<Viajes>) daoViajes.list();
        listaReservas = daoReservas.distinctReservasIdViaje();

        long num;
        for (Reservas r : listaReservas) {
            if (!listaReservas2.contains(r)) {
                Usuarios usu = (Usuarios) session.getAttribute("usuario");
                num = daoReservas.contarReservasPorViaje(r);
                Viajes v = daoViajes.read(r.getViajes().getIdViaje());
                System.out.println("Entra?");
                System.out.println("borrando" + v.getIdViaje());
                                System.out.println("Numero: " + num+" pasajeros: "+v.getNumPasajeros());
                int i = 0;
                boolean encontrado = false;
                System.out.println("tam lista viajes:"+listaViajes.size());
                while (!encontrado && i < listaViajes.size()) {
                    System.out.println("DNI: " + usu.getDni() + "---" + r.getUsuarios().getDni());
                    if (usu.getDni().equals(r.getUsuarios().getDni()) || v.getNumPasajeros() == num) {
                        System.out.println("Borrar: " + i + "--");
                        listaViajes.remove(i);
                        listaReservas2.add(r);
                        encontrado = true;
                    }
                    i++;
                }
                //listaReservas.remove(r);
            }

        }
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
       /* listaViajes = (ArrayList<Viajes>) daoViajes.list();
        listaReservas2.clear();
        listaReservas = daoReservas.distinctReservasIdViaje();
        for (Reservas r : listaReservas) {
            if (!listaReservas2.contains(r)) {
                Usuarios usu = (Usuarios) session.getAttribute("usuario");
                num = daoReservas.contarReservasPorViaje(r);
                Viajes v = daoViajes.read(r.getViajes().getIdViaje());
                System.out.println("Entra?");
                System.out.println("borrando" + v.getIdViaje());
                                System.out.println("Numero: " + num+" pasajeros: "+v.getNumPasajeros());
                int i = 0;
                boolean encontrado = false;
                System.out.println("tam lista viajes:"+listaViajes.size());
                while (!encontrado && i < listaViajes.size()) {
                    System.out.println("DNI: " + usu.getDni() + "---" + r.getUsuarios().getDni());
                    if (v.getNumPasajeros() == num) {
                        System.out.println("Borrar: " + i + "--");
                        listaViajes.remove(i);
                        listaReservas2.add(r);
                        encontrado = true;
                    }
                    i++;
                }
                //listaReservas.remove(r);
            }

        }*/
        
        /*Usuarios usu = (Usuarios) session.getAttribute("usuario");
            System.out.println(r.getUsuarios().getDni());
            System.out.println(usu.getDni());
            if (r.getUsuarios().getDni().equals(usu.getDni()) ) {
                Viajes v = daoViajes.read(r.getViajes().getIdViaje());
                System.out.println(v.getNumPasajeros());
                //if (listaReservas.contains(v)) {
                    listaViajes.remove(v);
               // }
            }
            num++;*/

        session.removeAttribute("viajes");
        session.setAttribute("viajes", listaViajes);
        return SUCCESS;
    }

}
