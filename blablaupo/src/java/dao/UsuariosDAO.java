package dao;

import entidades.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UsuariosDAO {
    Session sesion=null;
    
    public void create(Usuarios v){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.save(v);
        tx.commit();
    }
    
    public List<Usuarios> list(){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Usuarios");
        List<Usuarios> lp = (List<Usuarios>)q.list();
        tx.commit();
        return lp;
    }
    
    public Usuarios read(String dni){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        Query q=sesion.createQuery("From Usuarios where dni='"+dni+"'");
        Usuarios lp = (Usuarios)q.uniqueResult();
        tx.commit();
        return lp;
    }
    
    public void update(Usuarios u){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.update(u);
        tx.commit();
    }
    
    public void delete(Usuarios u){
        sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=sesion.beginTransaction();
        sesion.delete(u);
        tx.commit();
    }
}
