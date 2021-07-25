package j1.s.p0074;

public class Matrix {
    
    MyUtils utl = new MyUtils();

    int[][] inputMatix(int count) {
        int row = utl.getInt("Enter row matrix: ", "Must be greater than 0", "Number format only");
        int column = utl.getInt("Enter column matrix: ", "Must be greater than 0", "Number format only");
        int[][] a = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("Enter Matrix: " + count + " [" + i + "] " + " [" + j + "] : ");
                a[i][j] = utl.getElmt();
            }
        }
        return a;
    }

    void addition() {
        int[][] sub1 = inputMatix(1);
        int[][] sub2 = inputMatix(2);
        int rowSub1 = sub1.length;
        int columnSub1 = sub1[0].length;
        int rowSub2 = sub2.length;
        int columnSub2 = sub2[0].length;
        if (rowSub1 != rowSub2 || columnSub1 != columnSub2) {
            System.out.println("They cannot be added");
            return;
        }
        displayMatrix(sub1);
        System.out.println(" + ");
        displayMatrix(sub2);
        System.out.println(" = ");
        for (int i = 0; i < rowSub1; i++) {
            for (int j = 0; j < columnSub1; j++) {
                System.out.print("[" + (sub1[i][j] + sub2[i][j]) + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void substraction() {
        int[][] sub1 = inputMatix(1);
        int[][] sub2 = inputMatix(2);
        int rowSub1 = sub1.length;
        int columnSub1 = sub1[0].length;
        int rowSub2 = sub2.length;
        int columnSub2 = sub2[0].length;
        if (rowSub1 != rowSub2 || columnSub1 != columnSub2) {
            System.out.println("They cannot be substracted");
            return;
        }
        displayMatrix(sub1);
        System.out.println(" - ");
        displayMatrix(sub2);
        System.out.println(" = ");
        int row = sub1.length;
        int column = sub1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + (sub1[i][j] - sub2[i][j]) + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void multiplication() {
        int[][] sub1 = inputMatix(1);
        int[][] sub2 = inputMatix(2);
        {
            displayMatrix(sub1);
            System.out.println(" * ");
            displayMatrix(sub2);
            System.out.println(" = ");
            int rowSub1 = sub1.length;
            int columnSub1 = sub1[0].length;
            int rowSub2 = sub2.length;
            int columnSub2 = sub2[0].length;
            if (columnSub1 != rowSub2) {
                System.out.println("They cannot be multiplied");
                return;
            }
            int[][] result = new int[rowSub1][columnSub2];
            for (int i = 0; i < rowSub1; i++) {
                for (int j = 0; j < columnSub2; j++) {
                    result[i][j] = 0;
                }
            }
            for (int i = 0; i < rowSub1; i++) {
                for (int j = 0; j < columnSub2; j++) {
                    for (int x = 0; x < columnSub1; x++) {
                        result[i][j] += sub1[i][x] * sub2[x][j];
                    }
                }
                System.out.println("");
            }
            System.out.println("");
            displayMatrix(result);
        }
    }

    void displayMatrix(int[][] a) {
        int row = a.length;
        int column = a[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }    
}
