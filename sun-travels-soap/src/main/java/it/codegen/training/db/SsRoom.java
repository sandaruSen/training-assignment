package it.codegen.training.db;

import it.codegen.Savable;
import it.codegen.SavingSQLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import it.codegen.DBUtility;
import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "SsRoom", namespace = "http://db.training.codegen.it.java.main")
public class SsRoom extends it.codegen.Savable
{
 	private int id;
	private String type;
	private int maxAdults;
	private int hotelId;
	private List<SsContractRoom> ssContractRooms;
 	private int status;

	public SsRoom()
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

		if( this.status != Savable.DELETED )
		{
			if( this.ssContractRooms != null )
			{
				for( SsContractRoom ssContractRoom : ssContractRooms )
				{
					if( this.status == Savable.NEW )
					{
						ssContractRoom.setStatus( Savable.NEW );
					}
					ssContractRoom.setRoomId( this.id );
					ssContractRoom.save( con );
				}
			}
		}
 	}
	/**
	 * This inserts the .........
	 */
	private void insert( Connection con ) throws SQLException
	{
		String str = "INSERT INTO SS_ROOM ( " 
 		 + "ID, "
		 + "TYPE, "
		 + "MAX_ADULTS, "
		 + "HOTEL_ID )VALUES(?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.id );
		ps.setString( ++count, this.type );
		ps.setInt( ++count, this.maxAdults );
		ps.setInt( ++count, this.hotelId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM SS_ROOM WHERE "
		 + "ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.id );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This updates the .......
	 *
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE SS_ROOM SET "
		 + "TYPE = ?, "
		 + "MAX_ADULTS = ?, "
		 + "HOTEL_ID = ? WHERE "
		 + "ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setString( ++count, this.type );
		ps.setInt( ++count, this.maxAdults );
		ps.setInt( ++count, this.hotelId );
		ps.setInt( ++count, this.id );
		ps.execute();
		DBUtility.close(ps);
	}
	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs, Connection con, int level ) throws SQLException
	{
		this.status = Savable.UNCHANGED;
		this.id = rs.getInt( "ID" );
		this.type = rs.getString( "TYPE" );
		this.maxAdults = rs.getInt( "MAX_ADULTS" );
		this.hotelId = rs.getInt( "HOTEL_ID" );


		if( level > 0 )
		{
			this.ssContractRooms = new ArrayList<SsContractRoom>();
			String strSsContractRooms = "SELECT * FROM SS_CONTRACT_ROOM WHERE "
			 + "ROOM_ID = ? ";

			PreparedStatement psSsContractRooms = con.prepareStatement( strSsContractRooms );
			int countSsContractRooms = 1;
			psSsContractRooms.setInt( countSsContractRooms++, this.id );
			ResultSet rsSsContractRooms = psSsContractRooms.executeQuery();
			while( rsSsContractRooms.next() )
			{
				SsContractRoom ssContractRoom = new SsContractRoom();
				ssContractRoom.load( rsSsContractRooms, con, level - 1 );
				this.ssContractRooms.add( ssContractRoom );
			}//while( rs" + variableSuffix +".next() )
			DBUtility.close(rsSsContractRooms);
			DBUtility.close(psSsContractRooms);
		}//if( level > 0 )
	}

	public int getId()
	{
		return this.id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public int getMaxAdults()
	{
		return this.maxAdults;
	}

	public void setMaxAdults( int maxAdults )
	{
		this.maxAdults = maxAdults;
	}

	public int getHotelId()
	{
		return this.hotelId;
	}

	public void setHotelId( int hotelId )
	{
		this.hotelId = hotelId;
	}

	public List<SsContractRoom> getSsContractRooms()
	{
		return this.ssContractRooms;
	}

	public void setSsContractRooms( List<SsContractRoom> ssContractRooms )
	{
		this.ssContractRooms = ssContractRooms;
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
