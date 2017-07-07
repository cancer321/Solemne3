package controller;

import entity.HistorialGanadores;
import entity.Sorteo;
import entity.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.HistorialGanadoresModel;
import model.SorteoModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("historial.htm")
public class HistorialController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mantenedorUsu(@ModelAttribute("usuario") Usuario u,
            BindingResult result, SessionStatus status, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            SorteoModel objSorteoModel = new SorteoModel();
            List<Sorteo> listaSorteo = objSorteoModel.getAllSorteo();
            mv.addObject("listaSorteo", listaSorteo);
            HistorialGanadoresModel objHistorialGanadoresModel = new HistorialGanadoresModel();
            List<HistorialGanadores> listaHG = objHistorialGanadoresModel.getAllHistorialGanadores();
            mv.addObject("listaHG", listaHG);
            mv.setViewName("historial");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("redirect:/login.htm");
        }
    }
}
