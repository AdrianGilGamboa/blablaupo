package action.cupon;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.AnunciosDAO;
import dao.CuponesDAO;
import entidades.Anuncios;
import entidades.Cupones;


public class eliminarCupon extends ActionSupport {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public eliminarCupon() {
    }
    
    public String execute() throws Exception {
          Cupones c = new Cupones();
        CuponesDAO cuponesDAO = new CuponesDAO();
        Cupones cupon = cuponesDAO.read(getCodigo());
        cuponesDAO.delete(cupon);
        return SUCCESS;
    }
    
}
