package dao


import java.sql.Connection
import java.sql.SQLException

fun main()
{

    var conn : Connection? = null
    try {

        conn = getConnection1()

        val stmt1 = conn!!.createStatement()

        val stmt = conn!!.createStatement()
        var resultset = stmt!!.execute("use movie_db;")
        var resultset1 = stmt!!.execute("drop table TICKETS;")
        var resultset2 = stmt!!.execute("drop table MOVIES;")
        var resultset3 = stmt!!.execute("drop table USERS;")

        var b1=stmt1!!.execute("create table TICKETS (\n" +
                "TICKET_ID  INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "USER_ID VARCHAR(40) ,\n" +
                "MOVIE_ID INT,\n" +
                "NO_OF_TICKETS INT,\n" +
                "COST DOUBLE\n" +
                ");")

        val stmt2 = conn!!.createStatement()
        //resultset = stmt!!.execute("create database sampledb1;")
        var b2=stmt2!!.execute("create table MOVIES (\n" +
                "MOVIE_ID INT PRIMARY KEY,\n" +
                "MOVIE_NAME VARCHAR(40),\n" +
                "RATING VARCHAR(40),\n" +
                "AVAILABLE_NO_OF_TICKETS INT\n" +
                ");")

        val stmt3 = conn!!.createStatement()
        //resultset = stmt!!.execute("create database sampledb1;")
        var b3=stmt3!!.execute("create table USERS (\n" +
                "USER_ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "USER_NAME VARCHAR(40),\n" +
                "USER_PASSWORD VARCHAR(40),\n" +
                "USER_AGE INT\n" +
                ");")

        connectionClose(conn)

    } catch (ex: SQLException) {
        // handle any errors
        ex.printStackTrace()
    } catch (ex: Exception) {
        // handle any errors
        ex.printStackTrace()
    }finally {

        if (conn != null) {
            try {
                conn!!.close()
            } catch (sqlEx: SQLException) {
            }
            conn = null
        }
}

}
