package j1.s.p0074;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("Menu is empty");
            return;
        }
        System.out.println("---------" + menuTitle + "--------");
        for (String x : optionList) {
            System.out.println(x);
        }
    }

    public int getChoice() {
        int maxChoice = optionList.size();
        int choice;
        do {
            try {
                System.out.println("Input your choice: ");
                Scanner sc = new Scanner(System.in);
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= maxChoice)
                    return choice;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
            }
        } while (true);
    }
}  
