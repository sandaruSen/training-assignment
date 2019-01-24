package it.codegen.training.db;

import it.codegen.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "SsContract", namespace = "http://db.training.codegen.it.java.main")
public class SsContract extends it.codegen.Savable
{
 	private int id;
	private CGTimestamp fromDate;
	private CGTimestamp toDate;
	private float markup;
	private int hotelId;
	private List<SsContractRoom> ssContractRooms;
 	private int status;

	public SsContract()
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
					ssContractRoom.setContractId( this.id );
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
		String str = "INSERT INTO SS_CONTRACT ( " 
 		 + "ID, "
		 + "FROM_DATE, "
		 + "TO_DATE, "
		 + "MARKUP, "
		 + "HOTEL_ID )VALUES(?,?,?,?,? )"; 
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.id );
		ps.setTimestamp( ++count,  this.fromDate._getSQLTimestamp() );
		ps.setTimestamp( ++count,  this.toDate._getSQLTimestamp() );
		ps.setFloat( ++count, this.markup );
		ps.setInt( ++count, this.hotelId );
		ps.execute();
		DBUtility.close(ps);
	}

	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM SS_CONTRACT WHERE "
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
		String str = "UPDATE SS_CONTRACT SET "
		 + "FROM_DATE = ?, "
		 + "TO_DATE = ?, "
		 + "MARKUP = ?, "
		 + "HOTEL_ID = ? WHERE "
		 + "ID = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setTimestamp( ++count,  this.fromDate._getSQLTimestamp() );
		ps.setTimestamp( ++count,  this.toDate._getSQLTimestamp() );
		ps.setFloat( ++count, this.markup );
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
		this.fromDate = new CGTimestamp( rs.getTimestamp( "FROM_DATE" ) );
		this.toDate = new CGTimestamp( rs.getTimestamp( "TO_DATE" ) );
		this.markup = rs.getFloat( "MARKUP" );
		this.hotelId = rs.getInt( "HOTEL_ID" );


		if( level > 0 )
		{
			this.ssContractRooms = new ArrayList<SsContractRoom>();
			String strSsContractRooms = "SELECT * FROM SS_CONTRACT_ROOM WHERE "
			 + "CONTRACT_ID = ? ";

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

	public CGTimestamp getFromDate()
	{
		return this.fromDate;
	}

	public void setFromDate( CGTimestamp fromDate )
	{
		this.fromDate = fromDate;
	}

	public CGTimestamp getToDate()
	{
		return this.toDate;
	}

	public void setToDate( CGTimestamp toDate )
	{
		this.toDate = toDate;
	}

	public float getMarkup()
	{
		return this.markup;
	}

	public void setMarkup( float markup )
	{
		this.markup = markup;
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
