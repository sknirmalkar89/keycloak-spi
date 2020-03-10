package org.sunbird.keycloak.storage.spi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;

public class UserServiceProvider
    implements UserStorageProvider, UserLookupProvider, UserQueryProvider {
  private static final Logger logger = Logger.getLogger(UserStorageProvider.class);

  private final KeycloakSession session;
  private final ComponentModel model;
  private final UserService userService;

  public UserServiceProvider(KeycloakSession session, ComponentModel model,
      UserService userService) {
    this.session = session;
    this.model = model;
    this.userService = userService;
  }

  @Override
  public void close() {}

  @Override
  public UserModel getUserById(String id, RealmModel realm) {
    logger.info("UserServiceProvider:getUserById: id = " + id);
    return userService.getById(id);
  }

  @Override
  public UserModel getUserByUsername(String username, RealmModel realm) {
    logger.info("UserServiceProvider: getUserByUsername called");
    UserModel users = userService.getByUsername(username);
    if (users != null) {
      return users;
    } else {
    	return null;
    }
  }

  @Override
  public UserModel getUserByEmail(String email, RealmModel realm) {
    logger.info("UserServiceProvider: getUserByEmail called");
    return getUserByUsername(email, realm);
  }

  @Override
  public int getUsersCount(RealmModel realm) {
    return 0;
  }

  @Override
  public List<UserModel> getUsers(RealmModel realm) {
    return Collections.emptyList();
  }

  @Override
  public List<UserModel> getUsers(RealmModel realm, int firstResult, int maxResults) {
    return Collections.emptyList();
  }

  @Override
  public List<UserModel> searchForUser(String search, RealmModel realm) {
	 return Collections.emptyList();
  }

  @Override
  public List<UserModel> searchForUser(String search, RealmModel realm, int firstResult,
      int maxResults) {
    
	 return Collections.emptyList();
  }

  @Override
  public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm) {
    return Collections.emptyList();
  }

  @Override
  public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm,
      int firstResult, int maxResults) {

    return Collections.emptyList();
  }

  @Override
  public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group, int firstResult,
      int maxResults) {

    return Collections.emptyList();
  }

  @Override
  public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group) {

    return Collections.emptyList();
  }

  @Override
  public List<UserModel> searchForUserByUserAttribute(String attrName, String attrValue,
      RealmModel realm) {
    
    return Collections.emptyList();
  }

}
