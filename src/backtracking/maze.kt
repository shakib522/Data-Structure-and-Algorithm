package backtracking

// In a 3*3 matrix,how many path are there for reach to the cell 1*1 from cell 3*3 if we just go right or down?

fun main(){
    println(count(3,3))
    printPath("",3,3)
    println(pathReturn("",3,3))
    println(pathReturnDiagonal("",3,3))
    val board= listOf(booleanArrayOf(true,true,true),booleanArrayOf(true,true,true),booleanArrayOf(true,true,true))
    println(pathWithRestrictionReturn("",0,0,board))
//    println(allPathReturn("",3,3))
    println(allPath("",0,0,board))
    val path=MutableList(board.size) { mutableListOf(0,0,0) }
    println()
    allPathPrint("",0,0,board,1,path)
}

fun count(r:Int,c:Int):Int{
    //we start from 3*3 index of the matrix
    if(r==1||c==1){
        return 1
    }
    val down= count(r-1,c)
    val right= count(r,c-1)
    return down+right
}

fun printPath(path:String,r:Int,c:Int){
    //we start from 3*3 index of the matrix
    if(r==1&&c==1){
        println(path)
        return
    }
    if(r>1){
        printPath(path+"D",r-1,c)
    }
    if(c>1){
         printPath(path+"R",r,c-1)
    }
}

fun pathReturn(path:String,r:Int,c:Int):MutableList<String>{
    //we start from 3*3 index of the matrix
    val ans= mutableListOf<String>()
    if(r==1 && c==1){
        ans.add(path)
    }
    if(r>1){
        ans.addAll(pathReturn(path+'D',r-1,c))
    }
    if(c>1){
        ans.addAll(pathReturn(path+'R',r,c-1))
    }
    return ans
}

fun pathReturnDiagonal(path:String,r:Int,c:Int):MutableList<String>{
    val ans= mutableListOf<String>()
    if(r==1 && c==1){
        ans.add(path)
    }
    if(r>1 && c>1){
        ans.addAll(pathReturnDiagonal(path+'D',r-1,c-1))  // d = diagonally v= vertically h= horizontally
    }
    if(r>1){
        ans.addAll(pathReturnDiagonal(path+'V',r-1,c))
    }
    if(c>1){
        ans.addAll(pathReturnDiagonal(path+'H',r,c-1))
    }
    return ans
}

fun pathWithRestrictionReturn(path:String,r:Int,c:Int,maze:List<BooleanArray> ):MutableList<String>{
    //we start from 1*1 index of the matrix
    val ans= mutableListOf<String>()
    if(r== maze.size-1 && c==maze[0].size-1){
        ans.add(path)
    }
    if(!maze[r][c]){
        return ans
    }
    if(r < maze.size-1){
        ans.addAll(pathWithRestrictionReturn(path+'D',r+1,c,maze))
    }
    if(c < maze[0].size-1){
        ans.addAll(pathWithRestrictionReturn(path+'R',r,c+1,maze))
    }
    return ans
}



fun allPath(path:String,r:Int,c:Int,maze:List<BooleanArray> ):MutableList<String>{
    //we start from 1*1 index of the matrix
    val ans= mutableListOf<String>()
    if(r== maze.size-1 && c==maze[0].size-1){
        ans.add(path)
        return ans
    }
    if(!maze[r][c]){
        return ans
    }

    // I am considering this block in my path.That's why I put false in this block
    maze[r][c]=false
    if(r < maze.size-1){
        ans.addAll(allPath(path+'D',r+1,c,maze))
    }
    if(c < maze[0].size-1){
        ans.addAll(allPath(path+'R',r,c+1,maze))
    }
    if(r>0){
        ans.addAll(allPath(path+'U',r-1,c,maze))
    }
    if(c>0){
        ans.addAll(allPath(path+'L',r,c-1,maze))
    }
    //this is where the function will be over
    //so before the function gets removed,also remove/revert the changes that were made by that function.This is called backtracking
    maze[r][c]=true
    return ans
}


fun allPathPrint(p:String,r:Int,c:Int,maze:List<BooleanArray>, step:Int, path:MutableList<MutableList<Int>> ){
    //we start from 1*1 index of the matrix
    if(r== maze.size-1 && c==maze[0].size-1){
        path[r][c]=step
        for (arr in path){
            println(arr)
        }
        println(p)
        println()
        return
    }
    if(!maze[r][c]){
        return
    }

    // I am considering this block in my path.That's why I put false in this block
    maze[r][c]=false
    path[r][c]=step
    if(r < maze.size-1){
        allPathPrint(p+'D',r+1,c,maze,step+1,path)
    }
    if(c < maze[0].size-1){
        allPathPrint(p+'R',r,c+1,maze,step+1,path)
    }
    if(r>0){
        allPathPrint(p+'U',r-1,c,maze,step+1,path)
    }
    if(c>0){
        allPathPrint(p+'L',r,c-1,maze,step+1,path)
    }
    //this is where the function will be over
    //so before the function gets removed,also remove/revert the changes that were made by that function.This is called backtracking
    maze[r][c]=true
    path[r][c]=0
}



fun allPathReturn(path:String,r:Int,c:Int):MutableList<String>{
    //we start from 3*3 index of the matrix
    //do not move back to the same path
    val ans= mutableListOf<String>()
    if(r==1 && c==1){
        ans.add(path)
        return ans
    }
    if(r>1){
        ans.addAll(allPathReturn(path+'D',r-1,c))
    }
    if(c>1){
        ans.addAll(allPathReturn(path+'R',r,c-1))
    }
    if(r<3){
        ans.addAll(allPathReturn(path+'U',r+1,c))
    }
    if(c<3){
        ans.addAll(allPathReturn(path+'L',r,c+1))
    }
    return ans
}