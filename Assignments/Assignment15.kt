package Assignments

fun main()
{

    val res1 : Int = Calculator.add(3, 4)
    println(res1)

    val res2 : Int = Calculator.sub(3, 4)
    println(res2)

    val res3 : Double = Calculator.mul(3.0, 4.0)
    println(res3)

    val res4 : Double = Calculator.div(3.0, 4.0)
    println(res4)

}

class Calculator
{

    companion object
    {
        fun add(a : Int, b : Int) : Int
        {
            return a + b
        }

        fun sub(a : Int, b : Int) : Int
        {
            return a - b
        }

        fun mul(a : Double, b : Double) : Double
        {
            return (a * b).toDouble()
        }

        fun div(a : Double, b : Double) : Double
        {
            return (a/b).toDouble()
        }

    }

}