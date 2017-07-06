package controller;

import entity.Menu;
import entity.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.MenuModel;
import model.PerfilModel;
import model.PozoModel;
import model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("addUsuario.htm")
public class AddUsuarioController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addUsuario() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addUsuario");
        mv.addObject("usuario", new Usuario());
        return mv;

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario u,
            BindingResult result,
            SessionStatus status, HttpServletRequest request) {
        PerfilModel objPerfilModel = new PerfilModel();
        ModelAndView mv = new ModelAndView();
        u.setPerfil(objPerfilModel.getPerfil(2));
        PozoModel objPozoModel = new PozoModel();
        u.setPozo(objPozoModel.getPozo(1));
        u.setEstado(1);
        if (result.hasErrors()) {
            mv.setViewName("addUsuario");
            mv.addObject("usuario", new Usuario());
            return mv;
        } else {
            UsuarioModel objUsuarioModel = new UsuarioModel();
            objUsuarioModel.createUsuario(u);
            mv.addObject("usuario", u);
            int id = u.getPerfil().getIdPerfil();
            MenuModel menuModel = new MenuModel();
            List<Menu> listado = menuModel.getMenuXPerfil(id);
            mv.addObject("listadoMenu", listado);
            mv.setViewName("home");
            return mv;
        }
    }
}
