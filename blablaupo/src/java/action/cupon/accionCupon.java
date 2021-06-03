package action.cupon;

import com.opensymphony.xwork2.ActionSupport;
import dao.AnunciosDAO;
import dao.CuponesDAO;
import entidades.Anuncios;
import entidades.Cupones;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;


public class accionCupon extends ActionSupport {
    
    HttpSession session = ServletActionContext.getRequest().getSession(false);
    private CuponesDAO cuponesDAO = new CuponesDAO();
    private List<Cupones> lista = new ArrayList();

    public List<Cupones> getLista() {
        return lista;
    }

    public accionCupon() {
    }
    
    public String execute() throws Exception {
        Cupones cupon = new Cupones();
        lista = cuponesDAO.list();
        session.setAttribute("lista", lista);
        return SUCCESS;
    }
    
}
