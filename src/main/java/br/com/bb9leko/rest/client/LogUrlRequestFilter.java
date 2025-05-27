package br.com.bb9leko.rest.client;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LogUrlRequestFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        System.out.println("Chamando URL: " + requestContext.getUri());
    }
}