package model;

import entity.Perfil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PerfilModel {

    private Session session;

    public PerfilModel() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException ex) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
    }

    public List<Perfil> getAllPerfil() {
        List<Perfil> listadoPerfil = new LinkedList<>();
        try {
            Transaction tx = session.beginTransaction();
            listadoPerfil = session.createCriteria(Perfil.class).list();
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return listadoPerfil;
    }

    public void createPerfil(Perfil objPerfil) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(objPerfil);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }

    }

    public void updatePerfil(Perfil objPerfil) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(objPerfil);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }

    public void removeJuegoSorteo(Perfil objPerfil) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(objPerfil);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }

    }

    public Perfil getPerfil(int id) {
        Perfil objPerfil = null;
        Transaction tx = session.beginTransaction();
        try {
            objPerfil = (Perfil) session.get(Perfil.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }
        return objPerfil;
    }
}
