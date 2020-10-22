package model

import java.util.*

class Ticket
{

    private var movie : Movie = Movie(1,"")
    private var user : User = User("1","", 1,1)

    fun calcTicketCost(user: User, noOFTickets : Int) : Double
    {
        this.user = user
        return (noOFTickets * 150).toDouble()

    }

    fun display(ticketCost : Double)
    {
        println("User id :${user.getUserId()} \nUser Name : ${user.getUserName()} \nUser Age : ${user.getUserAge()} \n" +
                "Ticket Cost : $ticketCost \n")
    }

}