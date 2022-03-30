package Market.payload.response;

public class UserInfoResponse {
	private String id;
	private String username;
	private String role;

	public UserInfoResponse(String id, String username, String role) {
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}
}
