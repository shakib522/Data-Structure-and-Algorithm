package recursion;

public class Triangle1 {
    public static void main(String[] args) {
        printTriangle(4,0);
        printNormalTriangle(4,0);
    }
    static void printTriangle(int row,int col){
        if (row==0){
            return;
        }

        if (row>col) {
            System.out.print("* ");
            printTriangle(row, col + 1);
        }else{
            System.out.println();
            printTriangle(row-1,0);
        }
    }

    static void printNormalTriangle(int row,int col){
        if (row==0){
            return;
        }
        if (row>col) {
            printNormalTriangle(row, col + 1);
            System.out.print("* ");
        }else{
            printNormalTriangle(row-1,0);
            System.out.println();
        }
    }
}
