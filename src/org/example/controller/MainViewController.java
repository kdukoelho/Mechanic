/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controller;

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