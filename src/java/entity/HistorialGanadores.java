package entity;
// Generated Jun 22, 2017 9:58:54 PM by Hibernate Tools 4.3.1



/**
 * HistorialGanadores generated by hbm2java
 */
public class HistorialGanadores  implements java.io.Serializable {


     private int idHg;
     private UsuarioJuego usuarioJuego;

    public HistorialGanadores() {
    }

    public HistorialGanadores(int idHg, UsuarioJuego usuarioJuego) {
       this.idHg = idHg;
       this.usuarioJuego = usuarioJuego;
    }
   
    public int getIdHg() {
        return this.idHg;
    }
    
    public void setIdHg(int idHg) {
        this.idHg = idHg;
    }
    public UsuarioJuego getUsuarioJuego() {
        return this.usuarioJuego;
    }
    
    public void setUsuarioJuego(UsuarioJuego usuarioJuego) {
        this.usuarioJuego = usuarioJuego;
    }




}


