/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import entity.Juego;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class JuegoModel {
    private Session session;
    public JuegoModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Juego>getAllJuego(){        
        List<Juego>listadoJuego=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoJuego=session.createCriteria(Juego.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoJuego;
    }
    
    public void createJuego(Juego objJuego){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objJuego);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateJuego(Juego objJuego){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objJuego);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removeJuego(Juego objJuego){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objJuego);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public Juego getJuego(int id){
        Juego objJuego=null;
        Transaction tx=session.beginTransaction();
        try{
            objJuego=(Juego)session.get(Juego.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objJuego;
    }
}

