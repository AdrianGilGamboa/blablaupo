
package action.anuncio;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.AnunciosDAO;
import entidades.Anuncios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class eliminarAnuncio extends ActionSupport {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute() throws Exception {
        Anuncios a = new Anuncios();
        AnunciosDAO anuncioDAO = new AnunciosDAO();
        Anuncios anuncio = anuncioDAO.read(Integer.parseInt(getId()));
        anuncioDAO.delete(anuncio);
        return SUCCESS;
        
    }
    
}
