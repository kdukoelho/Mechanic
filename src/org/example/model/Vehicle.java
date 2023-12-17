package org.example.model;

public class Vehicle {
    private static int id_count = 0;
    private int id;
    private String brand;
    private String model;
    private String fabricationDate;
    private String modelYear;
    private float kilometersDrove;
    private int fuelLevelInPercents;

    public Vehicle(String brand, String model, String fabricationDate, String modelYear, float kilometersDrove, int fuelLevelInPercents) {
        id_count++;
        this.id = id_count;
        this.brand = brand;
        this.model = model;
        this.fabricationDate = fabricationDate;
        this.modelYear = modelYear;
        this.kilometersDrove = kilometersDrove;
        this.fuelLevelInPercents = fuelLevelInPercents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(String fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public float getKilometersDrove() {
        return kilometersDrove;
    }

    public void setKilometersDrove(float kilometersDrove) {
        this.kilometersDrove = kilometersDrove;
    }

    public int getFuelLevelInPercents() {
        return fuelLevelInPercents;
    }

    public void setFuelLevelInPercents(int fuelLevelInPercents) {
        this.fuelLevelInPercents = fuelLevelInPercents;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", brand=" + brand + ", model=" + model + ", fabricationDate=" + fabricationDate + ", modelYear=" + modelYear + ", kilometersDrove=" + kilometersDrove + ", fuelLevelInPercents=" + fuelLevelInPercents + '}';
    }
    
}
