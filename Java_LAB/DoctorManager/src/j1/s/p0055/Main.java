package j1.s.p0055;

import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("");
        System.out.println("============ Doctor Managing ============");
        System.out.println("\t1. Add Doctor");
        System.out.println("\t2. Update Doctor");
        System.out.println("\t3. Delete Doctor");
        System.out.println("\t4. Search Doctor");
        System.out.println("\t5. Display");
        System.out.println("\t6. Exit");
    }
    static MyUtils utl = new MyUtils();
    public static void main(String[] args) {
        DoctorManager docm = new DoctorManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            menu();
            choice = utl.choiceUsing(6, "Input your choice: "
                    , "Please input 1 to 6!", "Please input number!");
            switch(choice){
                case 1:
                    //add doctor
                    docm.addDoctor();
                    break;
                case 2:
                    //update doctor
                    docm.updateDoctor();
                    break;
                case 3:
                    //delete doctor
                    docm.deleteDoctor();
                    break;
                case 4:
                    //search doctor
                    docm.searchDoctor();
                    break;
                case 5: //sử dụng để dễ kiểm tra
                    //display
                    docm.displayDoctor();
                    break;
                case 6:
                    docm.displayDoctor();
                    System.out.println("Good bye - See you soon!");
                    break;
            }
        } while (choice != 6);

    }
}

