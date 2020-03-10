package org.sunbird.keycloak.registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.keycloak.Config;
import org.keycloak.Config.Scope;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormActionFactory;
import org.keycloak.authentication.FormContext;
import org.keycloak.authentication.ValidationContext;
import org.keycloak.authentication.forms.RegistrationPage;
import org.keycloak.events.Details;
import org.keycloak.events.Errors;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.FormMessage;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.services.messages.Messages;
import org.keycloak.services.validation.Validation;

public class FormActionUtil implements FormAction, FormActionFactory {

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public FormAction create(KeycloakSession session) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void init(Scope config) {
		// TODO Auto-generated method stub

	}

	private static AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
			AuthenticationExecutionModel.Requirement.REQUIRED, AuthenticationExecutionModel.Requirement.DISABLED };

	@Override
	public void postInit(KeycloakSessionFactory factory) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "MY REGISTRATION";
	}

	@Override
	public String getDisplayType() {
		// TODO Auto-generated method stub
		return "MY REGISTRATION";
	}

	@Override
	public String getReferenceCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConfigurable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Requirement[] getRequirementChoices() {
		// TODO Auto-generated method stub
		return REQUIREMENT_CHOICES;
	}

	@Override
	public boolean isUserSetupAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHelpText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildPage(FormContext context, LoginFormsProvider form) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(ValidationContext context) {
		// TODO Auto-generated method stub
		System.out.println("RUNNING MY CODE");
		context.success();

	}

	@Override
	public void success(FormContext context) {
		// TODO Auto-generated method stub
		System.out.println("RUNNING MY CODE");
		MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
		String userName = formData.getFirst(RegistrationPage.FIELD_USERNAME);

		UserModel user = context.getSession().users().addUser(context.getRealm(), "11001" + userName);
		user.setFirstName(formData.getFirst(RegistrationPage.FIELD_FIRST_NAME));
		user.setLastName(formData.getFirst(RegistrationPage.FIELD_LAST_NAME));
		user.setEmail(formData.getFirst(Validation.FIELD_EMAIL));
		user.setEnabled(true);
		context.setUser(user);
		context.getEvent().user(user);
		context.getEvent().success();

	}

	@Override
	public boolean requiresUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
		// TODO Auto-generated method stub

	}

}
