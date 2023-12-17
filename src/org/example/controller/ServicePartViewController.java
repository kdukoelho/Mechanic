/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.example.model.Part;
import org.example.model.Service;
import org.example.model.ServiceOrder;

/**
 *
 * @author cadu
 */
public class ServicePartViewController {
    private final ServiceOrder serviceOrder;
    
    public ServicePartViewController(ServiceOrder serviceOrder){
        this.serviceOrder = serviceOrder;
    }
    
    // Adiciona as informações de serviços na tabela informada.
    
    public void addServicesRows(DefaultTableModel dtm){
        try{
            List<Service> performedServicesList = serviceOrder.getServicesPerformedList();
            for (Service service : performedServicesList){
                Object[] dataRow = new Object[4];
                dataRow[0] = service.getName();
                dataRow[1] = service.getPrice();
                dataRow[2] = service.getOperationTime();
                dataRow[3] = service.getDescription();
                dtm.addRow(dataRow);
                System.out.println(dataRow);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    // Adiciona as informações de peças na tabela informada.
    
    public void addPartsRow(DefaultTableModel dtm){
        try{
            List<Part> replacedPartsList = serviceOrder.getReplacedPartsList();
            for (Part part : replacedPartsList){
                Object[] dataRow = new Object[5];
                dataRow[0] = part.getName();
                dataRow[1] = part.getPrice();
                dataRow[2] = part.getBrand();
                dataRow[3] = part.getDescription();
                dataRow[4] = part.getMeasure();
                dtm.addRow(dataRow);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
