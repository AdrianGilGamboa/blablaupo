package action.cupon;

import com.opensymphony.xwork2.ActionSupport;
import dao.CuponesDAO;
import entidades.Cupones;
import java.util.*;


public class crearCupon extends ActionSupport {
    private String codigo;
    private float descuento;
    private Date fechaInicio;
    private Date fechaFin;

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

   
    
    public crearCupon() {
    }
    
    public String execute() throws Exception {
        CuponesDAO daoCupon = new CuponesDAO();
        Cupones c = new Cupones();
         System.out.println("FECHA Inicio:_______"+getFechaInicio());
         System.out.println("FECHA Inicio:_______"+getFechaFin());
         System.out.println("DESCUENTO Inicio:_______"+getDescuento());
        c.setNumeroCupon(getCodigo());
        c.setDescCupon(getDescuento());
        c.setFechaInicio(getFechaInicio());
        c.setFechaFin(getFechaFin());
        daoCupon.create(c);
        return SUCCESS;
                
    }
    
}
