package strings

fun main(){
    dice("",7)
    println(diceReturn("",7))
    println(diceFaceReturn("",4,6))
}

fun dice(processed:String,target:Int){
    if(target==0){
        println(processed)
        return
    }
    for (i in 1..6){
        if(i>target){
            break
        }
        dice(processed+i,target-i)
    }
}

fun diceReturn(processed:String,target:Int):MutableList<String>{
    val ans= mutableListOf<String>()
    if(target==0){
        ans.add(processed)
        return ans
    }
    var i=1
    while(i<=6 && i<=target){
        ans.addAll(diceReturn(processed+i,target-i))
        i++
    }
    return ans
}

fun diceFaceReturn(processed:String,target:Int,face:Int):MutableList<String>{
    val ans= mutableListOf<String>()
    if(target==0){
        ans.add(processed)
        return ans
    }
    for (i in 1..face){
        if(i>target){
            break
        }
        ans.addAll(diceFaceReturn(processed+i,target-i,face))
    }
    return ans
}