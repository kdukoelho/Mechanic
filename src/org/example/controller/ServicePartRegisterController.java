/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.example.model.Part;
import org.example.model.Service;

/**
 *
 * @author cadu
 */
public class ServicePartRegisterController {
    private DefaultTableModel dtm;
    private List<Service> servicesList;
    private List<Part> partsList;
    
    public ServicePartRegisterController(DefaultTableModel dtm){
        this.dtm = dtm;
    }
    
    public void addRow(Part part){
        try{
            Object rowData[] = new Object[5];
            rowData[0] = part.getName();
            rowData[1] = part.getPrice();
            rowData[2] = part.getBrand();
            rowData[3] = part.getDescription();
            rowData[4] = part.getMeasure();
            dtm.addRow(rowData);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void addRow(Service service){
        try{
            Object rowData[] = new Object[4];
            rowData[0] = service.getName();
            rowData[1] = service.getPrice();
            rowData[2] = service.getOperationTime();
            rowData[3] = service.getDescription();
            dtm.addRow(rowData);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
