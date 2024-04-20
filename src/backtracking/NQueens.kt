package backtracking

import kotlin.math.min

fun main(){
    val board= MutableList(5){ mutableListOf(false,false,false,false,false) }
    println( queens(board,0))
}

fun queens(board:MutableList<MutableList<Boolean>>,row:Int):Int{
    if (row==board.size){
        display(board)
        println()
        return 1
    }
    var count=0
    //placing the queen and checking for every row and column
    for (col in 0..<board.size){
        //place the queen if it is safe
        if (isSafe(board,row,col)){
            board[row][col]=true
            count+= queens(board,row+1)
            board[row][col] = false
        }
    }
    return count
}

fun isSafe(board: MutableList<MutableList<Boolean>>, row: Int, col: Int): Boolean {
    //check vertical row
    for (i in 0..<row){
         if (board[i][col]){
             return false
         }
    }
    //diagonal left
    val maxLeft = min(row,col)
    for (i in 1..maxLeft){
        if(board[row-i][col-i]){
            return false
        }
    }
    //diagonal right
    val maxRight= min(row,board.size-col-1)
    for (i in 1 .. maxRight){
        if(board[row-i][col+i]){
            return false
        }
    }
    return true
}

fun display(board:MutableList<MutableList<Boolean>>){
    for (row in board){
        for (element in row){
            if (element){
                print("Q ")
            }else{
                print("X ")
            }
        }
        println()
    }
}