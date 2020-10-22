package Assignments

fun MutableMap<String, Double>.simpInt() : Double
{

    return (this["Amount"]!! * this["Rate"]!! * this["Time"]!!)/100

}


fun main(args:Array<String>)
{

    val myMap3 : HashMap<String, Double> = hashMapOf("Amount" to 1200.00, "Rate" to 11.0 , "Time" to 12.0)
    var res : Double = myMap3.simpInt()

    println(res)

}