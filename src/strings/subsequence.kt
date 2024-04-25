package strings

fun main(){
    //subSequence("","abc")
//    subSequence("","abc", arrayListOf()).forEach{
//        println(it)
//    }

    println(subSequenceRet("","abc"))
    val ans=subSequenceIterative(intArrayOf(1,2,2))
    println("with duplicate")
    println(ans)
    println("Without duplicate")
    println(subSequenceIterativeWithoutDuplicate(intArrayOf(1,2,2)))
    println(subSequenceIterativeWithoutDuplicate(intArrayOf(1,2,3)))
}

fun subSequence(p:String,up:String){
    if (up.isEmpty()){
        println(p)
        return
    }
    subSequence(p+up[0],up.substring(1))
    subSequence(p,up.substring(1))
}

fun subSequence(p:String,up:String,ans:ArrayList<String>):ArrayList<String>{
    if (up.isEmpty()){
        ans.add(p)
        return ans
    }
    subSequence(p+up[0],up.substring(1), ans)
    subSequence(p,up.substring(1),ans)
    return ans
}
fun subSequenceRet(p:String,up:String):ArrayList<String>{
    if(up.isEmpty()){
        val ans= arrayListOf(p)
        return ans
    }
    val left= subSequenceRet(p+up[0],up.substring(1))
    val right= subSequenceRet(p,up.substring(1))
    left.addAll(right)
    return left
}


fun subSequenceIterative(arr:IntArray):List<List<Int>>{
    //time complexity -> O(N*N^2)
    //auxiliary space complexity -> O (2^N*N)

    val outer= mutableListOf<MutableList<Int>>()
    outer.add(mutableListOf())
    for (element in arr){
        val n=outer.size
        for (i in 0..<n){
            val internal = outer[i].toMutableList() //return a new mutable list fill with the element of outer[i]
//            internal.addAll(outer[i]) //this is also correct
            internal.add(element)
            outer.add(internal)
        }
    }
    return outer
}

fun subSequenceIterativeWithoutDuplicate(arr:IntArray):List<List<Int>>{
    //time complexity -> O(N*N^2)
    //auxiliary space complexity -> O (2^N*N)
    arr.sort()
    val outer= mutableListOf<MutableList<Int>>()
    outer.add(mutableListOf())
    var start=0
    var end=0
    for (j in arr.indices){
        start=0
        if(j>0 && arr[j]==arr[j-1]){
            start=end+1
        }
        end=outer.size-1
        val n=outer.size
        for (i in start..<n){
            val internal = outer[i].toMutableList() //return a new mutable list fill with the element of outer[i]
//            internal.addAll(outer[i]) //this is also correct
            internal.add(arr[j])
            outer.add(internal)
        }
    }
    return outer
}
