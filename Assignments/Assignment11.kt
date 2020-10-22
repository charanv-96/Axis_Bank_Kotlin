package Assignments

import java.util.*

sealed class Cars
{
    init
    {
        println("This is a car")
    }

    class Maruti : Cars()
    {
        init
        {
            println("Indian Make")
        }
    }

    class Hyundai : Cars()
    {
        init
        {
            println("Korean Make")
        }
    }

    class Honda : Cars()
    {
        init
        {
            println("Japan Make")
        }
    }
}



fun main()
{
    val read = Scanner(System.`in`)
    println("Enter Car Brand")
    var rev : String = read.next()

    when(rev)
    {
        "Maruti" -> Cars.Maruti()
        "Hyundai" -> Cars.Hyundai()
        "Honda" -> Cars.Honda()
        else -> print("Enter valid brand")
    }

}