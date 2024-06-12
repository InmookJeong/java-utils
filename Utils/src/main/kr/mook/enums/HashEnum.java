package kr.mook.enums;

/**
 * HashEnum<br/>
 * This is enumerated data for hash encryption.<br/>
 * A spec for hash encryption has been written.
 * 
 * @since 2024.06.12
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public enum HashEnum {
	
	// Hash enums
	SHA256("SHA-256");
	
	// Constructer
	HashEnum(String spec) {
		this.spec = spec;
	}
	
	private String spec;
	
	public String getSepc() {
		return this.spec;
	}
}
