/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author DobleL09
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Buscar")
    public String Buscar(@WebParam(name = "name") String txt) {
        
         EntityManager em;
        EntityManagerFactory emf;
        emf = javax.persistence.Persistence.createEntityManagerFactory("ISO815_Lab5PU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //-Buscar----------------------------------------
        ProductCode c = em.find(ProductCode.class,txt.toUpperCase());
        if(c != null){
        txt = (c.getDescription());
        }else{
           txt = "No se encontró el Registro ";
        }
        return "Resultado " + txt + " !";  
    }
}
