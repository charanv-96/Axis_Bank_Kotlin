package controller

import dao.ticketDAOServicesImpl
import service.TicketService
import service.TicketServiceImpl

class TicketController
{

    val ticketService = TicketServiceImpl
    val ticketDAOServices = ticketDAOServicesImpl

    fun insertTicket(USER_ID: Int, MOVIE_ID: Int, NO_OF_TICKETS: Int, COST: Double):Boolean
    {
        return ticketDAOServices.insertTicket(USER_ID, MOVIE_ID, NO_OF_TICKETS, COST)
    }

    fun checkTable(tId : Int) : Boolean
    {
        return ticketDAOServices.checkTable(tId)
    }

    fun deleteTicket(tId: Int)
    {
        ticketDAOServices.deleteTicket(tId)
    }

    fun viewTicket(tId: Int)
    {
        ticketDAOServices.viewTicket(tId)
    }

    fun printTicket(tId : Int)
    {
        ticketDAOServices.printTicket(tId)
    }

}