package dontCare.gf.gae.server;

import com.google.appengine.api.users.User;

import dontCare.gf.gwt.client.vo.GFUser;

public class DTO {
	public static GFUser convert(User user) {
		GFUser result = new GFUser();
		result.setAuthDomain(user.getAuthDomain());
		result.setEmail(user.getEmail());
		result.setFederatedIdentify(user.getFederatedIdentity());
		result.setNickname(user.getNickname());
		result.setUserId(user.getUserId());
		return result;
	}
}
