# spring-security-saml-onelogin
A plugin designed for Spring Security SAML Integration with a OneLogin IDP

This plugin is designed to simplify SSO from OneLogin into your application.  OneLogin acts as the IDP, and your application is the SP.

The plugin relies on Spring Security SAML in order to do the SAML heavy-lifting.

#Usage

To Import the configuration, use:

@Import(SpringSecurityOneLoginIDPConfiguration.class)


#Requirements

The following properties shoudl be resolved using Spring's Property Placeholder Configurer
1) org.onelogin.saml.idp.metadata.file=path to IDP Metadata XML File
2) org.onelogin.saml.idp.url=IDP-initiated SSO URL
3) org.onelogin.idp.entity.id=Entity ID of the IDP
4) org.onelogin.login.success.url=The application will redirect here upon success