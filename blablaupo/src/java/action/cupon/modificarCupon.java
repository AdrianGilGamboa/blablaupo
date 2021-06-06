package action.cupon;

import com.opensymphony.xwork2.ActionSupport;
import dao.CuponesDAO;
import entidades.Cupones;
import java.util.Date;

public class modificarCupon extends ActionSupport {

    private String numeroCupon;
    private float descCupon;
    private Date fechaInicio;
    private Date fechaFin;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroCupon() {
        return numeroCupon;
    }

    public void setNumeroCupon(String numeroCupon) {
        this.numeroCupon = numeroCupon;
    }

    public float getDescCupon() {
        return descCupon;
    }

    public void setDescCupon(float descCupon) {
        this.descCupon = descCupon;
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

    public modificarCupon() {
    }

    public String editar() {
        CuponesDAO daoCupon = new CuponesDAO();
        Cupones c = daoCupon.read(getId());
        if (!getId().equals(getNumeroCupon())) {
            daoCupon.delete(c);
            Cupones aux = new Cupones();
            aux.setNumeroCupon(getNumeroCupon());            
            aux.setDescCupon(getDescCupon());
            aux.setNumeroCupon(getNumeroCupon());
            aux.setFechaInicio(getFechaInicio());
            aux.setFechaFin(getFechaFin());
            daoCupon.create(aux);
        } else {
            c.setDescCupon(getDescCupon());
            c.setFechaInicio(getFechaInicio());
            c.setFechaFin(getFechaFin());
            daoCupon.update(c);
        }
        return SUCCESS;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
    
        public void validate() {
        if (this.getNumeroCupon().equals("")) {
            addFieldError("numeroCupon", getText("cupon.codigo"));
        }
        if (this.getDescCupon()== 0) {
            addFieldError("descCupon", getText("cupon.descuento"));
        }
        if (this.getFechaInicio() == null) {
            addFieldError("fechaInicio", getText("anuncio.fechaInicio"));
        }
        if (this.getFechaFin() == null) {
            addFieldError("fechaFin", getText("anuncio.fechaFin"));
        }
    }

}
