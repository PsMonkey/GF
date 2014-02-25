package dontCare.gf.gwt.client.vo;

import java.io.Serializable;

import dontCare.gf.gwt.client.util.BitFlag;

/**
 * GAE UserService 的 user 沒辦法用在 GWT RPC，所以只好轉換成這個 T__T。
 * 
 * <p>
 * 另外加上泛用形的 authority，請搭配 {@link BitFlag} 服用。
 */
public class GFUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private String authDomain;
	private String email;
	private String userId;
	private String federatedIdentify;
	private int authority;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAuthDomain() {
		return authDomain;
	}
	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFederatedIdentify() {
		return federatedIdentify;
	}
	public void setFederatedIdentify(String federatedIdentify) {
		this.federatedIdentify = federatedIdentify;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
}