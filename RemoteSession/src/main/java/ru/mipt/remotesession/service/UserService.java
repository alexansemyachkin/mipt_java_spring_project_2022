package ru.mipt.remotesession.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.User;

public interface UserService extends UserDetailsService {
    public User save(UserDTO registrationDTO);
}
