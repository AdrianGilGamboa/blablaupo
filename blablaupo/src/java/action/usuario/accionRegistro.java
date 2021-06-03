package action.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import dao.CocheDAO;
import dao.UsuariosDAO;
import entidades.Coche;
import entidades.Usuarios;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
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

    private String passwordNueva;

    public String getPasswordNueva() {
        return passwordNueva;
    }

    public void setPasswordNueva(String passwordNueva) {
        this.passwordNueva = passwordNueva;
    }

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
            dao.create(usuario);
            return COCHE;
        } else {
            dao.create(usuario);
            return SUCCESS;
        }

    }

    

   /* public void validate() {;
        if (this.getNombre().equals("")) {
            addFieldError("nombre", getText("registrar.nombre"));
        }

        if (this.getApellidos().length() == 0) {
            addFieldError("apellidos", getText("registrar.apellidos"));
        }
        if (this.getPassword().length() < 6) {
            addFieldError("password", getText("registrar.password"));
        }
        if (this.getEmail().length() == 0) {
            addFieldError("email", getText("registrar.emailVacio"));
        }else if(!validaCorreo(this.getEmail())){
            addFieldError("email", getText("registrar.emailFormato"));
        }
        if (this.getDni().length() == 0) {
            addFieldError("dni", getText("registrar.dniVacio"));
        }else if (!validaDni(this.getDni())) {
            addFieldError("dni", getText("registrar.dniFormato"));
        }
        if (this.getTelefono() == 0) {
            addFieldError("telefono", getText("registrar.telefonoVacio"));
        }
        if (this.getTipo() == null) {
            addFieldError("tipo", getText("registrar.coche"));
        }
    }*/

    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public static boolean validaCorreo(String correo){
          // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar 
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
    
    public static boolean validaDni(String dni){
        try{
        int numero = Integer.parseInt(dni.substring(0, dni.length()-1));
        String letra =  dni.substring(dni.length()-1, dni.length()) ;
        int resto = numero%23;
        String letraReal="";
        switch(resto){
                case 0: letraReal="T"; break;
                case 1: letraReal="R"; break;
                case 2: letraReal="W"; break;
                case 3: letraReal="A"; break;
                case 4: letraReal="G"; break;
                case 5: letraReal="M"; break;
                case 6: letraReal="Y"; break;
                case 7: letraReal="F"; break;
                case 8: letraReal="P"; break;
                case 9: letraReal="D"; break;
                case 10: letraReal="X"; break;
                case 11: letraReal="B"; break;
                case 12: letraReal="N"; break;
                case 13: letraReal="J"; break;
                case 14: letraReal="Z"; break;
                case 15: letraReal="S"; break;
                case 16: letraReal="Q"; break;
                case 17: letraReal="V"; break;
                case 18: letraReal="H"; break;
                case 19: letraReal="L"; break;
                case 20: letraReal="C"; break;
                case 21: letraReal="K"; break;
                case 22: letraReal="E";  break;
                default: letraReal="";
        };
        if(letraReal.equals(StringUtils.upperCase(letra))){
            return true;
        }else
            return false;
        }catch(Exception e){
            return false;
        }
    }

}
