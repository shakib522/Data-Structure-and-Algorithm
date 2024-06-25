package sorting

// sorting a list of people where everyone has an id,name,cgpa.Sort the list based on cgpa descending,name ascending and id descending

class Student(val id:Int,val name:String,val CGPA:Double)
fun main() {
    val studentList = ArrayList<Student>()
    studentList.add(Student(110,"shakib",3.20))
    studentList.add(Student(12,"aman",3.53))
    studentList.add(Student(13,"hasan",3.53))
    studentList.add(Student(112,"anonna",3.20))
    studentList.add(Student(1,"chifat",3.30))
    studentList.add(Student(111,"daiyan",3.20))
    studentList.add(Student(112,"ether",3.20))
    customMergeSort(studentList,0,studentList.size)
    studentList.forEach{
        println("CGPA: ${it.CGPA} Name: ${it.name} ID: ${it.id}")
    }
}

fun customMergeSort(arrayList:ArrayList<Student>,start:Int,end:Int){
    if (end-start==1){
        return
    }
    val mid=(end+start)/2
    customMergeSort(arrayList,start,mid)
    customMergeSort(arrayList,mid,end)
    customMering(arrayList,start,mid,end)
}
fun customMering(ara:ArrayList<Student>,start: Int,mid:Int,end: Int){
    val mergeList=ArrayList<Student>(end-start)
    var i=start
    var j=mid
    while (i<mid && j<end){
        if (ara[i].CGPA> ara[j].CGPA){
            mergeList.add(ara[i])
            i++
        }else if(ara[i].CGPA < ara[j].CGPA){
            mergeList.add(ara[j])
            j++
        }else{
            if (ara[i].name < ara[j].name){
                mergeList.add(ara[i])
                i++
            }else if (ara[i].name > ara[j].name){
                mergeList.add(ara[j])
                j++
            }else{
                if (ara[i].id > ara[j].id){
                    mergeList.add(ara[i])
                    i++
                }else{
                    mergeList.add(ara[j])
                    j++
                }
            }
        }
    }
    while (i<mid){
        mergeList.add(ara[i])
        i++
    }
    while (j<end){
        mergeList.add(ara[j])
        j++
    }
    for (it in mergeList.indices){
        ara[start+it]=mergeList[it]
    }
}

