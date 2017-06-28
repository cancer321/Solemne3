/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.HistorialGanadores;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class HistorialGanadoresModel {
    private Session session;
    public HistorialGanadoresModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<HistorialGanadores>getAllHistorialGanadores(){        
        List<HistorialGanadores>listadoHistorialGanadores=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoHistorialGanadores=session.createCriteria(HistorialGanadores.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoHistorialGanadores;
    }
    
    public void createHistorialGanadores(HistorialGanadores objHistorialGanadores){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objHistorialGanadores);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateJuego(HistorialGanadores objHistorialGanadores){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objHistorialGanadores);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeHistorialGanadores(HistorialGanadores objHistorialGanadores){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objHistorialGanadores);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public HistorialGanadores getHistorialGanadores(int id){
        HistorialGanadores objHistorialGanadores=null;
        Transaction tx=session.beginTransaction();
        try{
            objHistorialGanadores=(HistorialGanadores)session.get(HistorialGanadores.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objHistorialGanadores;
    }
}