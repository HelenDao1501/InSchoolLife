package j1.s.p0055;

import java.util.ArrayList;
import java.util.Scanner;

public class DoctorManager {
    ArrayList<Doctor> list = new ArrayList();
    MyUtils utl = new MyUtils();
    
    void addDoctor(){
        String code;
        String name;
        String Spec;
        int avail;
        boolean check;
        do{
            code= utl.getString("Enter Code (DOC x with x = max 99999): ", "Please input!");
            if (!code.matches("(DOC){1}[ ]{1}([0-9]{1,5})"))
                System.err.println("Code Invalid");
            if (!utl.checkCodeExist(list, code)) {
                System.err.println("Code exist.");
            } 
        } while (!utl.checkCodeExist(list, code) || !code.matches("(DOC){1}[ ]{1}([0-9]{1,5})"));
        do{
            check = true;
            name = utl.getString("Enter Name: ", "Please input!");
            if (!name.matches("[a-zA-Z\\s]{2,50}")) {
                check = false;
                System.err.println("Wrong input name");
            }
        } while (check == false);      
        Spec = utl.getString("Enter Specialization: ", "Please input!");
        avail = utl.getInt("Enter Availability: ", "Please input more than 0!", "Just input number!");
        list.add(new Doctor(code, name, Spec, avail));
        System.out.println("Enter Successfully");
    }
    
    void displayDoctor(){
        if (list.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        System.out.println("---------Result--------");
        System.out.println("Code\tName\tSpecialization\tAvailability");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i).getCode() + "\t");
            System.out.print(list.get(i).getName() + "\t");
            System.out.print(list.get(i).getSpec() + "\t");
            System.out.print(list.get(i).getAvail()+ "\n");
        }
    }
    
    void updateDoctor(){
        if (list.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String code;
        do {
            code = utl.getString("Enter Code: ", "Please input!");
            if (!code.matches("(DOC){1}[ ]{1}([0-9]{1,5})"))
                System.err.println("Code Invalid");
        } while (!code.matches("(DOC){1}[ ]{1}([0-9]{1,5})"));
        if (utl.checkCodeExist(list, code)) {
            System.err.println("Code doesn't exist.");
            return;     
        }
        String newCode;
        String newName;
        String newSpec;
        int newAvail;
        do {
            newCode = utl.getString("Enter New Code: ", "Please input!");
            if (!utl.checkCodeExist(list, newCode)) {
                System.err.println("Code exist.");
            }
        } while (!utl.checkCodeExist(list, newCode));
        Doctor doc = utl.getDoctorByCode(list, code);
        newName = utl.getString("Enter New Name: ", "Please input!");
        newSpec = utl.getString("Enter New Specialization: ", "Please input!");
        newAvail = utl.getInt("Enter New Availability: ", "Please input more than 0!", "Just input number!");
        doc.setCode(newCode);
        doc.setName(newName);
        doc.setSpec(newSpec);
        doc.setAvail(newAvail);
        System.out.println("Enter Successfully");       
    }
    
    public void deleteDoctor(){
        if (list.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        String code;
        do {
            code = utl.getString("Enter Code: ", "Please input!");
            if (!code.matches("(DOC){1}[ ]{1}([0-9]{1,5})"))
                System.err.println("Code Invalid");
        } while (!code.matches("(DOC){1}[ ]{1}([0-9]{1,5})"));
        Doctor doc = utl.getDoctorByCode(list, code);
        if (doc == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            list.remove(doc);
        }
        System.out.println("Delete successful.");
    }
    
    Scanner sc = new Scanner(System.in);
    public void searchDoctor(){
        if (list.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        System.out.print("Enter infomation: ");
        String info = sc.nextLine();
        System.out.println("---------Result--------");
        System.out.println("Code\tName\tSpecialization\tAvailability");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCode().contains(info)
                    || list.get(i).getName().contains(info)
                    || list.get(i).getSpec().contains(info)
                    || String.valueOf(list.get(i).getAvail()).contains(info)){
                System.out.print(list.get(i).getCode() + "\t");
                System.out.print(list.get(i).getName() + "\t");
                System.out.print(list.get(i).getSpec() + "\t");
                System.out.print(list.get(i).getAvail()+ "\n");
            }
        }
    } 
}
