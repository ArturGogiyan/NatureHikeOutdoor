package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Items;

import java.util.List;

public interface ItemsDAO extends CrudRepository<Items, Long> {
    Items findByAvailableAndName(boolean isAvailable, String name);
    List<Items> findAllByAvailableAndCategoryId(boolean isAvailable, long id);
    Items findByAvailableAndId(boolean isAvailable, long id);
    List<Items> findAllByAvailable(boolean isAvailable);
    Items findById(long id);
}
