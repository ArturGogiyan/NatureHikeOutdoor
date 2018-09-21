package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Colors;
import ru.demoshop.beta.dataBaseInterface.entities.Parameters;

import java.util.List;

public interface ParametersDAO extends CrudRepository<Parameters, Long> {
List<Parameters> findAllByItemId(long id);
}
