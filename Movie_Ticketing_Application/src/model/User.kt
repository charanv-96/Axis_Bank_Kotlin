package model

class User(user_name : String,user_passwd: String, user_age : Int, userId : Int)
{

    private var userName : String = ""
    private var userPassword : String = "0"
    private var userAge : Int = 0
    private var userId : Int = 0

    init
    {
        this.userName = user_name
        this.userPassword = user_passwd
        this.userAge = user_age
        this.userId = userId
    }

    public fun getUserPassword() : String
    {
        return this.userPassword
    }

    public fun getUserName() : String
    {
        return this.userName
    }

    public fun getUserAge() : Int
    {
        return this.userAge
    }

    public fun getUserId() : Int
    {
        return this.userId
    }

    public fun setUserId(userId: Int)
    {
        this.userId = userId
    }

    public fun setUserAge(age : Int)
    {
        this.userAge = age
    }

    public fun setUserName(name : String)
    {
        this.userName = name
    }

    public fun setUserPassword(passwd : String)
    {
        this.userPassword = passwd
    }

}
