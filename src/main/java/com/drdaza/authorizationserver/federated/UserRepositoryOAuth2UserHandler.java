package com.drdaza.authorizationserver.federated;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.drdaza.authorizationserver.models.GoogleUser;
import com.drdaza.authorizationserver.repositories.GoogleUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public final class UserRepositoryOAuth2UserHandler implements Consumer<OAuth2User> {

	private final GoogleUserRepository googleUserRepository;

	@Override
	public void accept(OAuth2User user) {
		// Capture user in a local data store on first authentication
		log.info("asdaosndaisujldnaiwluefhbnwiqlruefhilqweurghtwloieruthweriuthweioruthweri--------------------------------");
		if (!this.googleUserRepository.findByEmail(user.getName()).isPresent()) {
			GoogleUser googleUser = GoogleUser.fromOauth2User(user);
			log.info(googleUser.toString());
			this.googleUserRepository.save(googleUser);
		} else {
			log.info("bienvenido {}", user.getAttributes().get("given_name"));
		}

	}

	

}
