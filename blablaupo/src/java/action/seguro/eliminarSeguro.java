/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.seguro;

import com.opensymphony.xwork2.ActionSupport;
import dao.SegurosDAO;
import entidades.Seguros;

/**
 *
 * @author manum
 */
public class eliminarSeguro extends ActionSupport {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
    
    public String execute() throws Exception {
        SegurosDAO seguroDAO = new SegurosDAO();
        Seguros seguro = seguroDAO.read(Integer.parseInt(getId()));
        seguroDAO.delete(seguro);
        return SUCCESS;
    }
    
}
