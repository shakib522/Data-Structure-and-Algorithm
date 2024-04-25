package backtracking


fun main() {
    val board= MutableList(5){ mutableListOf(false,false,false,false,false) }
    println( knight(board,0,0,4))
}

fun knight(board:MutableList<MutableList<Boolean>>,row:Int,col:Int,knights:Int){
    if(knights==0){
        displayKnight(board)
        println()
        return
    }

    if(row==board.size-1 && col == board.size){
        return
    }

    if(col==board.size){
        knight(board,row+1,0,knights)
        return
    }

    if(knightSafe(board,row,col)){
        board[row][col]=true
        knight(board,row,col+1,knights-1)
        board[row][col]=false
    }

    knight(board,row,col+1,knights)

}

fun isValid(board:MutableList<MutableList<Boolean>>,row:Int,col:Int):Boolean{
    return row>=0 && row< board.size && col>=0 && col < board.size
}

fun knightSafe(board:MutableList<MutableList<Boolean>>,row:Int,col:Int):Boolean{

    if(isValid(board,row-2,col-1)){
        if(board[row-2][col-1]){
            return false
        }
    }
    if(isValid(board,row-1,col-2)){
        if(board[row-1][col-2]){
            return false
        }
    }

    if(isValid(board,row-2,col+1)){
        if(board[row-2][col+1]){
            return false
        }
    }

    if(isValid(board,row-1,col+2)){
        if(board[row-1][col+2]){
            return false
        }
    }

    return true
}

fun displayKnight(board:MutableList<MutableList<Boolean>>){
    for (row in board){
        for (element in row){
            if (element){
                print("K ")
            }else{
                print("X ")
            }
        }
        println()
    }
}