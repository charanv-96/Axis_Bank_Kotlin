import dao.connectionClose
import dao.getConnection1
import java.io.File
import java.io.IOException
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

interface ticketDAOServices
{
    fun insertTicket(USER_ID: Int, MOVIE_ID: Int, NO_OF_TICKETS: Int, COST: Double):Boolean

    fun checkTable(tId : Int) : Boolean

    fun deleteTicket(tId: Int)

    fun viewTicket(tId: Int)

    fun printTicket(tId : Int)

}

