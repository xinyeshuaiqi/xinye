package pers.wmx.springbootfreemarkerdemo.kotlin

class User(var userId:Long,
           var userName:String,
           var userSex:Int = 0, //默认值
           var avatar:String?)  //允许为空

fun main(args:Array<String>){
    var user = User(userId = 123, userName = "xinye", avatar = null)
    user.userName = "wmx"
    user.userSex = 1

    //是不是很爽，和Java相比，代码量减少很多
    println("userId = ${user.userId}, userName = ${user.userName}, " +
            "userSex = ${user.userSex}, avatar = ${user.avatar?:"noAvatar"}")

    println(user.toString())

 }
