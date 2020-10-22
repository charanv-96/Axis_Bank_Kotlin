package Assignments

fun main()
{

    var arrL : ArrayList<Any> = arrayListOf(1, 2, "CV", 34.5)

    var arr : Array<Any> = convArr(arrL)

    for (i in arr)
    {
        println(i)
    }

}

fun convArr(arrList : ArrayList<Any>) : Array<Any>
{
    var arr : Array<Any> = arrayOf(arrList)

    return arr

}

