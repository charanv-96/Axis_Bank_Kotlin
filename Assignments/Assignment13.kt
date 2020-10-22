package Assignments

import java.util.*

fun main()
{
    val read = Scanner(System.`in`)
    var str : String? = read.nextLine()

    println(rev(str))

}

fun rev(s : String?) : String
{
    if (s.equals(null))
    {
        return "Empty String"
    }
    else
    {
        return s?.reversed().toString()
    }
}