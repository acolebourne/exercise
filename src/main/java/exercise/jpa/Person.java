package exercise.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PEOPLE")
public class Person implements Serializable {	

	private static final long serialVersionUID = -7339725408857815172L;
	
	@Id
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "IS_AUTHORISED", nullable = false)
	private boolean authorised;	
	public boolean isAuthorised() {
		return authorised;
	}
	public void setAuthorised(boolean authorised) {
		this.authorised = authorised;
	}

	@Column(name = "IS_VALID", nullable = false)
	private boolean valid;	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(name = "IS_ENABLED", nullable = false)
	private boolean enabled;
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getFullName() {
		return firstName+" "+lastName;
	}
	
	public boolean isPalindrome() {		
		StringBuilder builder = new StringBuilder(getFullName().replaceAll("\\s", ""));
		return getFullName().replaceAll("\\s", "").equalsIgnoreCase(builder.reverse().toString());
	}
	
	@ManyToMany(fetch=FetchType.EAGER,targetEntity=Colour.class)
	@JoinTable
	  (
	      name="COLOURS_PEOPLE",
	      joinColumns={ @JoinColumn(name="PERSON_ID", referencedColumnName="ID") },
	      inverseJoinColumns={ @JoinColumn(name="COLOUR_ID", referencedColumnName="ID", unique=true) }
	  )
	public List<Colour> favouriteColours;
	public List<Colour> getFavouriteColours() {
		if(favouriteColours == null) {
			return new ArrayList<Colour>();
		}
		Collections.sort(favouriteColours);
		return favouriteColours;
	}
	public void setFavouriteColours(List<Colour> favouriteColours) {
		this.favouriteColours = favouriteColours;
	}
}
