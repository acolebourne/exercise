package exercise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import exercise.jpa.Colour;
import exercise.jpa.ColourRepository;

public class StringToColour implements Converter<String, Colour> {

	public Colour convert(String text) {
		Colour colour = colourRepository.findOne(Long.parseLong(text));
		return colour;
	}
    
	@Autowired
	private ColourRepository colourRepository;
}
