package exercise.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercise.jpa.Colour;
import exercise.jpa.ColourRepository;
import exercise.jpa.Person;
import exercise.jpa.PersonRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	public List<Colour> getColours() {
		return (List<Colour>) colourRepository.findAll();
	}
	
	public List<Person> getPeople() {
		List<Person> people = (List<Person>) personRepository.findAll();
		Collections.sort(people, new Comparator<Person>() {
		    public int compare(Person o1, Person o2) {
		        return o1.getFullName().compareTo(o2.getFullName());
		    }
		});
		return people;
	}

	public Person getPersonById(long personId) {
		return personRepository.findOne(personId);
	}

	public void updatePerson(long personId, boolean authorised, boolean enabled, List<Colour> favouriteColours) {
		Person person = getPersonById(personId);

		person.setAuthorised(authorised);
		person.setEnabled(enabled);
		person.setFavouriteColours(favouriteColours);
		personRepository.save(person);
	}
	
	@Autowired
	private ColourRepository colourRepository;
	
	@Autowired
	private PersonRepository personRepository;
}
