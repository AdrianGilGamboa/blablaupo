package dao;


import entidades.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ValoracionesDAO {
    Session sesion=null;
    
    public void create(Valoraciones v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.save(v);
        tx.commit();
    }
    
    public List<Valoraciones> list(){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Valoraciones");
        List<Valoraciones> lp = (List<Valoraciones>)q.list();
        tx.commit();
        return lp;
    }
    
    public Valoraciones read(int id_valoracion){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Valoraciones where id_valoracion='"+id_valoracion+"'");
        Valoraciones lp = (Valoraciones)q.uniqueResult();
        tx.commit();
        return lp;
    }
    
    public void update(Valoraciones v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.update(v);
        tx.commit();
    }
    
    public void delete(Valoraciones v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.delete(v);
        tx.commit();
    }  
    
        public Valoraciones readIDReserva(int idReserva){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Valoraciones where id_reserva='"+idReserva+"'");
        Valoraciones lp = (Valoraciones)q.uniqueResult();
        tx.commit();
        return lp;
    }
    


}
