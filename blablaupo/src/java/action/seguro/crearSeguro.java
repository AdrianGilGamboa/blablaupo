/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.seguro;

import com.opensymphony.xwork2.ActionSupport;
import dao.SegurosDAO;
import entidades.Seguros;
import java.util.HashSet;
import java.util.Set;



public class crearSeguro extends ActionSupport {
     private Integer idSeguro;
     private String empresa;
     private String tipo;
     private float descuento;
     private SegurosDAO sDao = new SegurosDAO();
     
    public SegurosDAO getsDao() {
        return sDao;
    }

    public void setsDao(SegurosDAO sDao) {
        this.sDao = sDao;
    }
     
     
    public Integer getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Integer idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

   
     
    
    public crearSeguro() {
    }
    
    public String crearSeguro(){
        
        Seguros seguro = new Seguros();
        seguro.setTipo(getTipo());
        seguro.setDescuento(getDescuento());
        seguro.setEmpresa(getEmpresa());
        sDao.create(seguro);
        return SUCCESS;
    }
     
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
