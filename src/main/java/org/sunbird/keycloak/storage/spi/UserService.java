package org.sunbird.keycloak.storage.spi;

import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;

public class UserService {

  private static Logger logger = Logger.getLogger(UserService.class);


  KeycloakSession session;
  public UserService(KeycloakSession session) {
    this.session =session;
  }

  public UserModel getById(String id) {
	
	 UserModel user = session.userLocalStorage().getUserById(id, session.getContext().getRealm());
	 user.setEmail("testing@gmail.com");
     return user;
  }

  public UserModel getByUsername(String username) {
	  UserModel user = session.userLocalStorage().getUserByUsername(username, session.getContext().getRealm());
	  user.setEmail("testing@gmail.com");

	 return user;
  }


}
