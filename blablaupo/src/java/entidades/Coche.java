package entidades;
// Generated 20-abr-2021 19:53:41 by Hibernate Tools 4.3.1



/**
 * Coche generated by hbm2java
 */
public class Coche  implements java.io.Serializable {


     private String matricula;
     private Usuarios usuarios;
     private String color;
     private String modelo;
     private String marca;

    public Coche() {
    }

    public Coche(String matricula, Usuarios usuarios, String color, String modelo, String marca) {
       this.matricula = matricula;
       this.usuarios = usuarios;
       this.color = color;
       this.modelo = modelo;
       this.marca = marca;
    }
   
    public String getMatricula() {
        return this.matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }




}


