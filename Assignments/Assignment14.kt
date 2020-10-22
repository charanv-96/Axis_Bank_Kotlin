package Assignments

class Student
{

    private var rollNo : Int= 0
    private var studentName : String = ""
    private var city : String = ""

    constructor(rollNo: Int, studentName: String, city: String) {
        this.rollNo = rollNo
        this.studentName = studentName
        this.city = city
    }

    public fun getRollNo() : Int
    {
        return this.rollNo
    }

    public fun getStudentName() : String
    {
        return this.studentName
    }

    public fun getCity() : String
    {
        return this.city
    }


}

fun main()
{
    val myMap=mapOf<Int,Student>(1 to Student(100, "John", "Bangalore"),
        2 to Student(101, "Peter", "Chennai"),
        3 to Student(102, "Marks", "Mumbai"),
        4 to Student(103, "Ravi", "Bangalore"),
        5 to Student(104, "Meera", "Mumbai"),
        6 to Student(105, "Usha", "Chennai"),
        7 to Student(106, "Rekha", "Chennai"),
        8 to Student(107, "Sunil", "Bangalore"),
        9 to Student(108, "Tara", "Chennai"),
        10 to Student(109, "Sun", "Mumbai"),
        11 to Student(110, "Ramu", "Bangalore"))

    for (i in myMap)
    {
        if (i.value.getCity().equals("Bangalore"))
        {
            println("${i.value.getRollNo()} ${i.value.getStudentName()} ${i.value.getCity()}")
        }
        else
        {
            continue
        }
    }
}