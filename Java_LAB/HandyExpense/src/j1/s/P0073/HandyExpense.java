package j1.s.P0073;

import java.text.ParseException;
import java.text.SimpleDateFormat; //xai string => date
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HandyExpense {
    ArrayList<Expense> list = new ArrayList<>();
    MyUtils utl = new MyUtils();
    Scanner s = new Scanner(System.in);
    
    void display(){
        if(list.isEmpty()){
            System.out.println("This list is empty!");
            return;
        }
        System.out.println("---------Display all expenses------------");
        System.out.println("ID\tDate\t\tAmount\tContent");
        for(int i = 0;i < list.size(); i++){
            System.out.print(list.get(i).getId() + "\t");
            System.out.print(list.get(i).getDate() + "\t");
            System.out.print(list.get(i).getAmount() + "\t");
            System.out.print(list.get(i).getContent() + "\n");
        }
    }
    
    void addExpense(){
        int id;
        String date;
        double amount;
        String content;
        boolean check;
        
        System.out.println("-------- Add an expense--------");
        if(list.isEmpty()){
            id = 1;
        }else{
            id = list.size() + 1;
        }
        date = checkDate("Enter date: ", "Invalid Date(dd/MM/yyyy)");
//        do {
//            check = true;
//            date = utl.getString("Input Date (EX:11-Apr-2000) : ", "Please input again!");
//            if (date.matches("[0-9]{2}-[A-Za-z]{3}-[0-9]{4}")) {
//                int yearFromString = Integer.parseInt(date.substring(7, 11).trim());
//                if (yearFromString > Calendar.getInstance().get(Calendar.YEAR) || yearFromString < 1900) {
//                    System.err.println("Out of YearExp");
//                    check = false;
//                } else {
//                    String monthFromString = date.substring(3, 6);
//                    int dayFromString = Integer.parseInt(date.substring(0, 2).trim());
//                    
//                    if (monthFromString.equalsIgnoreCase("Jan")
//                            || monthFromString.equalsIgnoreCase("Mar")
//                            || monthFromString.equalsIgnoreCase("May")
//                            || monthFromString.equalsIgnoreCase("Jul")
//                            || monthFromString.equalsIgnoreCase("Aug")
//                            || monthFromString.equalsIgnoreCase("Oct")
//                            || monthFromString.equalsIgnoreCase("Dec")) {
//                            if (dayFromString > 31 || dayFromString <= 0) {
//                                System.err.println("Wrong input day!");
//                                check = false;
//                            }
//                    } else if (monthFromString.equalsIgnoreCase("Apr")
//                            || monthFromString.equalsIgnoreCase("Jun")
//                            || monthFromString.equalsIgnoreCase("Sep")
//                            || monthFromString.equalsIgnoreCase("Nov")) {
//                            if (dayFromString > 30 || dayFromString <= 0) {
//                                System.err.println("Wrong input day!");
//                                check = false;
//                            }
//                            
//                    } else if (monthFromString.equalsIgnoreCase("Feb")) {                      
//                        if ((yearFromString % 4) == 0 
//                            || (yearFromString % 100) == 0) {
//                            if (dayFromString > 29 || dayFromString < 0) {
//                                System.err.println("Wrong input day!");
//                                check = false;
//                            }
//                        } else {
//                            if (dayFromString > 28 || dayFromString < 0) {
//                                System.err.println("Wrong input day!");
//                                check = false;
//                            }
//                        }                   
//                    } else {
//                        System.err.println("Wrong input month!");
//                        check = false;
//                    }
//                }  
//            }
//        } while (check == false);   

        amount = utl.getInt("Input amount: ", "Please input more than 0!", "Please input again!");
        content = utl.getString("Input content: ", "Please input again!");
        list.add(new Expense(id, date, amount, content));
        System.out.println("Input successfully!!!");
    }
    
    String checkDate(String msg, String error){
        while(true){
            try {
                //import SimpleDatFormat;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false); //most important - ktra tinh hop le cua date
                System.out.print(msg);
                String date = s.nextLine().trim();
                Date d = sdf.parse(date);//import Date;
                return date;
            } catch (ParseException e) {
                System.out.println(error);
            }
        }
    }
    
    void deleteExpense(){
        System.out.println("--------Delete an expense------");
        int id_delete = utl.getInt("Enter an Id to delete: ", "Please input more than 0", "Please input");
        Expense exp = utl.getExpenseById(list, id_delete);
        if (exp == null) {
            System.err.println("Delete an expense fail.");
            return;
        }else {
            list.remove(exp);
        }
        System.out.println("Delete expense successfully");
         
        if (!list.isEmpty()) {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                count++;
                list.get(i).setId(count);
            }
        }
    }
}
