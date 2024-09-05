/**
 * 
 */
package p2Netflix;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public enum MaturityRating {

	U("U - Suitable for all ages"), PG ("PG - Parental Guidance"), TWELVE ("TWELVE - Suitable for ages 12 and up"), FIFTEEN ("FIFTEEN - Suitable for ages 15 and up"), ADULT ("ADULT - Suitable for adults only");
	
	// instance variable
	
		private String description;

	/**
	 * @param description
	 */
	private MaturityRating(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	
	
	
}
