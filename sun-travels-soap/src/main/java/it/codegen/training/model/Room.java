package it.codegen.training.model;

import java.util.List;

public class Room {

    private Integer id;

    private String type;

    private int maxAdults;

    private Hotel hotel;

    private List<ContractRoom> contractRooms;

    public Integer getRoom_id(){
        return id;
    }

    public void setRoom_id(Integer id){
        this.id=id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public int getMaxAdults(){
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults){
        this.maxAdults = maxAdults;
    }

    public void setHotel(Hotel hotel){
        this.hotel=hotel;
    }

    public Hotel getHotel(){
        return hotel;
    }

    public List<ContractRoom> getContractRooms() {
        return contractRooms;
    }

    public void setContractRooms(List<ContractRoom> contractRooms) {
        this.contractRooms = contractRooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id=id;;
    }

}
