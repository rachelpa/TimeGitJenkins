	package time;
	
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;
	
	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.params.ParameterizedTest;
	import org.junit.jupiter.params.provider.ValueSource;
	
	class TimeTest {
	
		@BeforeAll
		static void setUpBeforeClass() throws Exception {
		}
	
		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}
	
		@BeforeEach
		void setUp() throws Exception {
		}
	
		@AfterEach
		void tearDown() throws Exception {
		}
		
		/*
		 * Tests for GetTotalSeconds method
		 */
	
		@Test
		void testGetTotalSecondsGood() {
			int seconds = Time.getTotalSeconds("05:05:05:005");
		    assertTrue("The seconds were not calculated properly", seconds== 18310);
	
		}
		@Test
		void testGetTotalSecondsBad() {
			assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
			}
		
		/*
		 * Tests for GetSeconds method
		 */
	
	
		@Test
		void testGetSecondsGood() {
			int seconds = Time.getSeconds("00:00:45:010");
		    assertTrue("The seconds were not calculated properly", seconds== 45);
		}
		@Test
		void testGetSecondsBad() {
			assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getSeconds("00:00");});
			}
		
		@Test
		void testGetSecondsBoundary() {
			int seconds = Time.getSeconds("05:30:99:040");
			assertTrue("The seconds were not calculated properly", seconds== 99);
		}
		
		/*
		 * Tests for GetTotalMinutes method
		 */
	
		@Test
		void testGetTotalMinutesGood() {
			int minutes = Time.getTotalMinutes("05:30:00:005");
		    assertTrue("The minutes were not calculated properly", minutes== 30);
		}
		@Test
		void testGetTotalMinutesBad() {
			assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("05");});
			}
		
		@Test
		void testGetTotalMinutesBoundary() {
			int minutes = Time.getTotalMinutes("05:99:59:005");
			assertTrue("The minutes were not calculated properly", minutes== 99);
		}
		
		/*
		 * Tests for GetTotalHours method
		 */
	
	
		@Test
		void testGetTotalHoursGood() {
			int hours = Time.getTotalHours("05:05:50:030");
		    assertTrue("The hours were not calculated properly", hours== 5);
		}
		@Test
		void testGetTotalHoursBad() {
			assertThrows(NumberFormatException.class, ()-> {Time.getTotalHours("6:03:50:005");});
			}
		
		
		@ParameterizedTest
		@ValueSource(strings = { "05:00:00:005", "05:15:15:008", 
		"05:59:59:025" })
		void testGetTotalHoursBoundary(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours ==5);
		}
		
		/*
		 * Tests for GetMilliSeconds method
		 */
		
		@Test
		void testGetMilliSecondsGood() {
			int millisec = Time.getMilliSeconds("10:59:59:005");
			assertTrue("The milliseconds were not calculated properly", millisec== 5);
		}
		@Test
		void testGetMilliSecondsBad() {
			assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliSeconds("10:03:30");});
			}
		
		@Test
		void testGetMilliSecondsBoundary() {
			int millisec = Time.getMilliSeconds("10:59:59:999");
			assertTrue("The milliseconds were not calculated properly", millisec== 999);
		}
	
	
	}
