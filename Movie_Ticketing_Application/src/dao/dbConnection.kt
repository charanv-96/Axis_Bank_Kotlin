package dao

import java.sql.*
import java.util.*


fun getConnection1(): Connection? {
    var conn: Connection? = null
    var username = "root" // provide the username
    var password = "Charanv@96" // provide the corresponding password
    val connectionProps = Properties()
    connectionProps.put("user", username)
    connectionProps.put("password", password)
    try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" + "localhost:3306/movie_db",
                connectionProps)
    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }
    return conn
}
fun connectionClose(conn : Connection?)
{
    conn?.close()
}
