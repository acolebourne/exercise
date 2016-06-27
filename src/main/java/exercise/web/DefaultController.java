package exercise.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exercise.jpa.Person;
import exercise.service.ExerciseService;

@Controller
public class DefaultController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
	public String index(Model model) {
    	model.addAttribute("people", exerciseService.getPeople());
		return "index";
	}
	
    @RequestMapping(value="/update/{personId}", method=RequestMethod.GET)
	public String personUpdateForm(@PathVariable long personId, Model model) {
    	logger.debug("Edditing user: {}",personId);
    	Person p = exerciseService.getPersonById(personId);
    	model.addAttribute("person", p);
    	model.addAttribute("allColours", exerciseService.getColours());
		return "edit";
	}
    
    @RequestMapping(value="/update/{personId}", method=RequestMethod.POST)
    public String personUpdateFormSubmit(@PathVariable long personId,
    										@ModelAttribute Person person, Model model) {
    	
    	exerciseService.updatePerson(personId, person.isAuthorised(), person.isEnabled(), person.getFavouriteColours());    	
        return "redirect:/";
    }
      
    @InitBinder
    public void registerConversionServices(WebDataBinder dataBinder) {
           dataBinder.setConversionService(conversionService);
    }
    
    @Autowired
    private ConversionService conversionService;

	@Autowired
	private ExerciseService exerciseService;
}
