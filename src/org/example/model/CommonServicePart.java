package org.example.model;

public class CommonServicePart {
    protected int id;
    private String name;
    private String description;
    private float price;

    public CommonServicePart(){
        
    }    
    
    public CommonServicePart(int id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CommonServicePart{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + '}';
    }
    
    
}
