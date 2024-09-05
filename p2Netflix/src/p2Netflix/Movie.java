/**
 * 
 */
package p2Netflix;

import java.util.Objects;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class Movie extends Content {

	// Constants

	private static final int MIN_DURATION = 1;
	private static final int MAX_DURATION = 600;

	// Instance variables

	private int duration;

	/**
	 * This is the default movie constructor
	 */
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param description
	 * @param maturityRating
	 * @throws IllegalArgumentException
	 */
	public Movie(String title, String description, MaturityRating maturityRating, int duration)
			throws IllegalArgumentException {
		super(title, description, maturityRating);
		this.setDuration(duration);
	}

	// Getters and setters

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets duration between 1 - 600 inclusive - throws Illegal Argument Exception
	 * with appropriate message for invalid duration
	 * 
	 * @param duration
	 */
	public void setDuration(int duration) {
		if (duration >= MIN_DURATION && duration <= MAX_DURATION) {
			this.duration = duration;
		} else {
			throw new IllegalArgumentException("DURATION IS INVALID");
		}

	}
	
	// Methods
	
	@Override
	public void displayDetails() {
		System.out.println("Movie details");
		super.displayDetails();
		System.out.println("Duration    \t: " + getDuration() + "(mins total)");
		System.out.println("Duration    \t: " + calculateDurationInHoursAndMinutes());
		
	}
	
	private String calculateDurationInHoursAndMinutes() {
		int hours = getDuration() / 60;
		int minutes = getDuration() % 60;
		
		String duration = hours + " hours, " + minutes + " mins.";
		
		return duration;
	}
	
	// hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(duration);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return duration == other.duration;
	}
	
	
	
	

}
