/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.cupon;

import com.opensymphony.xwork2.ActionSupport;
import java.security.SecureRandom;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author sejavichan
 */
public class creaCodigo extends ActionSupport {
    private HttpSession session = ServletActionContext.getRequest().getSession(false);
    
    public creaCodigo() {

    }

    public static String generateRandomString(int length) {
        // Puede personalizar los personajes que desea agregar a
        // las cadenas al azar
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        if (length < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), retornos aleatorios 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        return sb.toString();
    }

    public String execute() throws Exception {
        session.setAttribute("codigo",generateRandomString(5));
        return SUCCESS;
    }

}
