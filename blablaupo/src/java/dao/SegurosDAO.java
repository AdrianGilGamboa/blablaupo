package dao;
import dao.HibernateUtil;
import entidades.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class SegurosDAO {
    Session sesion=null;
    
    public void create(Seguros s){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.save(s);
        tx.commit();
    }
    
    public List<Seguros> list(){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Seguros");
        List<Seguros> lp = (List<Seguros>)q.list();
        tx.commit();
        return lp;
    }
    
    public Seguros read(int id_seguro){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Seguros where id_seguro='"+id_seguro+"'");
        Seguros lp = (Seguros)q.uniqueResult();
        tx.commit();
        return lp;
    }
    
    public void update(Seguros s){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.update(s);
        tx.commit();
    }
    

    public void delete(Seguros s){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.delete(s);
        tx.commit();
    }
    
        public Seguros readTipo(String tipo){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Seguros where tipo='"+tipo+"'");
        Seguros lp = (Seguros)q.uniqueResult();
        tx.commit();
        return lp;
    }

}
