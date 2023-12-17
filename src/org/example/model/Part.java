package org.example.model;


public class Part extends CommonServicePart{
    private static int id_count = 0;
    private String brand;
    private String measure;
    
    public Part(){
        this.id_count++;
    }
    
    public Part(String name, float price, String brand, String description, String measure) {
        super(id_count++, name, description, price);
        this.brand = brand;
        this.measure = measure;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Part{" + "brand=" + brand + ", measure=" + measure + '}';
    }
    
    
}
