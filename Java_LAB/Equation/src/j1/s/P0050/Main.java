package j1.s.P0050;

public class Main {
    public static void menu(){
        System.out.println("======Equation Program========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit\n");
        System.out.println("Please choose one option");
    }
    
    public static void main(String[] args) {
        NumberMng nm = new NumberMng();
        MyUtils utl = new MyUtils();
        int choice;
        do {
            menu();
            choice = utl.choiceUsing(3, "Your choice: ", "Over-numbering!", "Invalid input");
            switch(choice){
                case 1:
                    nm.inputNumberA_B();
                    nm.calSuperlativeEqualation();
                    nm.displayOdd_Even_Square();
                    nm.list.clear();
                    break;
                    
                case 2:
                    nm.inputNumberA_B_C();
                    nm.calQuadraticEquation();
                    nm.displayOdd_Even_Square();
                    nm.list.clear();
                    break;
            }       
        } while (choice != 3);    
    }
}
