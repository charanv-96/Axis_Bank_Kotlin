package Assignments

import java.util.*

tailrec fun factorial(n: Long, semiResult : Long = 1):Long
{
    return if(n <=0 )
    {
        semiResult
    }
    else
    {
        factorial(n-1, semiResult = n * semiResult)
    }
}

fun main()
{
    val read = Scanner(System.`in`)
    println("Enter the number")
    var num : Long = read.nextLong()

    print(factorial(num))
}


