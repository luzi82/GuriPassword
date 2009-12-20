package luzi82.guripassword;

import java.io.Serializable;

public class GpEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	private byte[] userName;

	private byte[] password;

	private byte[] url;

	private String publicComment;
	
	private byte[] privateComment;

	public GpEntry() {
	}

	public String getPublicComment() {
		return publicComment;
	}

	public void setPublicComment(String comment) {
		this.publicComment = comment;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getUserName() {
		return userName;
	}

	public void setUserName(byte[] userName) {
		this.userName = userName;
	}

	public byte[] getUrl() {
		return url;
	}

	public void setUrl(byte[] url) {
		this.url = url;
	}

	public byte[] getPrivateComment() {
		return privateComment;
	}

	public void setPrivateComment(byte[] privateComment) {
		this.privateComment = privateComment;
	}

}
