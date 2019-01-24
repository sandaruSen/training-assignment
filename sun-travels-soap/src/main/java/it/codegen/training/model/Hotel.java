package it.codegen.training.model;

import java.util.List;

public class Hotel {

    private Integer id;

    private String name;

    private List<Contract> contracts;

    private List<Room> rooms;


    public Integer getHotelId() {
        return id;
    }

    public void setHotelId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Contract> getContracts(){
        return contracts;
    }

    public void setContracts(List<Contract> contracts){
        this.contracts=contracts;
    }

    public List<Room> getRooms(){
        return rooms;
    }

    public void setRooms(List<Room> rooms){
        this.rooms=rooms;
    }
}
