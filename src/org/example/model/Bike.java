package org.example.model;

public class Bike extends Vehicle{
    public Bike(String brand, String model, String fabricationDate, String modelYear, float kilometersDrove, int fuelLevelInPercents){
        super(brand, model, fabricationDate, modelYear, kilometersDrove, fuelLevelInPercents);
    }

    @Override
    public String toString() {
        return "Bike{" + '}';
    }    
}
