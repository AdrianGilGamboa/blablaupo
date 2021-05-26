
package action.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.UsuariosDAO;
import entidades.Usuarios;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;


public class accionRegistro extends ActionSupport {

    public static final String COCHE = "coche";
    Usuarios usuario = new Usuarios();
    UsuariosDAO dao = new UsuariosDAO();
    HttpSession session = ServletActionContext.getRequest().getSession(false);

    private String dni;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String email;
    private String password;
    private String tipo;

    public UsuariosDAO getDao() {
        return dao;
    }

    public void setDao(UsuariosDAO dao) {
        this.dao = dao;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public accionRegistro() {
    }

    public String registro() {
        usuario.setEmail(getEmail());
        usuario.setDni(getDni());
        usuario.setNombre(getNombre());
        usuario.setTelefono(getTelefono());
        usuario.setApellidos(getApellidos());
        usuario.setPassword(getPassword());

        usuario.setTipo(getTipo());
        if (getTipo().equals("Si")) {
            usuario.setTipo("True");
            //dao.create(usuario);
            session.setAttribute("usuario", usuario);
            return COCHE;
        } else {
            usuario.setTipo("False");
            dao.create(usuario);
            return SUCCESS;
        }

    }

    
      public void validate() {      
          System.out.println("EL TIPOOOOOOOOOOOOOOOOOOO: "+this.getTelefono());
        if (this.getNombre().equals("")){
            addFieldError("nombre", "nombre is required.");
        }
        
        if(this.getApellidos().length() == 0){
            addFieldError("apellidos", "pass is required.");
        }
        if(this.getPassword().length() == 0){
            addFieldError("password", "pass is required.");
        }
        if(this.getEmail().length() == 0){
            addFieldError("email", "pass is required.");
        }
        if(this.getDni().length() == 0){
            addFieldError("dni", "pass is required.");
        }
        if(this.getTelefono()== 0){
            addFieldError("telefono", "telefono is required.");
        }
        if(this.getTipo() == null){            
            addFieldError("tipo", "telefono is required.");
        }   
     }

    public String execute() throws Exception {
        return SUCCESS;
    }

}
