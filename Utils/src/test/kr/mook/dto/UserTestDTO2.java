package kr.mook.dto;

/**
 * UserTestDTO
 * 
 * @since 2024.06.20
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class UserTestDTO2 {
	
	private int id;
	private String userId;
	private String name;
	
	public UserTestDTO2() {};
	
	public UserTestDTO2(int id, String userId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
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

	@Override
	public String toString() {
		return "UserTestDTO2 [id=" + id + ", userId=" + userId + ", name=" + name + "]";
	}
}
