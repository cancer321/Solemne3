/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.UsuarioJuego;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class UsuarioJuegoModel {
    private Session session;
    public UsuarioJuegoModel() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<UsuarioJuego>getAllUsuarioJuego(){        
        List<UsuarioJuego>listadoUsuarioJuego=new LinkedList<>();
        try{
            Transaction tx=session.beginTransaction();
            listadoUsuarioJuego=session.createCriteria(UsuarioJuego.class).list() ;
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return listadoUsuarioJuego;
    }
    
    public void createUsuarioJuego(UsuarioJuego objUsuarioJuego){        
        Transaction tx=session.beginTransaction();
        try{            
            session.save(objUsuarioJuego);                 
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public void updateUsuarioJuego(UsuarioJuego objUsuarioJuego){        
        Transaction tx=session.beginTransaction();
        try{            
            session.update(objUsuarioJuego);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }        
    }
    
    public void removePozo(UsuarioJuego objUsuarioJuego){        
        Transaction tx=session.beginTransaction();
        try{            
            session.delete(objUsuarioJuego);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        
    }
    
    public UsuarioJuego getUsuarioJuego(int id){
        UsuarioJuego objUsuarioJuego=null;
        Transaction tx=session.beginTransaction();
        try{
            objUsuarioJuego=(UsuarioJuego)session.get(UsuarioJuego.class,id);
            tx.commit();            
        }catch(HibernateException ex){
            ex.printStackTrace();
            tx.rollback();
        }
        return objUsuarioJuego;
    }
}