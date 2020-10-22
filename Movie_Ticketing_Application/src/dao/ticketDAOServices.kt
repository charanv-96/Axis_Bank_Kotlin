import dao.connectionClose
import dao.getConnection1
import java.io.File
import java.io.IOException
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

class ticketDAOServices
{
    fun insertTicket(USER_ID: Int, MOVIE_ID: Int, NO_OF_TICKETS: Int, COST: Double):Boolean
    {
        val conn = getConnection1()

        var sql:String="INSERT INTO TICKETS (USER_ID, MOVIE_ID, NO_OF_TICKETS, COST) " +
                "VALUES (?, ?, ?, ?)";

        var statement: PreparedStatement? = conn?.prepareStatement(sql);

        if (statement != null) {
            statement.setInt(1, USER_ID)
        };

        if (statement != null) {
            statement.setInt(2, MOVIE_ID)
        };
        if (statement != null) {
            statement.setInt(3, NO_OF_TICKETS)
        };
        if (statement != null) {
            statement.setDouble(4, COST)
        };


        var rowsInserted: Int? = statement?.executeUpdate()
        if (rowsInserted != null) {
            if (rowsInserted > 0) {
                System.out.println("A new ticket was inserted successfully!");}
        }
        return true;
    }

    fun checkTable(tId : Int) : Boolean
    {
        val sql = "SELECT * FROM TICKETS WHERE TICKET_ID = '$tId'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        if (result.next())
        {
            return true
        }
        else
        {
            return false
        }

    }

    fun deleteTicket(tId: Int)
    {
        val conn = getConnection1()
        val sql = "DELETE FROM TICKETS WHERE TICKET_ID = '$tId'"
        val statement: Statement = conn!!.createStatement()
        statement.executeUpdate(sql)

        println("Ticket was cancelled successfully")

    }

    fun viewTicket(tId: Int)
    {
        val sql = "SELECT * FROM TICKETS WHERE TICKET_ID = '$tId'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)


        while (result.next()) {
            val TICKET_ID : Int = result.getInt(1)
            val USER_ID : Int = result.getInt(2)
            val MOVIE_ID : Int = result.getInt(3)
            val NO_OF_TICKETS : Int = result.getInt(4)
            val COST : Int = result.getInt(5)

            val statement1 : Statement = conn!!.createStatement()
            val sql1 = "SELECT MOVIE_NAME FROM MOVIES WHERE MOVIE_ID = '$MOVIE_ID'"
            val result1 : ResultSet = statement1.executeQuery(sql1)
            var movieName : String = ""
            while (result1.next()) {
                movieName = result1.getString("MOVIE_NAME")
            }



            println("Ticket Id : $TICKET_ID \nUser Id : $USER_ID \n" +
                    "Movie Name : $movieName \nNumber Of Tickets : $NO_OF_TICKETS" +
                    "\nCOST : $COST")
        }

        connectionClose(conn)
    }


    fun printTicket(tId : Int)
    {
        val sql = "SELECT * FROM TICKETS WHERE TICKET_ID = '$tId'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        try {

            while (result.next()) {
                val TICKET_ID : String = result.getString(1)
                val USER_ID : String = result.getString(2)
                val MOVIE_ID : String = result.getString(3)
                val NO_OF_TICKETS : String = result.getString(4)
                val COST : Int = result.getInt(5)

                val statement1 : Statement = conn!!.createStatement()
                val sql1 = "SELECT MOVIE_NAME FROM MOVIES WHERE MOVIE_ID = '$MOVIE_ID'"
                val result1 : ResultSet = statement1.executeQuery(sql1)
                var movieName : String = ""
                while (result1.next()) {
                    movieName = result1.getString("MOVIE_NAME")
                }

                println()

                val fileName = "$tId.txt"
                val myfile = File(fileName)

                val content = "Ticket Id : $TICKET_ID \nUser Id : $USER_ID \n" +
                        "Movie Name : $movieName \nNumber Of Tickets : $NO_OF_TICKETS" +
                        "\nCOST : $COST"

                myfile.writeText(content)

                println("ticket printed")
            }


        }
        catch (e : IOException)
        {
            print("IO exception")
        }
        finally {
            connectionClose(conn)
        }


    }

}

