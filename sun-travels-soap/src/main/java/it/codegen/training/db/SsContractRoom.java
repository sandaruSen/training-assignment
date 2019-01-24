package it.codegen.training.db;

import it.codegen.Savable;
import it.codegen.SavingSQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import it.codegen.DBUtility;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "SsContractRoom", namespace = "http://db.training.codegen.it.java.main")
public class SsContractRoom extends it.codegen.Savable
{
 	private int noOfRooms;
	private float price;
	private int contractId;
	private int roomId;
 	private int status;

	public SsContractRoom()
	{
	}

	public void checkValidity() throws SavingSQLException
	{
	}
	/**
	 * This insert/modify or update depending on the action
	 */
	public void save( Connection con ) throws SavingSQLException
	{
		String action = "";
		try
		{
			if( this.status == Savable.NEW )
			{
				action = "Inserting";
				checkValidity();
				insert(con);
			}
			else if ( this.status == Savable.MODIFIED )
			{
				action = "Updating";
				checkValidity();
 				update(con);
 			}
			else if (this.status == Savable.DELETED )
			{
				action = "Deleting";
				checkValidity();
				delete(con);
			}
			else if( this.status == Savable.UNCHANGED )
			{
				//Do nothing
			}
			else
			{
				throw new SavingSQLException("Incorret setting of Status flag!");
			}
		}
		catch( SQLException se )
		{
			se.printStackTrace();
			throw new SavingSQLException( "Error in "+ action +
							se.getMessage(),
							se.getSQLState(),
							se.getErrorCode() );
		}
 	}
	/**
	 * This inserts the .........
	 */
	private void insert( Connection con ) throws SQLException
	{
		String str = "INSERT INTO SS_CONTRACT_ROOM ( " 
 		 + "NO_OF_ROOMS, "
		 + "PRICE, "
		 + "CONTRACT_ID, "
		 + "ROOM_ID )VALUES(?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.noOfRooms );
		ps.setFloat( ++count, this.price );
		ps.setInt( ++count, this.contractId );
		ps.setInt( ++count, this.roomId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM SS_CONTRACT_ROOM WHERE "
		 + "CONTRACT_ID = ? AND "
		 + "ROOM_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.contractId );
		ps.setInt( ++count, this.roomId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This updates the .......
	 *
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE SS_CONTRACT_ROOM SET "
		 + "NO_OF_ROOMS = ?, "
		 + "PRICE = ? WHERE "
		 + "CONTRACT_ID = ? AND "
		 + "ROOM_ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.noOfRooms );
		ps.setFloat( ++count, this.price );
		ps.setInt( ++count, this.contractId );
		ps.setInt( ++count, this.roomId );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs, Connection con, int level ) throws SQLException
	{
		this.status = Savable.UNCHANGED;
		this.noOfRooms = rs.getInt( "NO_OF_ROOMS" );
		this.price = rs.getFloat( "PRICE" );
		this.contractId = rs.getInt( "CONTRACT_ID" );
		this.roomId = rs.getInt( "ROOM_ID" );


	}

	public int getNoOfRooms()
	{
		return this.noOfRooms;
	}

	public void setNoOfRooms( int noOfRooms )
	{
		this.noOfRooms = noOfRooms;
	}

	public float getPrice()
	{
		return this.price;
	}

	public void setPrice( float price )
	{
		this.price = price;
	}

	public int getContractId()
	{
		return this.contractId;
	}

	public void setContractId( int contractId )
	{
		this.contractId = contractId;
	}

	public int getRoomId()
	{
		return this.roomId;
	}

	public void setRoomId( int roomId )
	{
		this.roomId = roomId;
	}

	public int getStatus()
	{
		return this.status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}

}
