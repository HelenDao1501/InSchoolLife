package j1.s.p0051;

public class BMI {
    double weigth;
    double height;
    
    void Calculate(double weigth, double height, double bmi){
        bmi=(weigth)/((height/100)*(height/100));
        System.out.println("Your BMI: "+bmi);
        if (bmi < 19){
            System.out.println("You're under standard!");
        }
        else{
            if(bmi >= 19||bmi < 25){
                System.out.println("Congrast! You're perfect in standard.");
            }
            else{
                if(bmi >= 25||bmi < 30){
                    System.out.println("Your're overweight :<");
                }
                else{
                    if(bmi >= 30||bmi < 40)
                    {
                        System.out.println("OMG. You fat!");
                    }
                    else{
                        System.out.println("You very fat !!");
                    }
                }
            }
        }
    }     
}
