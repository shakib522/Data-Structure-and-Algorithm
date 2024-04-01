package sorting

fun main(){
    var arr= intArrayOf(5,4,3,2,6,8,10,11)
    mergeSortInPlace(arr,0,arr.size)
    arr.forEach {
        print("$it ")
    }
}

fun mergeSort(arr:IntArray):IntArray{
    if (arr.size==1){
        return arr
    }
    val mid=arr.size/2
    val left= mergeSort(arr.copyOfRange(0,mid)) //creating new object in every function call
    val right= mergeSort(arr.copyOfRange(mid,arr.size)) //creating new object in every function call.original array is not modified
    return merge(left,right)
}
fun merge(first:IntArray,second:IntArray):IntArray{
    val mergeArray=IntArray(first.size+second.size)
    var pointer1=0
    var pointer2=0
    var pointer3=0
    while (pointer1<first.size && pointer2<second.size){
        if (first[pointer1]<second[pointer2]){
            mergeArray[pointer3]=first[pointer1]
            pointer1++
        }else{
            mergeArray[pointer3]=second[pointer2]
            pointer2++
        }
        pointer3++
    }
    //it is possible that one of the array is not complete.Then copy the remaining element
    while (pointer1<first.size){
        mergeArray[pointer3]=first[pointer1]
        pointer1++
        pointer3++
    }
    while (pointer2<second.size){
        mergeArray[pointer3]=first[pointer2]
        pointer2++
        pointer3++
    }
    return mergeArray
}

fun mergeSortInPlace(arr:IntArray,s:Int,e:Int){
    if (e-s==1){
        return
    }
    val mid=(s+e)/2
    mergeSortInPlace(arr,s,mid)
    mergeSortInPlace(arr,mid,e)
    mergeInPlace(arr,s,mid,e)
}


fun mergeInPlace(array:IntArray,start:Int,mid:Int,end:Int){
    val mergeArray=IntArray(end-start)
    var i=start
    var j=mid
    var k=0
    while (i<mid && j<end){
        if (array[i]<array[j]){
            mergeArray[k]=array[i]
            i++
        }else{
            mergeArray[k]=array[j]
            j++
        }
        k++
    }
    //it is possible that one of the array is not complete.Then copy the remaining element
    while (i<mid){
        mergeArray[k]=array[i]
        i++
        k++
    }
    while (j<end){
        mergeArray[k]=array[j]
        j++
        k++
    }
    for (l in mergeArray.indices){
        array[start+l]= mergeArray[l]
    }
}