/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.JuegoSorteo;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class JuegoSorteoModel {
    private Session session;
    public JuegoSorteoModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<JuegoSorteo>getAllJuegoSorteo(){        
        List<JuegoSorteo>listadoJuegoSorteo=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoJuegoSorteo=session.createCriteria(JuegoSorteo.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoJuegoSorteo;
    }
    
    public void createJuegoSorteo(JuegoSorteo objJuegoSorteo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objJuegoSorteo);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateJuegoSorteo(JuegoSorteo objJuegoSorteo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objJuegoSorteo);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeJuegoSorteo(JuegoSorteo objJuegoSorteo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objJuegoSorteo);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public JuegoSorteo getJuegoSorteo(int id){
        JuegoSorteo objJuegoSorteo=null;
        Transaction tx=session.beginTransaction();
        try{
            objJuegoSorteo=(JuegoSorteo)session.get(JuegoSorteo.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objJuegoSorteo;
    }
}
