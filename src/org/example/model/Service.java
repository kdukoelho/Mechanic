package org.example.model;

public class Service extends CommonServicePart{
    private static int id_count;
    private int operationTime;
    
    public Service(){
        this.id = id_count++;
    }
    
    public Service(String name, float price, int operationTime, String description){
        super(id_count++, name, description, price);
        this.operationTime = operationTime;
    }

    public int getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(int operationTime) {
        this.operationTime = operationTime;
    }

    @Override
    public String toString() {
        return "Service{" + "operationTime=" + operationTime + '}';
    }
    
    
}
