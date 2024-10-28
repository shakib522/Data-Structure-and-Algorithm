package cryptography

import java.util.*
import kotlin.math.pow

fun main() {
    val scanner= Scanner(System.`in`)
    println("Enter value of n: ")
    val n=scanner.nextInt()
    val coPrime= mutableSetOf<Int>()
    var tmp: MutableSet<Int>
    val primitiveRoots= mutableListOf<Int>()
    for (i in 1..< n){
        if (gcd(i,n)==1){
            coPrime.add(i)
        }
    }
    for (i in 2..<n){
        tmp=coPrime
        for (j in 1..<n){
            val power= i.toDouble().pow(j.toDouble()) %n
            if (tmp.contains(power.toInt())){
                tmp.remove(power.toInt())
            }
        }
        if (tmp.isEmpty()){
            primitiveRoots.add(i)
        }
    }
    println("primitive roots of n: ")
    primitiveRoots.forEach{
        print("$it ")
    }
    println()
}

fun gcd(a:Int,b:Int):Int{
    if (b==0){
        return a
    }
    return gcd(b,a%b)
}