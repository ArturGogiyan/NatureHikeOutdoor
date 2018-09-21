package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.UserRole;

import java.util.List;

public interface UserRoleDAO extends CrudRepository<UserRole, Long> {
    List<UserRole> findAllByUserId(long id);

}