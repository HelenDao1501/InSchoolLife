package j1.s.P0050;

import static java.lang.Math.pow;
import java.util.ArrayList;

public class NumberMng {
    ArrayList<Number> list = new ArrayList<>();
    MyUtils utl = new MyUtils();
    float x, x1, x2;
    float delta; //denta cho ptb2
    
    void inputNumberA_B(){
        float number;
        //input A
        do {
            number = utl.getNumber("Enter A: ", "Invalid !!! Just input number");
            if(number == 0)
                System.out.println("A can't be 0");
        } while (number == 0);
        list.add(new Number(number));
        //input B
        number = utl.getNumber("Enter B: ", "Invalid !!! Just input number");
        list.add(new Number(number));
    }
    
    void inputNumberA_B_C(){
        float number;
        //input A
        do {
            number = utl.getNumber("Enter A: ", "Invalid !!! Just input number");
            if(number == 0)
                System.out.println("A can't be 0");
        } while (number == 0);
        list.add(new Number(number));
        //input B
        number = utl.getNumber("Enter B: ", "Invalid !!! Just input number");
        list.add(new Number(number));
        //input C
        number = utl.getNumber("Enter C: ","Invalid !!! Just input number");
        list.add(new Number(number));
    }
    
    //bac1
    void calSuperlativeEqualation(){
        x = (- list.get(1).getNumber()) / (list.get(0).getNumber());
        if(x == -0){
            x = 0;
        }
        System.out.print("Solution: x = " + x + "\n");
    }
    
    //ptbac2
    void calQuadraticEquation(){
        //denta=b^2-4ac
        //<0 pt vo n.
        //< n. kep x1=x2=-b/2a
        delta = (float) (pow(list.get(1).getNumber(), 2)) 
                - (4 * list.get(0).getNumber() * list.get(2).getNumber());
        if(delta < 0)
            System.out.println("The equation has no solution");
        else if(delta == 0){
            x = (-list.get(1).getNumber())/(2 * list.get(0).getNumber());
            System.out.println("Solution x = " + x);
        }
        else{
            x1 = (float) ( (-list.get(1).getNumber() + Math.sqrt(delta)) 
                    / (2 * list.get(0).getNumber()) );
            x2 = (float) ( (-list.get(1).getNumber() - Math.sqrt(delta)) 
                    / (2 * list.get(0).getNumber()) );
            System.out.println("Solution: x1 = " + x1 + " x2 = " + x2);
        }
            
    }
    

    //chan, le, cph
    void displayOdd_Even_Square(){
        int flag = 0;
        int checkSq;
        
        //odd number 
        System.out.println("Number is Odd: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber() % 2 != 0) {
                System.out.print(list.get(i).getNumber() + ", ");
                flag = 1;
            }
        }
        flag = utl.checkFlag(flag);
        
        //even number %2=0
        System.out.println("");
        System.out.print("Even Number: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber() % 2 == 0) {
                System.out.print(list.get(i).getNumber() + ", ");
                flag = 1;                
            }
        }
        flag = utl.checkFlag(flag);
        
        //perfect square number
        System.out.println("");
        System.out.print("Perfect Square Number: ");
        for (int i = 0; i < list.size(); i++) {
            checkSq = (int) Math.sqrt(list.get(i).getNumber());
            checkSq = (int) pow(checkSq, 2);
            if (checkSq == list.get(i).getNumber()) {
                System.out.print(list.get(i).getNumber() + ", ");
                flag = 1;
            }
        }
        utl.checkFlag(flag);
        System.out.println();
    }
}

