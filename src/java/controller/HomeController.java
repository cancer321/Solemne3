package controller;

import entity.Menu;
import entity.Perfil;
import entity.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.MenuModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("home.htm")

    public ModelAndView home(@ModelAttribute("usuario") Usuario u,
            BindingResult result, SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        MenuModel menuModel = new MenuModel();
        Usuario usu = (Usuario) request.getAttribute("usuario");
        Perfil id = usu.getPerfil();
        List<Menu> listado = menuModel.getMenuXPerfil(id);
        mv.addObject("listadoMenu", listado);
        mv.setViewName("home");
        return mv;
    }
}
