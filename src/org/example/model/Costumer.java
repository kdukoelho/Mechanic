package org.example.model;

public class Costumer extends People{
    String email;
    String phoneNum;
    
    public Costumer(String name, String email, boolean contactIsEmail){
        super(name);
        this.email = email;
    }
    
    public Costumer(String name, String phoneNum){
        super(name);
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Costumer{" + "id=" + id + ", name=" + name + ", email=" + email + ", phoneNum=" + phoneNum + '}';
    }

}
