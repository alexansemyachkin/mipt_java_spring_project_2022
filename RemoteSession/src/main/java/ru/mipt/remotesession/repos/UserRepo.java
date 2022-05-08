package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mipt.remotesession.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    /**
     * Finds User by email.
     * @param email String user email
     * @return User
     */
    public User findByEmail(String email);
}
