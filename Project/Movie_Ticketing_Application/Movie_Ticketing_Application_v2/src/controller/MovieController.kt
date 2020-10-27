package controller

import model.Movie
import service.MovieServiceImpl
import dao.MoviesDAOServicesImpl



class MovieController
{

    val movieService = MovieServiceImpl
    val moviesDAOServices = MoviesDAOServicesImpl

    fun getDetails(movieName : String)
    {
       moviesDAOServices.getDetails(movieName)
    }

    fun getMovieId(movieName : String) : Int
    {
        return moviesDAOServices.getMovieId(movieName)
    }

    fun getMovieRating(movieName: String) : String
    {
        return moviesDAOServices.getMovieRating(movieName)
    }

    fun getNoOfTickets(movieName: String) : Int
    {
        return moviesDAOServices.getNoOfTickets(movieName)
    }

    fun updateNoOfTickets(movieName: String, noOfTickets : Int)
    {
        moviesDAOServices.updateNoOfTickets(movieName, noOfTickets)
    }

    fun getMovies()
    {
        moviesDAOServices.getMovies()
    }

    fun getMovie(movieName :String) : Movie
    {
        return moviesDAOServices.getMovie(movieName)
    }

}