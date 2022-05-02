package ru.mipt.remotesession.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mipt.remotesession.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

/**
 * UserDetail class Implementing UserDetails */
public class UserDetail implements UserDetails {
    /** Field User */
    private User user;

    /**
     * UserDetail constructor
     * @param user
     */
    public UserDetail(User user){
        this.user = user;
    }


    /**
     * Provides collection of User's authorities
     * @return Collection of authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    /**
     * Provides User's password
     * @return String User's password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Provides User's username
     * @return String User's username
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Tells if user's account is expired or not
     * @return true if not expired, false if not
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Tells if user's account is locked or not
     * @return true if not locked, false if not
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Tells if user's credentials are expired or not
     * @return true if not expired, false if not
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Tells if user's account is enabled or not
     * @return true if not enabled, false if not
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
