package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Password;

public interface PasswordDAO extends CrudRepository<Password, Long> {
    Password findByUserId(long Id);
}
