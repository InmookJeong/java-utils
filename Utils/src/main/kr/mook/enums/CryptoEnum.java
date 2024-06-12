package kr.mook.enums;

/**
 * CryptoEnum<br/>
 * This provides information for data encryption and decryption.<br/>
 * A spec refers to the encryption type.<br/>
 * A algorithm refers to the algorithm for encryption.<br/>
 * 
 * @since 2024.06.12
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public enum CryptoEnum {
	
	// Enums
	AES("AES", "AES/CBC/PKCS5Padding");
	
	// Constructor
	CryptoEnum(String spec, String algorithm) {
		this.spec = spec;
		this.algorithm = algorithm;
	}
	
	private String spec;
	private String algorithm;
	
	public String getSpec() {
		return this.spec;
	}
	
	public String getAlgorithm() {
		return this.algorithm;
	}
}
