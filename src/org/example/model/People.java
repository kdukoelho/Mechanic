package org.example.model;

public class People {
    protected static int id_count = 0;
    protected int id;
    String name;
    public People(String name){
        id_count += 1;
        this.id = id_count;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
