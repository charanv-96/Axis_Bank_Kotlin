package Assignments

import java.util.*

fun main()
{
    val read = Scanner(System.`in`)
    println("Enter age")
    var age : Int = read.nextInt()
    println("Enter weight")
    var weight : Int = read.nextInt()
    read.close()
    print(checkEligibility(age, weight))

}

fun checkEligibility(age : Int, weight : Int):Boolean
{
    if(age > 18)
    {
        if (weight > 55)
        {
            return true
        }
        else
        {
            return false
        }
    }
    else
    {
        return false
    }
}
