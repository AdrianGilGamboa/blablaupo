
package dao;

import entidades.Viajes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ViajesDAO {
    Session sesion=null;
    
    public void create(Viajes v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.save(v);
        tx.commit();
    }
    
    public List<Viajes> list(){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Viajes");
        List<Viajes> lp = (List<Viajes>)q.list();
        tx.commit();
        return lp;
    }
    
    public Viajes read(int id_viaje){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Viajes where id_viaje='"+id_viaje+"'");
        Viajes lp = (Viajes)q.uniqueResult();
        tx.commit();
        return lp;
    }
    
    public void update(Viajes v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.update(v);
        tx.commit();
    }
    
    public void delete(Viajes v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.delete(v);
        tx.commit();
    }  
    
    
}
