package ru.mipt.remotesession.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.repos.UserRepo;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * @param userDTO class transferring data to Data Base
     * @return User object
     * @see UserServiceImpl#save(UserDTO) 
     */
    public User save(UserDTO userDTO);
}
