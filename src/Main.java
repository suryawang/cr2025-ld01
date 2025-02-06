import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import model.Grade;
import util.GradeFactory;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		var sc = new Scanner(new FileInputStream("grade.csv"));

		sc.nextLine(); // skip header
		while (sc.hasNext()) {
			var line = sc.nextLine();
//			System.out.println(line);
			var d = line.split("\t");
//			int project = Integer.parseInt(d[1]);
//			int midTerm = Integer.parseInt(d[2]);
//			int finalTerm = Integer.parseInt(d[3]);

			var grade = GradeFactory.createGrade(d[0], d[1], d[2], d[3]);
			System.out.println(grade);
			
//			int total = project * 5 + midTerm * 2 + finalTerm * 3;
//			total = total / 10 + (total % 10 > 0 ? 1 : 0);
//			System.out.printf("%s=> %3d %3d %3d = %3d\n", d[0], project, midTerm, finalTerm, total);
		}
	}
}
