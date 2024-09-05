package p2Netflix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMovie {
	
	// test data
	
	String validTitleLow, validTitleMid, validTitleHigh;
	String invalidTitleLow, invalidTitleHigh;
	
	String validDescriptionLow, validDescriptionMid, validDescriptionHigh;
	String invalidDescriptionHigh;
	
	MaturityRating u, pg, tweleve, fifteen, adult;
	
	int validDurationLow, validDurationMid, validDurationHigh;
	int invalidDurationLow, invalidDurationHigh;
	
	Movie m;
	
	@BeforeEach
	void setUp() throws Exception {
		validTitleLow = "a";
		validTitleMid = "a".repeat(5);
		validTitleHigh = "a".repeat(10);
		
		invalidTitleLow = "";
		invalidTitleHigh = "a".repeat(11);
		
		validDescriptionLow = "";
		validDescriptionMid = "a".repeat(12);
		validDescriptionHigh = "a".repeat(25);
		invalidDescriptionHigh = "a".repeat(26);
		
		u = MaturityRating.U;
		pg = MaturityRating.PG;
		tweleve = MaturityRating.TWELVE;
		fifteen = MaturityRating.FIFTEEN;
		adult = MaturityRating.ADULT;
		
		validDurationLow = 1;
		validDurationMid = 300; 
		validDurationHigh = 600;
		invalidDurationLow = 0; 
		invalidDurationHigh = 601;
		
		m = new Movie(validTitleHigh, validDescriptionHigh, adult, validDurationLow);
		
	}

	@Test
	void testMovieDefaultConstructor() {
		assertNotNull(m);
	}

	@Test
	void testMovieConstructorValid() {
		assertNotNull(m);
		assertEquals(validTitleHigh, m.getTitle());
		assertEquals(validDescriptionHigh, m.getDescription());
		assertEquals(adult, m.getMaturityRating());
		assertEquals(validDurationLow, m.getDuration());
	}
	
	@Test
	void testMovieConstructorInValid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(invalidTitleHigh, validDescriptionHigh, adult, validDurationLow);
		});
		
		assertEquals("TITLE IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(null, validDescriptionHigh, adult, validDurationLow);
		});
		
		assertEquals("TITLE IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(validTitleHigh, invalidDescriptionHigh, adult, validDurationLow);
		});
		
		assertEquals("DESCRIPTION IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(validTitleHigh, null, adult, validDurationLow);
		});
		
		assertEquals("DESCRIPTION IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(validTitleHigh, validDescriptionHigh, null, validDurationLow);
		});
		
		assertEquals("MATURITY RATING IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(validTitleHigh, validDescriptionHigh, adult, invalidDurationLow);
		});
		
		assertEquals("DURATION IS INVALID", exp.getMessage());
		
	}

	@Test
	void testSetGetDurationValid() {
		m.setDuration(validDurationLow);
		assertEquals(validDurationLow, m.getDuration());
		
		m.setDuration(validDurationMid);
		assertEquals(validDurationMid, m.getDuration());
		
		m.setDuration(validDurationHigh);
		assertEquals(validDurationHigh, m.getDuration());
	}
	
	@Test
	void testSetGetDurationInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			m.setDuration(invalidDurationLow);
		});
		
		assertEquals("DURATION IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m.setDuration(invalidDurationHigh);
		});
		
		assertEquals("DURATION IS INVALID", exp.getMessage());
		
	}

	@Test
	void testSetGetTitleValid() {
		m.setTitle(validTitleLow);
		assertEquals(validTitleLow, m.getTitle());
		
		m.setTitle(validTitleMid);
		assertEquals(validTitleMid, m.getTitle());
		
		m.setTitle(validTitleHigh);
		assertEquals(validTitleHigh, m.getTitle());
	}
	
	@Test
	void testSetGetTitleInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			m .setTitle(invalidTitleLow);
		});
		
		assertEquals("TITLE IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m .setTitle(invalidTitleHigh);
		});
		
		assertEquals("TITLE IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m.setTitle(null);
		});
		
		assertEquals("TITLE IS NULL", exp.getMessage());
		
		
	}

	@Test
	void testSetGetDescriptionValid() {
		m.setDescription(validDescriptionLow);
		assertEquals(validDescriptionLow, m.getDescription());
		
		m.setDescription(validDescriptionMid);
		assertEquals(validDescriptionMid, m.getDescription());
		
		m.setDescription(validDescriptionHigh);
		assertEquals(validDescriptionHigh, m.getDescription());
	}
	
	@Test
	void testSetGetDescriptionInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			m.setDescription(invalidDescriptionHigh);
		});
		
		assertEquals("DESCRIPTION IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			m.setDescription(null);
		});
		
		assertEquals("DESCRIPTION IS NULL", exp.getMessage());
	}

	@Test
	void testSetGetMaturityRatingValid() {
		m.setMaturityRating(u);
		assertEquals(MaturityRating.U, m.getMaturityRating());
		
		m.setMaturityRating(pg);
		assertEquals(MaturityRating.PG, m.getMaturityRating());
		
		m.setMaturityRating(tweleve);
		assertEquals(MaturityRating.TWELVE, m.getMaturityRating());
		
		m.setMaturityRating(fifteen);
		assertEquals(MaturityRating.FIFTEEN, m.getMaturityRating());
		
		m.setMaturityRating(adult);
		assertEquals(MaturityRating.ADULT, m.getMaturityRating());
	}
	
	@Test
	void testSetGetMaturityRatingInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			m = new Movie(validTitleHigh, validDescriptionHigh, null, validDurationLow);
		});
		
		assertEquals("MATURITY RATING IS NULL", exp.getMessage());
		
	}

}
