
package dao;

import entidades.Anuncios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AnunciosDAO {

    Session sesion = null;

    public void create(Anuncios anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(anuncio);
        tx.commit();
    }

    public Anuncios read(Integer pk) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Anuncios where id_anuncio='" + pk + "'");
        Anuncios a = (Anuncios) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void update(Anuncios anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.update(anuncio);
        tx.commit();
    }

    public void delete(Anuncios anuncio) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(anuncio);
        tx.commit();
    }

    public List<Anuncios> list() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("From Anuncios");
        List<Anuncios> listaAnuncios = (List<Anuncios>) q.list();
        tx.commit();
        return listaAnuncios;
    }
}
