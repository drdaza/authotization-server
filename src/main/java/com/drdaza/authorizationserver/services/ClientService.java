package com.drdaza.authorizationserver.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import com.drdaza.authorizationserver.models.Client;
import com.drdaza.authorizationserver.payloads.CreateClientPayload;
import com.drdaza.authorizationserver.payloads.MessageUserPayload;
import com.drdaza.authorizationserver.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements RegisteredClientRepository{

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    private Client clientFromPayload(CreateClientPayload clientPayload){
        Client client = Client.builder()
                        .clientId(clientPayload.getClientId())
                        .clientSecret(passwordEncoder.encode(clientPayload.getClientSecret()))
                        .authenticationMethods(clientPayload.getAuthenticationMethods())
                        .authorizationGrantTypes(clientPayload.getAuthorizationGrantTypes())
                        .redirectUris(clientPayload.getRedirectUris())
                        .scopes(clientPayload.getScopes())
                        .requireProofKey(clientPayload.isRequireProofKey())
                        .build();
        return client;
    }

    @Override
    public void save(RegisteredClient registeredClient) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public MessageUserPayload create (CreateClientPayload clientPayload) {
        Client client = clientFromPayload(clientPayload);

        clientRepository.save(client);

        return new MessageUserPayload("client" + client.getClientId() + "saved");
    }

    @Override
    public RegisteredClient findById(String id) {
        Client client = clientRepository.findByClientId(id)
                        .orElseThrow(() -> new RuntimeException("Client not foun"));

        return Client.toRegisteredClient(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = clientRepository.findByClientId(clientId)
                        .orElseThrow(() -> new RuntimeException("Client not foun"));

        return Client.toRegisteredClient(client);
    }
}
