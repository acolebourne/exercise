package exercise.jpa;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ComparisonChain;

@Entity
@Table(name="COLOURS")
public class Colour implements Comparable<Colour>, Serializable {	

	private static final long serialVersionUID = -2800640776778870697L;
	
	@Transient
    private Logger logger = LoggerFactory.getLogger(getClass());

	@Id
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IS_ENABLED", nullable = false)
	private boolean isEnabled;
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public int compareTo(Colour that) {
		return ComparisonChain.start()
		         .compareTrueFirst(this.name == null, that.name == null)
		         .result();
	}
	
	
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	@Override
    public int hashCode() {
	    return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {  	
    	if (obj == this) {
            return true;
        } 
        if (obj instanceof Colour) {
            Colour other = (Colour) obj; 

            return Objects.equals(this.id, other.id);
        } 
        return false;
    }

}
