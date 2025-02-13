package primitive_obsession;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void testSuccess() {
		try {
			Student m = new Student(new FullName("Amir Budianto"), "reguler", 20, 11, 1999);	
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testErrorName() {
		try {
			Student m = new Student(new FullName("amir budianto123"), "reguler", 20, 11, 1999);	
		} catch (Exception e) {
			return;
		}
		fail("exception is expected");
	}
	
	@Test
	void testErrorDoB() {
		try {
			Student m = new Student(new FullName("Amir Budianto"), "reguler", 37, 11, 1999);	
		} catch (Exception e) {
			return;
		}
		fail("exception is expected");
	}
}
