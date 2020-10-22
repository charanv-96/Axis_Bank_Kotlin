package Assignments

fun main()
{
    var str : String ="Hello"
    println(countVowels(str))

}

fun countVowels(s:String):Int
{
    var c : Int = 0
    for (i in 0..s.length-1)
    {
        when(s[i].toLowerCase())
        {
            'a','e','i','o','u' -> c++
        }
    }
    return c
}