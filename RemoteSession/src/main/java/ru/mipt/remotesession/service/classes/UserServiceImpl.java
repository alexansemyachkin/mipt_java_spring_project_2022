package ru.mipt.remotesession.service.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.Role;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.repos.UserRepo;
import ru.mipt.remotesession.service.interfaces.UserService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * UserServiceImpl implementing UserService
 */
@Service
public class UserServiceImpl implements UserService {

    /** Field userRepo */
    private final UserRepo userRepo;


    /** Field password encoder */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * UserServiceImpl constructor
     * @param userRepo UserRepo class Storing data from Data Base
     */
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    /**
     * Updates existing user record in database
     * @param userDTO class transferring data to database
     * @return User object
     */
    @Override
    public User update(UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(),
                userDTO.getGroupNumber(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getPassedExamsAmount(), userDTO.getPassedExamsMarksSum(), userDTO.getAverageMark());
        return userRepo.save(user);
    }

    /**
     * Saves new user to database
     * @param userDTO class transferring data to database
     * @return User object
     */
    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail(),
                userDTO.getGroupNumber(), passwordEncoder.encode(userDTO.getPassword()), List.of(new Role(1, "ROLE_USER")));
        return userRepo.save(user);
    }


    /**
     * @param email User's email
     * @return User object
     */
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
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    /**
     * @param roles User's roles
     * @return collection of GrantedAuthority objects
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
