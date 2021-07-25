package j1.s.p0074;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix();
        int choice;
        Menu mn = new Menu("=======Calculator program======");
        mn.addNewOption("1. Addition Matrix");
        mn.addNewOption("2. Substraction Matrix");
        mn.addNewOption("3. Multiplication Matrix");
        mn.addNewOption("4. Quit");
        do {
            mn.printMenu();
            choice = mn.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("-------- Addition--------");
                    m.addition();
                    break;
                case 2:
                    m.substraction();
                    break;
                case 3:
                    m.multiplication();
                    break;
            }
        } while (choice != 4);
    }   
}
