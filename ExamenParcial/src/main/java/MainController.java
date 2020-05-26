import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;

@Controller
public class MainController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView categoria() {
		ModelAndView mav = new ModelAndView();
		
		Categoria categoria = new Categoria();
		
		mav.addObject("categoria",categoria);
		mav.setViewName("index");
		
		return mav;
	}
}
