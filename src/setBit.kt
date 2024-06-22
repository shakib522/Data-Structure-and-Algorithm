
fun main() {
    //set bits means number of 1 in a bit
    val n=29
    val binaryString = Integer.toBinaryString(29)
    var cnt=0
    for (i in binaryString){
        if (i=='1'){
            cnt++
        }
    }
    println(binaryString)
    println("Number of set bits: $cnt")
}
