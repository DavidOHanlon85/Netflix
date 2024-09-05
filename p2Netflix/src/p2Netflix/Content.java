/**
 * 
 */
package p2Netflix;

import java.util.Objects;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public abstract class Content {

	// Constants

	private static final int TITLE_LENGTH_MIN = 1;
	private static final int TITLE_LENGTH_MAX = 10;

	private static final int DESCRIPTION_LENGTH_MIN = 0;
	private static final int DESCRIPTION_LENGTH_MAX = 25;

	// Instance variables

	private String title;
	private String description;
	private MaturityRating maturityRating;

	// Constructors

	/**
	 * This is the default constructor for Content
	 */

	public Content() {

	}

	/**
	 * This is the Content constructor with args
	 * 
	 * @param title
	 * @param description
	 * @param maturityRating
	 * @throws IllegalArgumentException
	 */
	public Content(String title, String description, MaturityRating maturityRating) throws IllegalArgumentException {
		this.setTitle(title);
		this.setDescription(description);
		this.setMaturityRating(maturityRating);
	}

	// Getters and Setters

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title according to the title being between length 1 and 10 characters
	 * (inclusive).
	 * 
	 * Throws Illegal Argument Exception with appropriate messages for null titles
	 * or titles outside of this range
	 * 
	 * @param title
	 * @throws IllegalArgumentException
	 */
	public void setTitle(String title) throws IllegalArgumentException {
		if (title == null) {
			throw new IllegalArgumentException("TITLE IS NULL");
		} else if (title.length() >= TITLE_LENGTH_MIN && title.length() <= TITLE_LENGTH_MAX) {
			this.title = title;
		} else {
			throw new IllegalArgumentException("TITLE IS INVALID");
		}

	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets description according to the description being between length 0 and 25 characters
	 * (inclusive).
	 * 
	 * Throws Illegal Argument Exception with appropriate messages for null descriptions
	 * or descriptions outside of this range
	 * 
	 * @param description
	 * @throws IllegalArgumentException
	 */
	public void setDescription(String description) throws IllegalArgumentException {
		if (description == null) {
			throw new IllegalArgumentException("DESCRIPTION IS NULL");
		} else if (description.length() >= DESCRIPTION_LENGTH_MIN && description.length() <= DESCRIPTION_LENGTH_MAX) {
			this.description = description;
		} else {
			throw new IllegalArgumentException("DESCRIPTION IS INVALID");
		}
	}

	/**
	 * @return the maturityRating
	 */
	public MaturityRating getMaturityRating() {
		return maturityRating;
	}

	/**
	 * Sets Maturity Rating - throws Illegal Argument Exception with appropriate message for null Maturity Ratings
	 * @param maturityRating
	 * @throws IllegalArgumentException
	 */
	public void setMaturityRating(MaturityRating maturityRating) throws IllegalArgumentException {
		if (maturityRating == null) {
			throw new IllegalArgumentException("MATURITY RATING IS NULL");
		} else {
			this.maturityRating = maturityRating;
		}
		
	}
	
	// Methods
	
	/**
	 * This method display all details contained in the Content Class - super.method could be used to extend this in subsequent classes 
	 */
	public void displayDetails() {
		System.out.println("Title       \t: " + getTitle());
		System.out.println("Rating      \t: " + getMaturityRating().getDescription());
		System.out.println("Description \t: " + getDescription());
	}
	
	// hashCode and equals
	
	@Override
	public int hashCode() {
		return Objects.hash(description, maturityRating, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return Objects.equals(description, other.description) && maturityRating == other.maturityRating
				&& Objects.equals(title, other.title);
	}
	
	
	

}
