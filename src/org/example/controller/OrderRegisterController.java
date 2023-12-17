/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.example.model.Bike;
import org.example.model.Car;
import org.example.model.Costumer;
import org.example.model.Mechanic;
import org.example.model.Part;
import org.example.model.Service;
import org.example.model.ServiceOrder;
import org.example.model.Vehicle;

/**
 *
 * @author cadu
 */
public class OrderRegisterController {
    private DefaultTableModel dtm;
    private static ArrayList<ServiceOrder> serviceOrdersList;
    List<Part> partsList;
    List<Service> servicesList;
    

    public OrderRegisterController(DefaultTableModel dtm){
        this.dtm = dtm;
        this.serviceOrdersList = new ArrayList<>();
        this.servicesList = new ArrayList<>();
        this.partsList = new ArrayList<>();
    }
    
    // Getter 
    
        public ArrayList<ServiceOrder> getServiceOrdersList(){
        return this.serviceOrdersList;
    }
    
    
    // Instancia um objeto de ordem de serviço.
    
    public ServiceOrder createServiceOrder(Costumer costumer, Mechanic mechanic, Vehicle vehicle, List<Service> servicesPerformedList, List<Part> replacedPartsList){
        try{
            ServiceOrder serviceOrder;
            serviceOrder = new ServiceOrder(costumer, mechanic, vehicle, replacedPartsList, servicesPerformedList);
            OrderRegisterController.serviceOrdersList.add(serviceOrder);
            return serviceOrder;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // Instancia um objeto cliente.
    
    public Costumer createCostumer(String name, String contact, boolean contactIsEmail){
        try{
            if(contactIsEmail){
                 return new Costumer(name, contact, true);
            }
            else{
                return new Costumer(name, contact);
            } 
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // Instacia um objeto mecanico.
    
    public Mechanic createMechanic(String name){
        try{
            return new Mechanic(name);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // Instancia um objeto veículo.
    
    public Vehicle createVehicle(String model, String brand, String vehicleYear, String modelYear, float kilometersDrove, int fuelLevelInPercents, boolean vehicleIsCar){
        try{
            if(vehicleIsCar){
                return new Car(model, brand, vehicleYear, modelYear, kilometersDrove, fuelLevelInPercents);
            }
            else{
                return new Bike(model, brand, vehicleYear, modelYear, kilometersDrove, fuelLevelInPercents);
            }
        } catch(Exception ex){
           System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // Recupera em forma de lista, informações de peças cadastradas na tabela de peças em OrderRegister.
    
    public List<Part> getPartsFromTable(JTable table){
        try{
            List<Part> list = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            for (int i = 0; i < model.getRowCount(); i++){
                list.add(new Part(model.getValueAt(i, 0).toString(), Float.parseFloat(model.getValueAt(i, 1).toString()), model.getValueAt(i, 2).toString(), model.getValueAt(i, 3).toString(), model.getValueAt(i, 4).toString()));
            }
            this.partsList = list;
            return list;
        } catch(Exception ex){
           System.out.println(ex.getMessage());
        }
        return null;
    }
    
    // Recupera em forma de lista, informações de serviços cadastradas na tabela de serviços em OrderRegister.
    
    public List<Service> getServicesFromTable(JTable table){
        try{
            List<Service> list = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            for (int i = 0; i < model.getRowCount(); i++){
                list.add(new Service(model.getValueAt(i, 0).toString(), Float.parseFloat(model.getValueAt(i, 1).toString()), Integer.parseInt(model.getValueAt(i, 2).toString()), model.getValueAt(i, 3).toString()));
            }
            this.servicesList = list;
            return list;
        } catch(Exception ex){
           System.out.println(ex.getMessage());
        }
        return null;
        }
    
    
    // Adiciona a ordem de serviço cadastrada na JTable da MainView.
    
    public void addRow(ServiceOrder serviceOrder){
        try{
            Object[] dataRow = new Object[9];
            dataRow[0] = serviceOrder.getCostumer().getName();
            dataRow[1] = serviceOrder.getCostumer().getEmail() == null ? serviceOrder.getCostumer().getPhoneNum() : serviceOrder.getCostumer().getEmail();
            dataRow[2] = String.valueOf(LocalDateTime.now().getYear());
            dataRow[3] = String.format("%s %s %s", serviceOrder.getVehicle().getBrand(), serviceOrder.getVehicle().getModel(), serviceOrder.getVehicle().getModelYear());
            dataRow[4] = serviceOrder.getVehicle().getKilometersDrove();
            dataRow[5] = serviceOrder.getVehicle().getFuelLevelInPercents() + "%";
            dataRow[6] = serviceOrder.getMechanic().getName();
            dataRow[7] = serviceOrder.getId();
            dataRow[8] = "R$" + serviceOrder.calculateFinalPrice();
            
            this.dtm.addRow(dataRow);         
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
