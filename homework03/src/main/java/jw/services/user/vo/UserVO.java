package jw.services.user.vo;

public class UserVO {

	//field
	private String name;
	private String gender;
	private String birth;
	private String cpNum;
	private String address;
	private boolean active;
	
	//constructor
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String name, String gender, String birth, String cpNum, String address) {
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.cpNum = cpNum;
		this.address = address;
	}

	
	//method
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth() {
		return birth;
	}

	public String getCpNum() {
		return cpNum;
	}

	public String getAddress() {
		return address;
	}

	public boolean isActive() {
		return active;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setCpNum(String cpNum) {
		this.cpNum = cpNum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String toString() {
		return "name = " + name +", gender = "+gender+", birth = "+birth+", cpNum = "+cpNum+", address = "+ address;
	}
	
	

}
