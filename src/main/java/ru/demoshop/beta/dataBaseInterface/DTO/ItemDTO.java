package ru.demoshop.beta.dataBaseInterface.DTO;

import org.springframework.web.multipart.MultipartFile;
import ru.demoshop.beta.dataBaseInterface.entities.Colors;
import ru.demoshop.beta.dataBaseInterface.entities.Parameters;

import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

        private String categoryName;
        private int price;
        private String name;
        private String info;
        private MultipartFile[] files;
        private String[] colorNames;
        private String[] colorQuantities;
        private Parameters parameters;
        private String[] parameterNames;
        private String[] parameterValues;

    public String[] getColorNames() {
        return colorNames;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setColorNames(String[] colorNames) {
        this.colorNames = colorNames;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setColorQuantities(String[] colorQuantities) {
        this.colorQuantities = colorQuantities;
    }

    public String[] getColorQuantities() {
        return colorQuantities;
    }

    public String getName() {
            return name;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public int getPrice() {
            return price;
        }

        public String getInfo() {
            return info;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public void setPrice(int price) {
            this.price = price;
        }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public String[] getParameterNames() {
        return parameterNames;
    }

    public String[] getParameterValues() {
        return parameterValues;
    }

    public void setParameterNames(String[] parameterNames) {
        this.parameterNames = parameterNames;
    }

    public void setParameterValues(String[] parameterValues) {
        this.parameterValues = parameterValues;
    }
}