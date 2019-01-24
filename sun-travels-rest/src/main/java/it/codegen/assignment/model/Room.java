package it.codegen.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SS_ROOM")
public class Room
{
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="TYPE")
	private String type;

	@Column(name = "MAX_ADULTS")
	private int maxAdults;

	@Column(name="HOTEL_ID")
	private int hotelID;

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public int getMaxAdults()
	{
		return maxAdults;
	}

	public void setMaxAdults( int maxAdults )
	{
		this.maxAdults = maxAdults;
	}

	public int getHotelID()
	{
		return hotelID;
	}

	public void setHotelID( int hotelID )
	{
		this.hotelID = hotelID;
	}
}
