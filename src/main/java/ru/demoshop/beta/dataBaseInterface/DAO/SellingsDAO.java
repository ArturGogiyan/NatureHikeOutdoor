package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Sellings;

public interface SellingsDAO extends CrudRepository<Sellings, Long> {

}
