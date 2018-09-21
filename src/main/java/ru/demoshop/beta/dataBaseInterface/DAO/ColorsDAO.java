package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Colors;

import java.util.List;

public interface ColorsDAO extends CrudRepository<Colors, Long> {
    List<Colors> findAllByItemId(long id);
}
