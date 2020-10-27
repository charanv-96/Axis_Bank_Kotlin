package dao

import model.User
import java.sql.ResultSet
import java.sql.Statement

interface userDAOServices
{
    fun getUserAge(name : String) : Int

    fun checkUserName(name: String) : Boolean

    fun checkPassword(passwd: String) : Boolean

    fun getUser(name: String) : User?


}