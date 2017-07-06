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
@RequestMapping("addPago.htm")
public class AddPagoController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView AddPagoController(@ModelAttribute("usuario") Usuario u,
            BindingResult result, SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        MenuModel menuModel = new MenuModel();
        try {
            int id = u.getPerfil().getIdPerfil();
            List<Menu> listado = menuModel.getMenuXPerfil(id);
            mv.addObject("listadoMenu", listado);
            mv.addObject("usuario", u);
            mv.setViewName("addPago");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/login.htm");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("usuario") Usuario u, BindingResult result,
            SessionStatus status, HttpServletRequest request) {
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addPago");
            mav.addObject("usuario", u);
            return mav;
        } else {
            UsuarioModel objUsuarioModel = new UsuarioModel();
            objUsuarioModel.updateDinero(u);
            ModelAndView mav = new ModelAndView();
            UsuarioModel objUsuarioModel2 = new UsuarioModel();
            mav.addObject("usuario", objUsuarioModel2.getUsuario(u.getIdUsuario()));
            int id = u.getPerfil().getIdPerfil();
            MenuModel menuModel = new MenuModel();
            List<Menu> listado = menuModel.getMenuXPerfil(id);
            mav.addObject("listadoMenu", listado);
            mav.setViewName("addPago");
            return mav;
        }
    }
}
