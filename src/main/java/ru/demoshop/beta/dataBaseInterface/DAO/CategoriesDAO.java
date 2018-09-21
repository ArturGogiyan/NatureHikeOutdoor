package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.entities.Categories;

import java.util.List;

public interface CategoriesDAO extends CrudRepository<Categories, Long> {
    Categories findByNameAndAvailable(String Name, boolean isAvailable);
    List<Categories> findAllByAvailable(boolean isAvailable);
    List<Categories> findAll();
}
