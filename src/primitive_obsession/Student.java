package primitive_obsession;

import java.util.Date;

public class Student {
	private FullName name;
	private BirthDate birthDate;
	private StudentType type;
	
	public Student(FullName name, StudentType type, BirthDate birthDate) {
		this.name = name;
		this.type = type;
		this.birthDate = birthDate;
	}

	public String getType() {
		return type.toString();
	}
	
	public String getName() {
		return name.getName();
	}
	public Date getBirthDate() {
		return birthDate.get();
	}
}
