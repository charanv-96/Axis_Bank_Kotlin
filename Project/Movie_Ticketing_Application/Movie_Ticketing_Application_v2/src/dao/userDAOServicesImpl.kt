package dao

import model.User
import java.sql.ResultSet
import java.sql.Statement

object userDAOServicesImpl : userDAOServices
{
    override fun getUserAge(name : String) : Int
    {
        val sql = "SELECT USER_AGE FROM USERS WHERE USER_NAME = '$name'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        var res : Int = 0

        while (result.next())
        {
            res = result.getInt("USER_AGE")
        }

        return res
    }

    override fun checkUserName(name: String) : Boolean
    {
        val sql = "SELECT * FROM USERS WHERE USER_NAME = '$name'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        if (result.next())
        {
            return true
        }
        else
        {
            return false
        }
    }

    override fun checkPassword(passwd: String) : Boolean
    {
        val sql = "SELECT * FROM USERS WHERE USER_PASSWORD = '$passwd'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        if (result.next())
        {
            return true
        }
        else
        {
            return false
        }
    }

    override fun getUser(name: String) : User? {
        val sql = "SELECT * FROM USERS WHERE USER_NAME = '$name'"
        val conn = getConnection1()
        val statement: Statement = conn!!.createStatement()
        val result: ResultSet = statement.executeQuery(sql)

        var u: User? = null

        while (result.next()) {

            val uid : Int = result.getInt(1)
            val uname : String = result.getString(2)
            val up : String = result.getString(3)
            val uage : Int = result.getInt(4)

            u = User(uname, up, uage, uid)

        }

        return u

        connectionClose(conn)

    }
}