package ru.demoshop.beta.dataBaseInterface.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.demoshop.beta.dataBaseInterface.DTO.ItemSelecterDTO;
import ru.demoshop.beta.dataBaseInterface.entities.Images;
import ru.demoshop.beta.dataBaseInterface.entities.Items;

import java.util.List;

public interface ImagesDAO extends CrudRepository<Images, Long> {
    @Query("SELECT im, it.name FROM Images im INNER JOIN Items it ON im.itemId=it.id WHERE it.categoryId = ?2")
    List<Images> findALLByCategoryId(long categoryId);
    List<Images> findAllByItemId(long itemId);
}