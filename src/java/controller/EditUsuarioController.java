package controller;

import entity.Menu;
import entity.Perfil;
import entity.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.MenuModel;
import model.PerfilModel;
import model.PozoModel;
import model.UsuarioModel;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("usuario")
@RequestMapping("editUsuario.htm")
public class EditUsuarioController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editUsuario(@ModelAttribute("usuario") Usuario u,
            BindingResult result,
            SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editUsuario");
        mv.addObject("usuario", u);
        PerfilModel objPerfilModel = new PerfilModel();
        List<Perfil> p = objPerfilModel.getAllPerfil();
        MenuModel menuModel = new MenuModel();
        List<Menu> listado = menuModel.getMenuXPerfil(u.getPerfil().getIdPerfil());
        mv.addObject("listadoMenu", listado);
        mv.addObject("listadoPerfil", p);
        return mv;

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("usuario") Usuario u,
            BindingResult result,
            SessionStatus status, HttpServletRequest request) {
        PerfilModel objPerfilModel = new PerfilModel();
        int idPerfil = Integer.parseInt(request.getParameter("perfil"));
        ModelAndView mv = new ModelAndView();
        u.setPerfil(objPerfilModel.getPerfil(idPerfil));
        PozoModel objPozoModel = new PozoModel();
        u.setPozo(objPozoModel.getPozo(1));
        u.setEstado(1);
        try {
            UsuarioModel objUsuarioModel = new UsuarioModel();
            objUsuarioModel.createUsuario(u);
            mv.addObject("usuario", u);
            int id = u.getPerfil().getIdPerfil();
            MenuModel menuModel = new MenuModel();
            List<Menu> listado = menuModel.getMenuXPerfil(id);
            mv.addObject("listadoMenu", listado);
            mv.setViewName("home");
            return mv;
        } catch (HibernateException e) {
            mv.setViewName("addUsuario");
            mv.addObject("usuario", new Usuario());
            List<Perfil> p = objPerfilModel.getAllPerfil();
            mv.addObject("listadoPerfil", p);
            return mv;
        }

    }
}
