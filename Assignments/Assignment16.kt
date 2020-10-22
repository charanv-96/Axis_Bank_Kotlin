package Assignments

fun main()
{
    val stringList:ArrayList<String> = arrayListOf<String>("Banana", "Grapes","Mango")
    val mixedList:ArrayList<String> = arrayListOf<String>("Hello","Welcome","34","56","78","Hi")
    val intList:ArrayList<Int> = arrayListOf<Int>(12,45,56)

    stringList.printList()
    intList.printList()
    mixedList.printList()
}

fun <T>ArrayList<T>.printList()
{
    for(element in this)
    {
        println(element)
    }
}
