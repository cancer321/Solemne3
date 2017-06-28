/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Menu;
import entity.Perfil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Sorteo;

/**
 *
 * @author admin
 */
public class SorteoModel {
    private Session session;
    public SorteoModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Sorteo>getAllSorteo(){        
        List<Sorteo>listadoSorteo=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoSorteo=session.createCriteria(Sorteo.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoSorteo;
    }
    
    public void createSorteo(Sorteo objSorteo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objSorteo);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateSorteo(Menu objSorteo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objSorteo);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeSorteo(Sorteo objSorteo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objSorteo);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Sorteo getSorteo(int id){
        Sorteo objSorteo=null;
        Transaction tx=session.beginTransaction();
        try{
            objSorteo=(Sorteo)session.get(Sorteo.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objSorteo;
    }
}
