package model

import dao.MoviesDAOServices
import dao.userDAOServices
import ticketDAOServices
import java.util.*

fun login() : User?
{

    var u : User? = null
    var flag : Boolean = false
    var udao : userDAOServices = userDAOServices()

    println("Enter User Name")
    val read1 = Scanner(System.`in`)
    var name : String = read1.nextLine()

    if(udao.checkUserName(name))
    {
        println("Enter Password")
        val read2 = Scanner(System.`in`)
        var passwd : String = read2.nextLine()

        if (udao.checkPassword(passwd))
        {
            u = udao.getUser(name)
            print(u?.getUserAge())
        }
        else
        {
            println("wrong password")
            login()
        }
    }
    else
    {
        println("wrong password")
        login()
    }

    return u

}

fun main()
{


    println("----------------Movie Ticket Booking Application--------------------")

    var u : User? = login()

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

                    var mdao : MoviesDAOServices = MoviesDAOServices()

                    mdao.getMovies()

                    println("Enter movie name")
                    val read = Scanner(System.`in`)
                    var movieName : String = read.nextLine()

                    if(mdao.getMovieId(movieName).equals(0))
                    {
                        println("Enter valid movie name")
                    }
                    else
                    {

                        if (u?.getUserAge()!! < 18)
                        {
                            if(mdao.getMovieRating(movieName).equals("A"))
                            {
                                println("You are not old enough to watch this movie")
                                continue
                            }
                            else
                            {
                                mdao.getDetails(movieName)
                                println("Enter number of tickets")
                                var noOfTickets : Int = read.nextInt()

                                if (mdao.getNoOfTickets(movieName) >= noOfTickets)
                                {
                                    var t : Ticket = Ticket()

                                    t.display(t.calcTicketCost(u, noOfTickets))

                                    val tdao : ticketDAOServices = ticketDAOServices()

                                    tdao.insertTicket(u.getUserId(), mdao.getMovieId(movieName), noOfTickets, t.calcTicketCost(u, noOfTickets))
                                    mdao.updateNoOfTickets(movieName, noOfTickets)
                                }
                                else
                                {
                                    print("Tickets Sold Out")
                                }
                            }
                        }
                        else
                        {
                            mdao.getDetails(movieName)
                            println("Enter number of tickets")
                            var noOfTickets : Int = read.nextInt()

                            if (mdao.getNoOfTickets(movieName) >= noOfTickets)
                            {
                                var t : Ticket = Ticket()

                                t.display(t.calcTicketCost(u, noOfTickets))

                                val tdao : ticketDAOServices = ticketDAOServices()

                                tdao.insertTicket(u.getUserId(), mdao.getMovieId(movieName), noOfTickets, t.calcTicketCost(u, noOfTickets))
                                mdao.updateNoOfTickets(movieName, noOfTickets)
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

                    var tdao : ticketDAOServices = ticketDAOServices()

                    if(tdao.checkTable(tId))
                    {
                        tdao.deleteTicket(tId)
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

                    var tdao : ticketDAOServices = ticketDAOServices()

                    if(tdao.checkTable(tId))
                    {
                        tdao.viewTicket(tId)
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

                    var tdao : ticketDAOServices = ticketDAOServices()

                    if(tdao.checkTable(tId))
                    {
                        tdao.printTicket(tId)
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