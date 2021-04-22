
package dao;

import entidades.Reservas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReservasDAO {

    Session sesion = null;

    public void create(Reservas reserva) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(reserva);
        tx.commit();
    }

    public Reservas read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Reservas where id_reserva='" + pk + "'");
        Reservas a = (Reservas) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void update(Reservas reserva) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(reserva);
        tx.commit();
    }

    public void delete(Reservas reserva) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(reserva);
        tx.commit();
    }

    public List<Reservas> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Reservas");
        List<Reservas> listaReservas = (List<Reservas>) q.list();
        tx.commit();
        return listaReservas;
    }
}
