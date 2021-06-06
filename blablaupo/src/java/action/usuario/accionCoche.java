
package action.usuario;

import com.opensymphony.xwork2.ActionSupport;
import dao.CocheDAO;
import dao.UsuariosDAO;
import entidades.Coche;
import entidades.Usuarios;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;


public class accionCoche extends ActionSupport {

    private String matricula;
    private String marca;
    private String color;
    private String modelo;
    private Usuarios u;
    private UsuariosDAO dao = new UsuariosDAO();
    private Coche c = new Coche();
    private CocheDAO cocheDAO = new CocheDAO();
    HttpSession session = ServletActionContext.getRequest().getSession(false);

    public Coche getC() {
        return c;
    }

    public void setC(Coche c) {
        this.c = c;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Usuarios getU() {
        return u;
    }

    public void setU(Usuarios u) {
        this.u = u;
    }

    public UsuariosDAO getDao() {
        return dao;
    }

    public void setDao(UsuariosDAO dao) {
        this.dao = dao;
    }

    public accionCoche() {
    }

    public String crearCoche() {

        u = (Usuarios) session.getAttribute("usuario");
        if (session.getAttribute("coche") == null) {
            c.setMatricula(getMatricula());
            c.setColor(getColor());
            c.setModelo(getModelo());
            c.setMarca(getMarca());
            c.setUsuarios(u);
            cocheDAO.create(c);
            session.setAttribute("coche", c);
        } else {
            CocheDAO daoC = new CocheDAO();
            Coche c = daoC.readDniUsuario(u.getDni());
            c.setColor(getColor());
            c.setModelo(getModelo());
            c.setMarca(getMarca());
            cocheDAO.update(c);
        }
        return SUCCESS;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public void validate() {
        if (this.getMatricula().equals("")) {
            addFieldError("matricula", getText("coche.matricula"));
        }

        if (this.getMarca().equals("")) {
            addFieldError("color", getText("coche.color"));
        }

        if (this.getColor().equals("")) {
            addFieldError("marca", getText("coche.marca"));
        }

        if (this.getModelo().equals("")) {
            addFieldError("modelo", getText("coche.modelo"));
        }
    }

}
