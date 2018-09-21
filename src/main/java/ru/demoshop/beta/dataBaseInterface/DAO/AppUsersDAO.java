package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.AppUsers;

public interface AppUsersDAO extends CrudRepository<AppUsers, Long> {
    AppUsers findById(long id);
    AppUsers findByEmail(String email);
}
