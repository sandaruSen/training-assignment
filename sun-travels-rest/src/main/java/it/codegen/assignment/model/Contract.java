package it.codegen.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SS_CONTRACT")
public class Contract
{
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="FROM_DATE")
	private Date fromDate;

	@Column(name="TO_DATE")
	private Date toDate;

	@Column(name = "MARKUP")
	private float markup;

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

	public Date getFromDate()
	{
		return fromDate;
	}

	public void setFromDate( Date fromDate )
	{
		this.fromDate = fromDate;
	}

	public Date getToDate()
	{
		return toDate;
	}

	public void setToDate( Date toDate )
	{
		this.toDate = toDate;
	}

	public float getMarkup()
	{
		return markup;
	}

	public void setMarkup( float markup )
	{
		this.markup = markup;
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
