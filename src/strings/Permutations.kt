package strings

fun main(){
    permutation("","abc")
    println( permutationReturn("","abc"))
    println(permutationCount("","abc")) // permutation count is 3!
    println(permutationCount("","abcd")) //the permutation count should be length! (4!)
}
//complexity O(n!)
fun permutation(processed: String, unprocessed: String) {
    if(unprocessed.isEmpty()){
        println(processed)
        return
    }
    val ch=unprocessed[0]
    for (i in 0..processed.length){
        val f=processed.substring(0,i)
        val s=processed.substring(i,processed.length)
        permutation(f+ch+s,unprocessed.substring(1))
    }
}
fun permutationReturn(p: String, up: String) :MutableList<String>{
    val ans= mutableListOf<String>()
    if(up.isEmpty()){
        ans.add(p)
        return ans
    }
    val ch=up[0]
    for (i in 0..p.length){
        val f=p.substring(0,i)
        val s=p.substring(i,p.length)
        ans.addAll(permutationReturn(f+ch+s,up.substring(1)))

    }
    return ans
}

fun permutationCount(p: String, up: String):Int {
    var count=0
    if(up.isEmpty()){
        return 1
    }
    val ch=up[0]
    for (i in 0..p.length){
        val f=p.substring(0,i)
        val s=p.substring(i,p.length)
        count+=permutationCount(f+ch+s,up.substring(1))
    }
    return count
}