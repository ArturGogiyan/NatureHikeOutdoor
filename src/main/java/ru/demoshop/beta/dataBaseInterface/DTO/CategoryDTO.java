package ru.demoshop.beta.dataBaseInterface.DTO;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDTO {

    private String name;
    private MultipartFile file;

    public void setName(String name) {
        this.name = name;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public MultipartFile getFile() {
        return file;
    }
}
