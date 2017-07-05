package controller;

import entity.Menu;
import entity.Perfil;
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
@RequestMapping("mantenedorUsuario.htm")
public class MantenedorUsuarioController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mantenedorUsu(@ModelAttribute("usuario") Usuario u,
            BindingResult result, SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            Usuario usu = u;
            int id = usu.getPerfil().getIdPerfil();
            MenuModel objMenuModel = new MenuModel();
            UsuarioModel objUsuarioModel = new UsuarioModel();
            List<Menu> listado = objMenuModel.getMenuXPerfil(id);
            List<Usuario> listaUsu = objUsuarioModel.getAllUsuario();
            mv.addObject("listadoMenu", listado);
            mv.addObject("listaUsu", listaUsu);
            mv.addObject("usuario", usu);
            mv.setViewName("mantenedorUsuario");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/login.htm");
        }
    }
}
