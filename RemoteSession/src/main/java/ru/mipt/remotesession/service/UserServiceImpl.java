package ru.mipt.remotesession.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.details.UserDetail;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.repos.UserRepo;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    /** Field User Reporitory */
    private UserRepo userRepo;


    /** Field password encoder */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * UserServiceImpl constructor
     * @param userRepo subjectRepo class Storing data from Data Base
     */
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    /**
     * @param userDTO class transferring data to Data Base
     * @return User object
     */
    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(),
                userDTO.getGroupNumber(), passwordEncoder.encode(userDTO.getPassword()));
        return userRepo.save(user);
    }


    /**
     * Provides UserDetails of User by name.
     * @param username String username of the User
     * @return UserDetails of User
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new UserDetail(user);
    }
}
