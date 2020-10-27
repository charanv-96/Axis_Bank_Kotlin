package controller

import dao.userDAOServicesImpl
import model.User
import service.UserService
import service.UserServiceImpl

class UserController
{

    val userService = UserServiceImpl
    val userDAOServices = userDAOServicesImpl

    fun getUserAge(name : String) : Int
    {
        return userDAOServices.getUserAge(name)
    }

    fun checkUserName(name: String) : Boolean
    {
        return userDAOServices.checkUserName(name)
    }

    fun checkPassword(passwd: String) : Boolean
    {
        return userDAOServices.checkPassword(passwd)
    }

    fun getUser(name: String) : User?
    {
        return userDAOServices.getUser(name)
    }

    fun login() : User?
    {
        return userService.login()
    }

}