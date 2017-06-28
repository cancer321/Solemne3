package entity;
// Generated Jun 22, 2017 9:58:54 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sorteo generated by hbm2java
 */
public class Sorteo  implements java.io.Serializable {


     private int idSorteo;
     private Pozo pozo;
     private String combinacion;
     private Set juegoSorteos = new HashSet(0);

    public Sorteo() {
    }

	
    public Sorteo(int idSorteo, Pozo pozo, String combinacion) {
        this.idSorteo = idSorteo;
        this.pozo = pozo;
        this.combinacion = combinacion;
    }
    public Sorteo(int idSorteo, Pozo pozo, String combinacion, Set juegoSorteos) {
       this.idSorteo = idSorteo;
       this.pozo = pozo;
       this.combinacion = combinacion;
       this.juegoSorteos = juegoSorteos;
    }
   
    public int getIdSorteo() {
        return this.idSorteo;
    }
    
    public void setIdSorteo(int idSorteo) {
        this.idSorteo = idSorteo;
    }
    public Pozo getPozo() {
        return this.pozo;
    }
    
    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }
    public String getCombinacion() {
        return this.combinacion;
    }
    
    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }
    public Set getJuegoSorteos() {
        return this.juegoSorteos;
    }
    
    public void setJuegoSorteos(Set juegoSorteos) {
        this.juegoSorteos = juegoSorteos;
    }




}


