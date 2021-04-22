/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cupones;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author adrii_gil99
 */
public class CuponesDAO {
    
        Session sesion = null;

        public void create(Cupones cupon) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(cupon);
        tx.commit();
    }

    public Cupones read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Cupones where numero_cupon='" + pk + "'");
        Cupones a = (Cupones) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void update(Cupones cupon) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(cupon);
        tx.commit();
    }

    public void delete(Cupones cupon) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(cupon);
        tx.commit();
    }

    public List<Cupones> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Cupones");
        List<Cupones> listaCupones = (List<Cupones>) q.list();
        tx.commit();
        return listaCupones;
    }
}
