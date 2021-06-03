package action.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class accionLogout {

    HttpSession session = ServletActionContext.getRequest().getSession(false);

    public String logout() {
        session.invalidate();
        return SUCCESS;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
}
