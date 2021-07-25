package j1.s.p0011;

public class Main {
    static MyUtils utl = new MyUtils();
    
    public static void choiceMenu(){
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
    }
    
    public static void main(String[] args) {
        NumberManager n = new NumberManager();
        int choice;
        do {
            choiceMenu();         
            choice = utl.choiceUsing(4, "Enter your choice: ", "Please input 1-4!", "Please input number");
            switch (choice) {
                case 1:
                    String binary = utl.checkInputBinary();
                    n.convertFromBinary(binary);
                    break;
                case 2:
                    String decimal = utl.checkInputDecimal();
                    n.convertFromDecimal(decimal);
                    break;
                case 3:
                    String hexa = utl.checkInputHexaDecimal();
                    n.convertFromHexa(hexa);
                    break;
                case 4:
                    System.out.println("Good bye!");
                    break;
            }
        } while (choice != 4);
    }
}
