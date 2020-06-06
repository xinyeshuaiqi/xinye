package pers.wmx.springbootfreemarkerdemo.kotlin


fun main(args:Array<String>){
    // ---string---
    var str1 = "xinye"
    var str2 = 666

    var str = "str1 = $str1, str2 = $str2"
    println(str)

    // ---list---
    var mylist:List<Int> = arrayListOf(1, 2, 3)
    println("mylist.get(1) =  ${mylist[1]}")

    // ---map---
    var mymap:Map<String, Int> = mapOf("xinye" to 10, "shuaiqi" to 20)
    println("mymap.get(xinye) =  ${mymap["xinye"]}");
}
