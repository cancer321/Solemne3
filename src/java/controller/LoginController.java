package controller;

import entity.Menu;
import entity.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.MenuModel;
import model.UsuarioModel;
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
@RequestMapping(value = "login.htm")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String user = request.getParameter("loginUsuario");
        String pass = request.getParameter("passUsuario");
        Usuario usuario = new Usuario(user, pass);
        mv.addObject("usuario", usuario);
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("usuario") Usuario u,
            BindingResult result, SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            String user = request.getParameter("nombreUsuario");
            String pass = request.getParameter("password");
            UsuarioModel objUsuarioModel = new UsuarioModel();
            Usuario objUsuario = objUsuarioModel.validaUsuario(user, pass);
            if (objUsuario != null) {
                mv.addObject("usuario", objUsuario);
                int id = objUsuario.getPerfil().getIdPerfil();
                MenuModel menuModel = new MenuModel();
                List<Menu> listado = menuModel.getMenuXPerfil(id);
                mv.addObject("listadoMenu", listado);
                mv.setViewName("home");
                return mv;
            } else {
                mv.addObject("usuario", new Usuario());
                mv.addObject("error", "Usuario no existe");
                mv.setViewName("login");
                return mv;
            }
        } catch (Exception e) {
            mv.addObject("usuario", new Usuario());
            mv.addObject("error", "Usuario no existe");
            mv.setViewName("login");
            return mv;
        }
    }
}
