package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ServiceOrder {
    private static int id_count = 0;
    private int id;
    private float servicePrice;
    private Date maintenanceDate;
    private Costumer costumer;
    private Mechanic mechanic;
    private Vehicle vehicle;
    private List<Part> replacedPartsList;
    private List<Service> servicesPerformedList;

    public ServiceOrder(Costumer costumer, Mechanic mechanic, Vehicle vehicle) {
        id_count++;
        this.id = id_count;
        this.costumer = costumer;
        this.mechanic = mechanic;
        this.vehicle = vehicle;
        this.replacedPartsList = new ArrayList<>();
        this.servicesPerformedList = new ArrayList<>();
    }
    
    public ServiceOrder(Costumer costumer, Mechanic mechanic, Vehicle vehicle, List<Part> replacedPartsList, List<Service> servicesPerformedList){
        id_count++;
        this.id = id_count;
        this.costumer = costumer;
        this.mechanic = mechanic;
        this.vehicle = vehicle;
        this.replacedPartsList = replacedPartsList;
        this.servicesPerformedList = servicesPerformedList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void addReplacedPart(Part part){
        try{
            this.replacedPartsList.add(part);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void removeReplacedPart(Part part){
        try{
            this.replacedPartsList.remove(part);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public List<Part> getReplacedPartsList() {
        return replacedPartsList;
    }

    public void setReplacedPartsList(List<Part> replacedPartsList) {
        this.replacedPartsList = replacedPartsList;
    }

    public List<Service> getServicesPerformedList() {
        return servicesPerformedList;
    }

    public void setServicesPerformedList(List<Service> servicesPerformedList) {
        this.servicesPerformedList = servicesPerformedList;
    }

    public void addServicePerformed(Service service){
        try{
            this.servicesPerformedList.add(service);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void removeServicePerformed(Service service){
        try{
            this.servicesPerformedList.remove(service);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    // Calcula o valor final da ordem de serviço.
    
    public float calculateFinalPrice(){
        try{
            float finalValue = 0;
            for (Part part : replacedPartsList){
                finalValue += part.getPrice();
            }
            for (Service service : servicesPerformedList){
                finalValue += service.getPrice();
            }
            return finalValue;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" + "id=" + id + ", servicePrice=" + servicePrice + ", maintenanceDate=" + maintenanceDate + ", costumer=" + costumer + ", mechanic=" + mechanic + ", vehicle=" + vehicle + ", replacedPartsList=" + replacedPartsList + ", servicesPerformedList=" + servicesPerformedList + '}';
    }
    
    
}