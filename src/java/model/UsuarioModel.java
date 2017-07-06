package model;

import entity.Menu;
import entity.Usuario;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioModel {

    private Session session;

    public UsuarioModel() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException ex) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
    }

    public List<Usuario> getAllUsuario() {
        List<Usuario> listadoUsuario = new LinkedList<>();
        try {
            Transaction tx = session.beginTransaction();
            listadoUsuario = session.createCriteria(Usuario.class).list();
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return listadoUsuario;
    }

    public void createUsuario(Usuario objUsuario) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(objUsuario);
            tx.commit();
            session.flush();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
            tx.rollback();
        }

    }

    public void updateUsuario(Usuario objUsuario) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(objUsuario);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }

    public void removeUsuario(Usuario objUsuario) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(objUsuario);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }

    }

    public Usuario getUsuario(int id) {
        Usuario objUsuario = null;
        Transaction tx = session.beginTransaction();
        try {
            objUsuario = (Usuario) session.get(Usuario.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        }
        return objUsuario;
    }

    public Usuario validaUsuario(String login, String password) {
        Usuario objUsuario = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "From Usuario as usuario where usuario.nombreUsuario = :nombreUsuario and usuario.password = :password";
            Query query = this.session.createQuery(hql);
            query.setParameter("nombreUsuario", login);
            query.setParameter("password", password);
            objUsuario = (Usuario) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
        }
        return objUsuario;
    }
}
