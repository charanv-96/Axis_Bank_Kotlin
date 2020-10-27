package dao
import java.sql.PreparedStatement
import dao.getConnection1
import model.Movie
import java.sql.ResultSet
import java.sql.Statement

interface MoviesDAOServices
{
    fun getDetails(movieName : String)

    fun getMovieId(movieName : String) : Int

    fun getMovieRating(movieName: String) : String

    fun getNoOfTickets(movieName: String) : Int

    fun updateNoOfTickets(movieName: String, noOfTickets : Int)

    fun getMovies()

    fun getMovie(movieName :String) : Movie


}


