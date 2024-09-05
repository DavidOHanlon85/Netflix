/**
 * 
 */
package p2Netflix;

import java.util.ArrayList;

/**
 * 
 */
public class Netflix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Content> content = new ArrayList<Content>();

		Content c1 = new Movie("Gladiator", "Romans-slaves-blood-gore", MaturityRating.FIFTEEN, 154);
		Content c2 = new Movie("Wall St.", "money-pen", MaturityRating.ADULT, 180);
		Content c3 = new Movie("Godfather", "Mafia-blood", MaturityRating.PG, 126);

		content.add(c1);
		content.add(c2);
		content.add(c3);

		ArrayList<Movie> movies = new ArrayList<Movie>();

		Movie m1 = new Movie("Gladiator", "Romans-slaves-blood-gore", MaturityRating.FIFTEEN, 154);
		Movie m2 = new Movie("Wall St.", "money-pen", MaturityRating.ADULT, 180);
		Movie m3 = new Movie("Godfather", "Mafia-blood", MaturityRating.PG, 126);

		movies.add(m1);
		movies.add(m2);
		movies.add(m3);

		// Display All Content

		System.out.println("All movies");
		displayContent(content);
		System.out.println();

		// searchByMaturityRating

		MaturityRating maturityRating = MaturityRating.ADULT;

		System.out.println("All " + maturityRating);

		ArrayList<Content> contentByMaturityRating = searchByMaturityrating(content, maturityRating);
		displayContent(contentByMaturityRating);

		System.out.println();

		// All by duration

		int minDuration = 160;
		int maxDuration = 200;

		System.out.println("Matched on duration >= " + minDuration + " and <= " + maxDuration);

		ArrayList<Movie> moviesWithinDurationRange = searchByDuration(movies, 160, 200);
		displayMovies(moviesWithinDurationRange);
		System.out.println();
		
		System.out.println();
		
		System.out.println("Matched on duration >= " + minDuration + " and <= " + maxDuration);
		ArrayList<Content> contentWithinDurationRange = searchByDuration2(content, 160, 200);
		displayContent(contentWithinDurationRange);
		
		System.out.println();

		// All by keyword

		String keyword = "Blood";

		System.out.println("Matched on search word " + keyword);
		ArrayList<Content> contentByKeyword = searchByKeyword(content, keyword);
		displayContent(contentByKeyword);

	}

	/**
	 * Prints an AL of movies to consoles and returns an AL of printed content
	 * 
	 * Throws IllegalArugement Exception if Al is null or empty
	 * 
	 * @param movies
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Movie> displayMovies(ArrayList<Movie> movies) throws IllegalArgumentException {

		ArrayList<Movie> printedMovies = new ArrayList<Movie>();

		if (movies == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (movies.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		for (Movie m : movies) {
			printedMovies.add(m);
			m.displayDetails();
		}

		return printedMovies;
	}

	/**
	 * Prints an AL of content to consoles and returns an AL of printed content
	 * 
	 * Throws IllegalArugement Exception if Al is null or empty
	 * 
	 * @param content
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Content> displayContent(ArrayList<Content> content) throws IllegalArgumentException {

		ArrayList<Content> printedContent = new ArrayList<Content>();

		if (content == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (content.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		for (Content c : content) {
			c.displayDetails();
			printedContent.add(c);
		}

		return printedContent;
	}

	/**
	 * Searches an AL and returns a new ArrayList with corresponding maturity
	 * ratings
	 * 
	 * Throws IllegalArugement Exception if Al is null or empty and if Maturity
	 * rating is null
	 * 
	 * @param content
	 * @param maturityRating
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Content> searchByMaturityrating(ArrayList<Content> content, MaturityRating maturityRating)
			throws IllegalArgumentException {

		ArrayList<Content> contentByMaturityRating = new ArrayList<Content>();

		if (content == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (content.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		if (maturityRating == null) {
			throw new IllegalArgumentException("MATURITY RATING IS NULL");
		}

		for (Content c : content) {
			if (c.getMaturityRating() == maturityRating) {
				contentByMaturityRating.add(c);
			}
		}

		return contentByMaturityRating;
	}

	/**
	 * Searches an AL and returns a new ArrayList with corresponding duration times
	 * between and min and max (inclusive)
	 * 
	 * Throws IllegalArugement Exception if Al is null or empty and if there is an
	 * input error i.e. min > max
	 * 
	 * @param movies
	 * @param minDuration
	 * @param MaxDuration
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Movie> searchByDuration(ArrayList<Movie> movies, int minDuration, int MaxDuration)
			throws IllegalArgumentException {

		ArrayList<Movie> contentByDuration = new ArrayList<Movie>();

		if (movies == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (movies.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		if (minDuration > MaxDuration) {
			throw new IllegalArgumentException("INPUT ERROR");
		}

		for (Movie m : movies) {
			if (m.getDuration() >= minDuration && m.getDuration() <= MaxDuration) {
				contentByDuration.add(m);
			}
		}

		return contentByDuration;
	}

	/**
	 * Searches an AL and returns a new ArrayList with corresponding duration times
	 * between and min and max (inclusive)
	 * 
	 * Throws IllegalArugement Exception if Al is null or empty and if there is an
	 * input error i.e. min > max
	 * 
	 * @param movies
	 * @param minDuration
	 * @param MaxDuration
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public static ArrayList<Content> searchByDuration2(ArrayList<Content> content, int minDuration, int MaxDuration)
			throws IllegalArgumentException {

		ArrayList<Content> contentByDuration = new ArrayList<Content>();

		if (content == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (content.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		if (minDuration > MaxDuration) {
			throw new IllegalArgumentException("INPUT ERROR");
		}

		for (Content m : content) {
			if (m instanceof Movie) {
				Movie temp = (Movie) m;
				if (temp.getDuration() >= minDuration && temp.getDuration() <= MaxDuration) {
					contentByDuration.add(m);
				}
			}
		}

		return contentByDuration;
	}

	/**
	 * Searches an AL and returns a new ArrayList with corresponding content that
	 * has the keyword in their description
	 * 
	 * Throws IllegalArugement Exception if Al is null or empty and if keyword is
	 * null
	 * 
	 * @param content
	 * @param keyword
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Content> searchByKeyword(ArrayList<Content> content, String keyword)
			throws IllegalArgumentException {

		ArrayList<Content> contentByKeyword = new ArrayList<Content>();

		if (content == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}

		if (content.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}

		if (keyword == null) {
			throw new IllegalArgumentException("KEYWORD IS NULL");
		}

		keyword = keyword.toUpperCase();

		for (Content c : content) {
			if (c.getDescription().toUpperCase().contains(keyword)) {
				contentByKeyword.add(c);
			}
		}

		return contentByKeyword;
	}

}
