package controller;

import entity.Usuario;
import javax.servlet.http.HttpServletRequest;
import model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
    public String login(@ModelAttribute("usuario") Usuario u,
            BindingResult result, SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String user = request.getParameter("nombreUsuario");
        String pass = request.getParameter("password");
        Usuario usuario = new Usuario(user, pass);
        UsuarioModel objUsuarioModel = new UsuarioModel();
        Usuario objUsuario = objUsuarioModel.validaUsuario(user, pass);
        if (objUsuario != null) {
            mv.addObject("usuario", objUsuario);
            return "redirect:/home.htm";

        } else {
            mv.addObject("usuario", usuario);
            return "redirect:/login.htm";
        }
    }
}
