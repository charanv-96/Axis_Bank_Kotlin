package model


class Movie(movie_id : Int, movie_name : String)
{
    private var movieId : Int = 0
    private var movieName : String = ""

    init
    {
        this.movieId = movie_id
        this.movieName = movie_name
    }

    public fun getMovieId() : Int
    {
        return this.movieId
    }

    public fun getMovieName() : String
    {
        return this.movieName
    }

    public fun setMovieId(mid : Int)
    {
        this.movieId = mid
    }

    public fun setMovieName(name : String)
    {
        this.movieName = name
    }

}
