/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Pozo;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class PozoModel {
    private Session session;
    public PozoModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Pozo>getAllPozo(){        
        List<Pozo>listadoPozo=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoPozo=session.createCriteria(Pozo.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoPozo;
    }
    
    public void createPozo(Pozo objPozo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objPozo);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updatePozo(Pozo objPozo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objPozo);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removePozo(Pozo objPozo){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objPozo);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Pozo getPozo(int id){
        Pozo objPozo=null;
        Transaction tx=session.beginTransaction();
        try{
            objPozo=(Pozo)session.get(Pozo.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objPozo;
    }
}


