package j1.s.p0051;

import java.util.Scanner;

public class Main {
    Scanner sc= new Scanner(System.in);
    
    void Menu(){
        int choice;
        boolean count;
        do{
            try{
                do{
                    System.out.println("1. Calculator");
                    System.out.println("2. BMI ");
                    System.out.println("3. Quit !");
                    System.out.println("Input:");
                sc= new Scanner(System.in);
                choice=sc.nextInt();
                switch(choice){
                    case 1:
                        char calculate;
                        double a;
                        double b;
                        double result;
                            System.out.println("Input number: ");
                            a=sc.nextInt();
                            result=a;
                            do{
                            System.out.println("Input calulate:");
                            calculate=sc.next().charAt(0);
                            switch(calculate){
                                case '+':{
                                    System.out.println("Input number: ");
                                    b=sc.nextInt();
                                    result=result+b;
                                    break;
                                }
                                case '-': {
                                    System.out.println("Input number: ");
                                    b=sc.nextInt();
                                    result=result-b;
                                    break;
                                }
                                case 'x':{
                                    System.out.println("Input number: ");
                                    b=sc.nextInt();
                                    result=result*b;
                                    break;
                                }
                                case '/':{
                                    boolean val= false;
                                    do{
                                    System.out.println("Input number: ");                                   
                                    b=sc.nextInt();
                                    if (b==0){
                                        System.out.println("Not valid !");
                                        val= false;
                                    }
                                    else {
                                        result=result/b;
                                        val=true;
                                    }         
                                    }while (val==false);
                                }
                                case '=':{
                                    break;
                                }
                                default:{
                                    System.out.println("Wrong!");
                                    break;
                                }
                            }
                                System.out.println("Result: "+result);
                            }while (calculate!='=');
                        break;
                        
                    case 2:
                        Scanner sc= new Scanner(System.in);
                        double height;
                        double weight;
                        double bmi = 0;
                        System.out.println("Input your weight: ");
                        weight=sc.nextInt();
                        System.out.println("Input your height: ");
                        height=sc.nextInt();
                        BMI obj= new BMI();
                        obj.Calculate(weight, height, bmi);
                        break;

                    case 3:{
                        System.out.println("Good Bye!");
                        break;
                    }
                    default:{
                        System.out.println("Not valid!");
                        break;
                    }
                }
            }while (choice != 3);
            count=true;
            }
            catch(Exception e){
                System.out.println("Sai cu phap !");
                count=false;
            }
        }while (count!=true);
    }
    
    public static void main(String[] args) {
        Main obj= new Main();
        obj.Menu();
    }
    
}
