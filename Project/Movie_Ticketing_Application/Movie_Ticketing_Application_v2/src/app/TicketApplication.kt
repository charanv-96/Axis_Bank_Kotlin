package app

import controller.MovieController
import controller.TicketController
import controller.UserController
import dao.MoviesDAOServices
import dao.userDAOServices
import model.Movie
import model.Ticket
import model.User
import ticketDAOServices
import java.util.*



fun main()
{

    val movieController = MovieController()
    val userController = UserController()
    val ticketController = TicketController()


    println("----------------Movie Ticket Booking Application--------------------")

    var u : User? = userController.login()

    if (u == null)
    {
        print("wrong username or password")
    }
    else
    {
        var choice : Int = 1

        while (choice != 5)
        {
            println()
            println()
            println("-------------------------------------------------------")
            println("Choice 1 : Book Ticket")
            println("Choice 2 : Cancel Ticket")
            println("Choice 3 : View Ticket")
            println("Choice 4 : Print Ticket")
            println("Choice 5 : Exit Application")
            println("-------------------------------------------------------")

            println("Enter Choice")
            val read3 = Scanner(System.`in`)
            var choice = read3.nextInt()

            when(choice)
            {
                1 ->
                {


                    movieController.getMovies()

                    println("Enter movie name")
                    val read = Scanner(System.`in`)
                    var movieName : String = read.nextLine()

                    var movieObject : Movie = movieController.getMovie(movieName)



                    if(movieObject.getMovieId().equals(0))
                    {
                        println("Enter valid movie name")
                    }
                    else
                    {

                        if (u?.getUserAge()!! < 18)
                        {
                            if(movieObject.getRating().equals("A"))
                            {
                                println("You are not old enough to watch this movie")
                                continue
                            }
                            else
                            {
                                movieObject.display()
                                println("Enter number of tickets")
                                var noOfTickets : Int = read.nextInt()

                                if (movieObject.getAvailableNoOfTickets() >= noOfTickets)
                                {
                                    var t : Ticket = Ticket()

                                    t.display(t.calcTicketCost(u, noOfTickets))

                                    ticketController.insertTicket(u.getUserId(), movieController.getMovieId(movieName), noOfTickets, t.calcTicketCost(u, noOfTickets))
                                    movieController.updateNoOfTickets(movieName, noOfTickets)
                                }
                                else
                                {
                                    print("Tickets Sold Out")
                                }
                            }
                        }
                        else
                        {
                            movieObject.display()
                            println("Enter number of tickets")
                            var noOfTickets : Int = read.nextInt()

                            if (movieObject.getAvailableNoOfTickets() >= noOfTickets)
                            {
                                var t : Ticket = Ticket()

                                t.display(t.calcTicketCost(u, noOfTickets))

                                ticketController.insertTicket(u.getUserId(), movieController.getMovieId(movieName), noOfTickets, t.calcTicketCost(u, noOfTickets))
                                movieController.updateNoOfTickets(movieName, noOfTickets)
                            }
                            else
                            {
                                print("Tickets Sold Out")
                            }

                        }

                    }
                    continue

                }

                2 ->
                {

                    println("Enter Ticket Id")
                    val read = Scanner(System.`in`)
                    var tId : Int = read.nextInt()

                    if(ticketController.checkTable(tId))
                    {
                        ticketController.deleteTicket(tId)
                    }
                    else
                    {
                        println("enter valid ticket Id")
                    }

                    continue
                }

                3 ->
                {

                    println("Enter Ticket Id")
                    val read = Scanner(System.`in`)
                    var tId : Int = read.nextInt()

                    if(ticketController.checkTable(tId))
                    {
                        ticketController.viewTicket(tId)
                    }
                    else
                    {
                        println("enter valid ticket Id")
                    }

                    continue

                }

                4 ->
                {
                    println("Enter Ticket Id")
                    val read = Scanner(System.`in`)
                    var tId : Int = read.nextInt()

                    if(ticketController.checkTable(tId))
                    {
                        ticketController.printTicket(tId)
                    }
                    else
                    {
                        println("enter valid ticket Id")
                    }

                    continue
                }

                5 -> {
                    System.exit(0)
                    continue
                }

                else -> {
                    println("Enter valid choice")
                    continue
                }

            }
        }
    }



}