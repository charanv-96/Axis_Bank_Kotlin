package Assignments

class Account(acctid : Int, Acct_type : String, name : String){

    private var accountId : Int = 0
    private var accountType : String = ""
    private var name : String = ""

    init {
        this.accountId = acctid
        this.accountType = Acct_type
        this.name = name
    }

    fun display()
    {
        println("Account Id is $accountId")
        println("Account Type is $accountType")
        println("Name is $name")
    }


}

fun main()
{
    var c1 = Account(100, "Savings", "Charan")
    c1.display()

    var c2 = Account(101, "Current", "Vallapaneni")
    c2.display()

    var c3 = Account(300, "Savings", "Someone")
    c3.display()

    var c4 = Account(150, "Current", "Nagaraja")
    c4.display()

    var c5 = Account(500, "Savings", "Charan Vallapaneni")
    c5.display()
}