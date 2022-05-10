package ru.mipt.remotesession.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

/**
 * UserService interface extending UserDetailsService
 * @see UserServiceImpl
 */
public interface UserService extends UserDetailsService {

    /**
     * @param userDTO class transferring data to database
     * @return User object
     * @see UserServiceImpl#save(UserDTO)
     */
    User save(UserDTO userDTO);

    /**
     * @param userDTO class transferring data to database
     * @return User object
     * @see UserServiceImpl#update(UserDTO)
     */
    User update(UserDTO userDTO);

    /**
     * @param email User's email
     * @return User object
     * @see UserServiceImpl#findByEmail(String)
     */
    User findByEmail(String email);
}
