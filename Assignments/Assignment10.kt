package Assignments

class Account1{

    private var accountId : Int = 0
    private var accountType : String = ""
    private var accountName : String = ""

    constructor(acctid : Int, Acct_type : String, name : String)
    {
        accountId = acctid
        accountType = Acct_type
        accountName = name
    }

    fun display()
    {
        println("Account Id is $accountId")
        println("Account Type is $accountType")
        println("Name is $accountName")
    }


}

fun main()
{

    var c1 = Account1(100, "Savings", "Charan")
    c1.display()

    var c2 = Account1(101, "Current", "Vallapaneni")
    c2.display()

    var c3 = Account1(300, "Savings", "Someone")
    c3.display()

    var c4 = Account1(150, "Current", "Nagaraja")
    c4.display()

    var c5 = Account1(500, "Savings", "Charan Vallapaneni")
    c5.display()

}