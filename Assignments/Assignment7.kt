package Assignments

fun simpleInterest(p: Double, t: Double, r: Double, myLambda1: (Double, Double, Double) -> Unit)
{

    return myLambda1(p,t,r)

}


fun main()
{

    val myLambda1 = {p : Double, t : Double, r : Double -> print((p*r*t) /100)}
    simpleInterest(10.0,12.0,3.0, myLambda1)

}