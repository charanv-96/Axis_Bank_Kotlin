package Assignments

fun main()
{
    var arr = arrayOf(10, "Hey", 30)
    println(searchElement(35,arr))

}

fun searchElement(elem: Any, arr: Array<out Any>):Boolean
{
    var flag : Int = 0
    for (e in arr)
    {
        if (e.equals(elem))
        {
            flag = 1
        }
        else
        {
            continue
        }
    }

    if (flag == 0)
    {
        return false
    }
    else
    {
        return true
    }
}