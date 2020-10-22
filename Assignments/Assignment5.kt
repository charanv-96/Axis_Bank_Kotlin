package Assignments

import java.util.*

fun main()

{
    val read = Scanner(System.`in`)
    println("Enter sales revenue")
    var rev : Double = read.nextDouble()
    bonus(rev)

}

fun bonus(rev : Double)
{
    when(rev)
    {
        in 10000.0..20000.0 -> print("Your bonus is  1500")
        in 20001.0..40000.0 -> print("Your bonus is  2500")
        in 40001.0..60000.0 -> print("Your bonus is  3500")
        else -> print("Not eligible for now")
    }
}

