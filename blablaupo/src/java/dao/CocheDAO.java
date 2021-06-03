
package dao;

import entidades.Coche;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CocheDAO {
    
        Session sesion = null;

        public void create(Coche coche) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(coche);
        tx.commit();
    }

    public Coche read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Coche where matricula='" + pk + "'");
        Coche a = (Coche) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void update(Coche coche) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(coche);
        tx.commit();
    }

    public void delete(Coche coche) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(coche);
        tx.commit();
    }

    public List<Coche> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Coche");
        List<Coche> listaCoches = (List<Coche>) q.list();
        tx.commit();
        return listaCoches;
    }
    
        public Coche readDniUsuario(String pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Coche where dni_conductor='" + pk + "'");
        Coche a = (Coche) q.uniqueResult();
        tx.commit();
        return a;
    }
}
