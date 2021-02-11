package app.enumeration;

import static app.model.Authority.USER_AUTHORITIES;

public enum Role {

    ROLE_USER(USER_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }

}
