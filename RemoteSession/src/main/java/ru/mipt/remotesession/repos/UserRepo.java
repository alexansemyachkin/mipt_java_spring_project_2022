package ru.mipt.remotesession.repos;

import org.springframework.data.repository.CrudRepository;
import ru.mipt.remotesession.models.User;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByName(String name);
}
