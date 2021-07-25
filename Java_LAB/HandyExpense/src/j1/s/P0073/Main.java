package j1.s.P0073;

public class Main {
    static MyUtils utl = new MyUtils();
    public static void menuChoice(){
        System.out.println("========Handy Expense program======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expense");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }
    public static void main(String[] args) {
        HandyExpense he = new HandyExpense();
        int choice;
        do {
            menuChoice();
            choice = utl.choiceUsing(4, "Your choice: ", "Please choose 1 - 4"
                    , "Just number only!");
            switch(choice){
                case 1:
                    he.addExpense();
                    break;
                case 2:
                    he.display();
                    break;
                case 3:
                    he.deleteExpense();
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
            }
        } while (choice != 4);
    }
}
