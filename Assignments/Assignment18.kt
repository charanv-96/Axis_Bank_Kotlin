package Assignments

fun main()
{

    var list1 : ArrayList<Any> = arrayListOf<Any>(1, 2, 3, 4)
    var list2 : ArrayList<Any> = arrayListOf<Any>(5, 6, 7, 8)

    var list3 : ArrayList<Any> = joinLists(list1, list2)

    for (i in list3)
    {
        println(i)
    }


}

fun joinLists(list1 : ArrayList<Any>, list2 : ArrayList<Any>): ArrayList<Any>
{
    var joinedList : ArrayList<Any> = ArrayList()

    joinedList.addAll(list1)
    joinedList.addAll(list2)

    return joinedList

}
