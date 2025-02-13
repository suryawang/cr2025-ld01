package primitive_obsession;

import java.util.Date;

public class Student {
	private FullName name;
	private BirthDate birthDate;
	//reguler | global
	private String type;
	
	public Student(FullName name, String type, BirthDate birthDate) {
		type = type.toLowerCase();
		if(!type.equals("reguler") && !type.equals("global")) {
			throw new IllegalArgumentException("type is not valid");
		}
		
		this.name = name;
		this.type = type;
		this.birthDate = birthDate;
	}

	public String getType() {
		return type;
	}
	
	public String getName() {
		return name.getName();
	}
	public Date getBirthDate() {
		return birthDate.get();
	}
}
