package io.quarkus.vertx.http.runtime.security;

/**
 * Exception indicating that a redirect is required for the authentication flow to complete.
 * For example, it can be used during an OIDC authorization code flow to redirect a user to
 * the original request URI.
 */
public class AuthenticationRedirectException extends RuntimeException {

    int code;
    String redirectUri;

    public AuthenticationRedirectException(String redirectUri) {
        this(302, redirectUri);
    }

    public AuthenticationRedirectException(int code, String redirectUri) {
        this.code = code;
        this.redirectUri = redirectUri;
    }

    public AuthenticationRedirectException(Boolean autoRedirect, String redirectUri) {
        this(autoRedirect ? 302 : 444, redirectUri);
    }

    public int getCode() {
        return this.code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }
}
