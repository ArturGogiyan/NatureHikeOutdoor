package ru.demoshop.beta.dataBaseInterface.DTO;


public class ItemSelecterDTO {

    private long id;
    private long itemId;
    private String URL;
    private boolean main;
    private String name;

    public long getItemId() {
        return itemId;
    }

    public long getId() {
        return id;
    }

    public String getURL() {
        return URL;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public boolean isMain() {
        return main;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
