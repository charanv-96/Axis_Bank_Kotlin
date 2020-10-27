package model


class Movie(movie_id : Int, movie_name : String, rating : String, availableNoOfTickets : Int)
{
    private var movieId : Int = 0
    private var movieName : String = ""
    private var rating : String = ""
    private var availableNoOfTickets : Int = 0

    init
    {
        this.movieId = movie_id
        this.movieName = movie_name
        this.rating = rating
        this.availableNoOfTickets = availableNoOfTickets
    }

    public fun getMovieId() : Int
    {
        return this.movieId
    }

    public fun getMovieName() : String
    {
        return this.movieName
    }

    public fun getRating() : String
    {
        return this.rating
    }

    public fun getAvailableNoOfTickets() : Int
    {
        return this.availableNoOfTickets
    }

    public fun setMovieId(mid : Int)
    {
        this.movieId = mid
    }

    public fun setMovieName(name : String)
    {
        this.movieName = name
    }

    public fun setRating(rating: String)
    {
        this.rating = rating
    }

    public fun setAvailableNoOfTickets(NOT : Int)
    {
        this.availableNoOfTickets = NOT
    }

    public fun display()
    {
        println("Movie Name : $movieName \t Rating : $rating \t Available No of Tickets : $availableNoOfTickets")
    }

}
