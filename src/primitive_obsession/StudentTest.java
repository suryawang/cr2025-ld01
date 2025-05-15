//package primitive_obsession;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class StudentTest {
//
//	@Test
//	void testSuccess() {
//		try {
//			Student m = new Student(new FullName("Amir Budianto"), StudentType.Reguler, new BirthDate(20, 11, 1999));	
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
//	}
//
//	@Test
//	void testErrorName() {
//		try {
//			Student m = new Student(new FullName("amir budianto123"), StudentType.Reguler, new BirthDate( 20, 11, 1999));	
//		} catch (Exception e) {
//			return;
//		}
//		fail("exception is expected");
//	}
//	
//	@Test
//	void testErrorDoB() {
//		try {
//			Student m = new Student(new FullName("Amir Budianto"), StudentType.Reguler, new BirthDate(37, 11, 1999));	
//		} catch (Exception e) {
//			return;
//		}
//		fail("exception is expected");
//	}
//}
