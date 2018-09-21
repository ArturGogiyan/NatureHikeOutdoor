package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Orders;

public interface OrdersDAO extends CrudRepository<Orders, Long> {

}
