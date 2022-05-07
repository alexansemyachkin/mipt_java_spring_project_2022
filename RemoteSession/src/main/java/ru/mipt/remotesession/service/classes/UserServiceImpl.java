package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.details.UserDetail;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.repos.UserRepo;
import ru.mipt.remotesession.service.interfaces.UserService;


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



    @Override
    public User update(UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(),
                userDTO.getGroupNumber(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getPassedExamsAmount(), userDTO.getPassedExamsMarksSum());
        return userRepo.save(user);
    }

    /**
     * @param userDTO class transferring data to Data Base
     * @return User object
     */
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(),
                userDTO.getGroupNumber(), passwordEncoder.encode(userDTO.getPassword()));
        return userRepo.save(user);
    }


    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
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
