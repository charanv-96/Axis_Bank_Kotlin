package service

import controller.UserController
import dao.userDAOServices
import dao.userDAOServicesImpl
import model.User
import java.util.*

object UserServiceImpl : UserService
{
    override fun login() : User?
    {

        var u : User? = null
        var flag : Boolean = false
        val userController = UserController()

        println("Enter User Name")
        val read1 = Scanner(System.`in`)
        var name : String = read1.nextLine()

        if(userController.checkUserName(name))
        {
            println("Enter Password")
            val read2 = Scanner(System.`in`)
            var passwd : String = read2.nextLine()

            if (userController.checkPassword(passwd))
            {
                u = userController.getUser(name)
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
}