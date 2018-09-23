package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.UsersCart;

public interface UsersCartDAO extends CrudRepository<UsersCart, Long> {

}
