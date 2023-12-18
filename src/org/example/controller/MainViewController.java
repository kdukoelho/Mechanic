/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.example.model.ServiceOrder;

/**
 *
 * @author cadu
 */
public class MainViewController {
    private ArrayList<ServiceOrder> serviceOrdersList;
    private JTable table;
    private DefaultTableModel dtm;
    
    public MainViewController(JTable table, ArrayList<ServiceOrder> serviceOrdersList){
        this.serviceOrdersList = serviceOrdersList;
        this.table = table;
        this.dtm = (DefaultTableModel) table.getModel();
    }
    
    public MainViewController(DefaultTableModel dtm, ArrayList<ServiceOrder> serviceOrdersList){
        this.dtm = dtm;
        this.serviceOrdersList = serviceOrdersList;
    }
    
    
    
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
    
    // Remove a linha selecionada da tabela principal e o objeto correspondente da lista de ordem de serviços.
    
    public void removeRow(){
        try{
            int selectedIndex = table.getSelectedRow();
            if (selectedIndex != -1){
                int objectId = Integer.parseInt(dtm.getValueAt(selectedIndex, 7).toString());
                for (ServiceOrder serviceOrder : serviceOrdersList){
                    if(serviceOrder.getId() == objectId){
                        serviceOrdersList.remove(serviceOrder);
                    }
                }
                dtm.removeRow(selectedIndex);
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    // Busca na lista de ordem de serviços, o objeto que corresponde a linha selecionada.
    
    public ServiceOrder getRowObject(int objectId){
        try{
            for (ServiceOrder serviceOrder : serviceOrdersList){
                    if(serviceOrder.getId() == objectId){
                        return serviceOrder;
                    }
                }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}