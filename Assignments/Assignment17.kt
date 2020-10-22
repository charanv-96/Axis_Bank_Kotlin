package Assignments

fun main()
{

    val myMap1: HashMap<Int, String> = HashMap<Int, String>()
    myMap1.put(1, "Ravi")
    myMap1.put(4, "Ravi")
    myMap1.put(2, "Raju")
    myMap1.put(3, "Ramu")
    myMap1.put(6, "Ramu")
    myMap1.put(5, "Ramu")
    myMap1.put(100, "Ramu")
    myMap1.put(50, "Ramu")

    val list1 : List<Any> = convToList(myMap1)

    for (i in list1)
    {
        println(i)
    }
}

fun convToList(myMap1: HashMap<Int, String>): List<Any> {

    return myMap1.toList()

}
