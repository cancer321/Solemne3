
package controller;

import entity.Menu;
import entity.Perfil;
import java.util.List;
import model.MenuModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
    @RequestMapping("menu.htm")
    
    public ModelAndView menu() {
        ModelAndView mv = new ModelAndView();
        Perfil p = new Perfil(1, "admin");
        MenuModel menuModel = new MenuModel();
        List<Menu> listado = menuModel.getAllMenu();
        mv.addObject("listadoMenu", listado);
        mv.setViewName("menu");
        return mv;
    }
}
