package kr.mook.dto;

/**
 * UserTestDTO
 * 
 * @since 2024.06.20
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class UserTestDTO {
	
	private int id;
	private String userId;
	private String name;
	private int age;
	
	public UserTestDTO() {};
	
	public UserTestDTO(int id, String userId, String name, int age) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserTestDTO [id=" + id + ", userId=" + userId + ", name=" + name + ", age=" + age + "]";
	}
}
