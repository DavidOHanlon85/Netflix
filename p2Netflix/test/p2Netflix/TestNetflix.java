package p2Netflix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNetflix {

	// test data

	ArrayList<Content> content;
	ArrayList<Movie> movies;

	Content c1, c2, c3;
	Movie m1, m2, m3;

	Netflix n;

	@BeforeEach
	void setUp() throws Exception {

		n = new Netflix();

		content = new ArrayList<Content>();
		movies = new ArrayList<Movie>();

		c1 = new Movie("Gladiator", "Romans-slaves-blood-gore", MaturityRating.FIFTEEN, 154);
		c2 = new Movie("Wall St.", "money-pen", MaturityRating.ADULT, 180);
		c3 = new Movie("Godfather", "Mafia-blood", MaturityRating.PG, 126);

		content.add(c1);
		content.add(c2);
		content.add(c3);

		m1 = new Movie("Gladiator", "Romans-slaves-blood-gore", MaturityRating.FIFTEEN, 154);
		m2 = new Movie("Wall St.", "money-pen", MaturityRating.ADULT, 180);
		m3 = new Movie("Godfather", "Mafia-blood", MaturityRating.PG, 126);

		movies.add(m1);
		movies.add(m2);
		movies.add(m3);

	}

	@Test
	void testDisplayMoviesValid() {
		ArrayList<Movie> printedMovies = Netflix.displayMovies(movies);

		assertTrue(printedMovies.size() == 3);
		assertTrue(printedMovies.contains(m1));
		assertTrue(printedMovies.contains(m2));
		assertTrue(printedMovies.contains(m3));

	}

	@Test
	void testDisplayMoviesInvalidNull() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.displayMovies(null);
		});

		assertEquals("AL IS NULL", exp.getMessage());

	}

	@Test
	void testDisplayMoviesInvalidEmpty() {
		ArrayList<Movie> printedMovies = Netflix.displayMovies(movies);

		printedMovies.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.displayMovies(printedMovies);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());

	}

	@Test
	void testDisplayContentValid() {
		ArrayList<Content> results = n.displayContent(content);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(c1));
		assertTrue(results.contains(c2));
		assertTrue(results.contains(c3));

	}

	@Test
	void testDisplayContentInvalidNull() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.displayContent(null);
		});

		assertEquals("AL IS NULL", exp.getMessage());

	}

	@Test
	void testDisplayContentInvalidEmpty() {

		content.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.displayContent(content);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());

	}

	@Test
	void testSearchByMaturityrating() {
		ArrayList<Content> results = n.searchByMaturityrating(content, MaturityRating.PG);

		assertTrue(results.size() == 1);
		assertTrue(results.contains(c3));

		results = n.searchByMaturityrating(content, MaturityRating.ADULT);

		assertTrue(results.size() == 1);
		assertTrue(results.contains(c2));

	}

	@Test
	void testSearchByMaturityratingInvalidNull() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByMaturityrating(null, MaturityRating.ADULT);
		});

		assertEquals("AL IS NULL", exp.getMessage());

	}

	@Test
	void testSearchByMaturityratingInvalidALEmpty() {

		content.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByMaturityrating(content, MaturityRating.ADULT);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());

	}

	@Test
	void testSearchByMaturityratingInvalidMaturityRatingNull() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByMaturityrating(content, null);
		});

		assertEquals("MATURITY RATING IS NULL", exp.getMessage());

	}

	@Test
	void testSearchByDuration() {
		ArrayList<Movie> printedMovies = Netflix.searchByDuration(movies, 160, 200);

		assertTrue(printedMovies.size() == 1);
		assertTrue(printedMovies.contains(m2));

		printedMovies = Netflix.searchByDuration(movies, 120, 130);

		assertTrue(printedMovies.size() == 1);
		assertTrue(printedMovies.contains(m3));

	}
	
	@Test
	void testSearchByDurationInvalidALNull() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByDuration(null, 160, 180);
		});

		assertEquals("AL IS NULL", exp.getMessage());

	}
	
	@Test
	void testSearchByDurationInvalidALEmpty() {
		
		movies.clear();
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByDuration(movies, 160, 180);
		});

		assertEquals("AL IS EMPTY", exp.getMessage());

	}
	
	@Test
	void testSearchByDurationInvalidInputError() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByDuration(movies, 190, 180);
		});

		assertEquals("INPUT ERROR", exp.getMessage());

	}

	@Test
	void testSearchByKeywordValid() {
		ArrayList<Content> results = n.searchByKeyword(content, "blood");

		assertTrue(results.size() == 2);
		assertTrue(results.contains(c1));
		assertTrue(results.contains(c3));

		results = n.searchByKeyword(content, "slaves");

		assertTrue(results.size() == 1);
		assertTrue(results.contains(c1));
	}
	
	@Test
	void testSearchByKeywordInvalidALNull() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByKeyword(null, "blood");
		});

		assertEquals("AL IS NULL", exp.getMessage());
	}

	@Test
	void testSearchByKeywordInvalidALEmpty() {
		
		content.clear();
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByKeyword(content, "blood");
		});

		assertEquals("AL IS EMPTY", exp.getMessage());
	}
	
	@Test
	void testSearchByKeywordInvalidKeywordIsNull() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			n.searchByKeyword(content, null);
		});

		assertEquals("KEYWORD IS NULL", exp.getMessage());
	}
}
