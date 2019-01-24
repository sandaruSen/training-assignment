package it.codegen.assignment.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SS_CONTRACT_ROOM")
public class ContractRoom implements Serializable
{
	@Column(name = "NO_OF_ROOMS")
	private  int noOfRooms;

	@Column(name="PRICE")
	private float price;

//	@Id
//	@ManyToOne
//	@Column(name = "CONTRACT_ID")
//	private Contract contract;
//
//	@Id
//	@ManyToOne
//	@Column(name="ROOM_ID")
//	private Room room;

	@EmbeddedId
	private ContractRoomId id;

	public int getNoOfRooms()
	{
		return noOfRooms;
	}

	public void setNoOfRooms( int noOfRooms )
	{
		this.noOfRooms = noOfRooms;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice( float price )
	{
		this.price = price;
	}

//	public int getContractId()
//	{
//		return contractId;
//	}
//
//	public void setContractId( int contractId )
//	{
//		this.contractId = contractId;
//	}
//
//	public int getRoom_id()
//	{
//		return room_id;
//	}
//
//	public void setRoom_id( int room_id )
//	{
//		this.room_id = room_id;
//	}



}
