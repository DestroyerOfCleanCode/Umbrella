package application;

public class User {
	private String firstName;
	private String lastName;
	private String userType;
	
	public User() {
		setFirstName("firstName");
		setLastName("lastName");
		setUserType("defaultType");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public void setDefault() {
		setFirstName("firstName");
		setLastName("lastName");
		setUserType("defaultType");
	}
	
	public void setTypePatient() {
		setUserType("Patient");
	}
	
	public void setTypeNurse() {
		setUserType("Nurse");
	}
	
	public void setTypeDoctor() {
		setUserType("Doctor");
	}
	
	public boolean isTypePatient() {
		if (userType.equals("Patient"))
			return true;
		return false;
	}
	
	public boolean isTypeNurse() {
		if (userType.equals("Nurse"))
			return true;
		return false;
	}
	
	public boolean isTypeDoctor() {
		if (userType.equals("Doctor"))
			return true;
		return false;
	}
	
}
