
package model;

import entity.Menu;
import entity.Perfil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MenuModel {
    private Session session;
    public MenuModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Menu>getAllMenu(){        
        List<Menu>listadoMenu=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoMenu=session.createCriteria(Menu.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoMenu;
    }
    
    public void createMenu(Menu objMenu){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objMenu);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateMenu(Menu objMenu){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objMenu);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeMenu(Menu objMenu){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objMenu);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Menu getMenu(int id){
        Menu objMenu=null;
        Transaction tx=session.beginTransaction();
        try{
            objMenu=(Menu)session.get(Menu.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objMenu;
    }
    
     public List<Menu>getMenuXPerfil(Perfil id){
        Transaction tx=this.session.beginTransaction();
        List<Menu> listadoMenu=null;
        try{
            Query query=this.session.createQuery("from Menu as menu where menu.perfil.idPerfil = :perfil");
            query.setParameter("perfil", id.getIdPerfil());
            listadoMenu=(List<Menu>)query.list();
            tx.commit();
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoMenu;
    }
}
