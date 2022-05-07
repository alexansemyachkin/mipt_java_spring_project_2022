package ru.mipt.remotesession.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

public interface UserService extends UserDetailsService {

    /**
     * @param userDTO class transferring data to Data Base
     * @return User object
     * @see UserServiceImpl#save(UserDTO)
     */
    public User save(UserDTO userDTO);
    public User update(UserDTO userDTO);
    public User findByEmail(String email);
}
