package org.onelogin.spring.saml;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class SAMLUserDetailsServiceImpl implements SAMLUserDetailsService {

	private static final Log LOG = LogFactory.getLog(SAMLUserDetailsServiceImpl.class);
	
	@Override
	public Object loadUserBySAML(final SAMLCredential credential)
			throws UsernameNotFoundException {
		
		// The method is supposed to identify local account of user referenced by
		// data in the SAML assertion and return UserDetails object describing the user.
		
		final String userID = credential.getNameID().getValue();
		
		LOG.info(String.format("%s is logged in", userID));
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		final GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
		authorities.add(authority);

		// In a real scenario, this implementation has to locate user in a arbitrary
		// dataStore based on information present in the SAMLCredential and
		// returns such a date in a form of application specific UserDetails object.
		return new User(userID, "*****", true, true, true, true, authorities);
	}
}
