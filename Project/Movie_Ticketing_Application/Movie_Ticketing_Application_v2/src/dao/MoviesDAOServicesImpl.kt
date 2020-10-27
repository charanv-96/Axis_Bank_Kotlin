package dao

import model.Movie
import java.sql.ResultSet
import java.sql.Statement

object MoviesDAOServicesImpl : MoviesDAOServices
{
    override fun getDetails(movieName : String)
    {

        val sql = "SELECT * FROM MOVIES WHERE MOVIE_NAME = '$movieName';"
        val conn = getConnection1()
        if (conn != null) {

            val statement: Statement = conn!!.createStatement()

            val result: ResultSet = statement.executeQuery(sql)
            while (result.next()) {
                val movieId: String = result.getString("MOVIE_ID")
                val movieN: String = result.getString("MOVIE_NAME")
                val rating: String = result.getString("RATING")
                val NOT : Int = result.getInt("AVAILABLE_NO_OF_TICKETS")
                println("Movie Name : $movieN \t Rating : $rating \tNumber Of Tickets Available : $NOT")

            }

            connectionClose(conn)

        }
        else
        {
            print("null connection")
        }

    }

    override fun getMovieId(movieName : String) : Int
    {
        val sql = "SELECT MOVIE_ID FROM MOVIES WHERE MOVIE_NAME = '$movieName'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        var res : Int = 0

        while (result.next())
        {
            res = result.getInt("MOVIE_ID")
        }

        return res

    }

    override fun getMovieRating(movieName: String) : String
    {
        val sql = "SELECT RATING FROM MOVIES WHERE MOVIE_NAME = '$movieName'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        var res : String = ""

        while (result.next())
        {
            res = result.getString("RATING")
        }

        return res
    }

    override fun getNoOfTickets(movieName: String) : Int
    {
        val sql = "SELECT AVAILABLE_NO_OF_TICKETS FROM MOVIES WHERE MOVIE_NAME = '$movieName'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        var res : Int = 0

        while (result.next())
        {
            res = result.getInt("AVAILABLE_NO_OF_TICKETS")
        }

        return res
    }

    override fun updateNoOfTickets(movieName: String, noOfTickets : Int)
    {
        val sql = "UPDATE MOVIES \n" +
                "SET AVAILABLE_NO_OF_TICKETS = AVAILABLE_NO_OF_TICKETS - '$noOfTickets' \n" +
                "WHERE MOVIE_NAME = '$movieName';"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        statement.executeUpdate(sql)

    }

    override fun getMovies()
    {

        val sql = "SELECT * FROM MOVIES;"
        val conn = getConnection1()
        if (conn != null) {

            val statement: Statement = conn!!.createStatement()

            val result: ResultSet = statement.executeQuery(sql)

            println("--------------------- Movies Showing Today ------------------------")

            while (result.next()) {
                val movieId: String = result.getString("MOVIE_ID")
                val movieN: String = result.getString("MOVIE_NAME")
                val rating: String = result.getString("RATING")
                val NOT : Int = result.getInt("AVAILABLE_NO_OF_TICKETS")



                println()

                println("Movie Name : $movieN \t Rating : $rating \tNumber Of Tickets Available : $NOT")

                println()

            }

            connectionClose(conn)

        }
        else
        {
            print("null connection")
        }
    }

    override fun getMovie(movieName :String) : Movie
    {
        var movie : Movie = Movie(0,"","",0)

        val sql = "SELECT * FROM MOVIES WHERE MOVIE_NAME = '$movieName';"
        val conn = getConnection1()
        if (conn != null) {

            val statement: Statement = conn!!.createStatement()

            val result: ResultSet = statement.executeQuery(sql)
            while (result.next()) {
                val movieId: Int = result.getInt("MOVIE_ID")
                val movieN: String = result.getString("MOVIE_NAME")
                val rating: String = result.getString("RATING")
                val NOT : Int = result.getInt("AVAILABLE_NO_OF_TICKETS")

                movie.setMovieId(movieId)
                movie.setMovieName(movieN)
                movie.setRating(rating)
                movie.setAvailableNoOfTickets(NOT)


            }

            connectionClose(conn)

        }
        else
        {
            print("null connection")
        }

        return movie

    }

}