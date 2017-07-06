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
@RequestMapping("deleteUsuario.htm")
public class DeleteUsuarioController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editUsuario(@ModelAttribute("usuario") Usuario u,
            BindingResult result,
            SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mantenedorUsuario");
        mv.addObject("usuario", u);
        UsuarioModel objUsuarioModel = new UsuarioModel();
        objUsuarioModel.removeUsuario(u.getIdUsuario());
        MenuModel menuModel = new MenuModel();
        List<Menu> listado = menuModel.getMenuXPerfil(u.getPerfil().getIdPerfil());
        mv.addObject("listadoMenu", listado);
        List<Usuario> listaUsu = objUsuarioModel.getAllUsuario();
        mv.addObject("listaUsu", listaUsu);
        return mv;
    }
}
