package sorting

fun main(){
    val array= intArrayOf(5,4,3,2,1)
    array.sort()//hybrid algorithm(use dual pivot quick sort,insertion sort,heap sort)
    quickSort(array,0,array.size-1)
    array.forEach{
        print("$it ")
    }

}

fun quickSort(num:IntArray,low:Int,high:Int){
    if(low>=high){
        return
    }
    var s=low
    var e=high
    val m = s+(e-s)/2
    val pivot=num[m]
    while (s<=e){
        //also a reason why if its already sorted it will not swap
        while (num[s]<pivot){
            s++
        }
        while (num[e]>pivot){
            e--
        }
        if(s<=e){
//            num[s]=num[s].xor(num[e])
//            num[e]=num[s].xor(num[e])
//            num[s]=num[s].xor(num[e])
//            num[s]=num[s]+num[e]
//            num[e]=num[s]-num[e]
//            num[s]=num[s]-num[e]
            val temp=num[s]
            num[s]=num[e]
            num[e]=temp
            s++
            e--
        }
    }
    quickSort(num,low,e)
    quickSort(num,s,high)
}