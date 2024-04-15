package strings

fun main(){
    println(skip("","bbbaaccdaasss"))
    println(skipApple("bacapplecdah"))

}

fun skip(processed:String,unProcessed:String)
:String{
    if(unProcessed.isEmpty()){
        return processed
    }
    val ch=unProcessed[0]
   if(ch=='a'){
        return skip(processed,unProcessed.substring(1))
    }else{
        return skip(processed+ch,unProcessed.substring(1))
    }
}
fun skipApple(str:String):String{
    if (str.isEmpty()){
        return ""
    }
    if(str.startsWith("apple")){
        return skipApple(str.substring(5))
    }else{
        return str[0]+skipApple(str.substring(1))
    }
}