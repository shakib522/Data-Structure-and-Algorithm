import java.util.Hashtable


fun main() {
    val table: Hashtable<String, String> = Hashtable(10)
    //load factor 0.75 means if our hashtable capacity is 75% full, the size is increase dynamically
    table["001"] = "shakib"
    table["1122"]="sojib"
    table["224"]="aayham"
    table["446"]="hasan"
    for (key in table.keys){
        println("hashcode: ${key.hashCode()} key: $key ${table[key]}")
    }
    println(table)
}