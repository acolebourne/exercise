package exercise.service;

import java.util.List;

import exercise.jpa.Colour;
import exercise.jpa.Person;

public interface ExerciseService {

	List<Colour> getColours();

	List<Person> getPeople();

	Person getPersonById(long personId);

	void updatePerson(long personId, boolean authorised, boolean enabled, List<Colour> favouriteColours);
}