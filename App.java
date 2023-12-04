import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;
public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a given option");
        System.out.println("1.To check BMI in inches and lbs");
        System.out.println("2.To check BMI in cm and kilograms");
        int option = sc.nextInt();
        if(option == 1){
            System.out.println("Enter your height in inches: ");
            double height = sc.nextDouble();
            System.out.println("Enter your weight in lbs: ");
            double weight = sc.nextDouble();
            double bodyMass = weight / Math.pow(height, 2) *703;
            DecimalFormat df = new DecimalFormat("0.0");
            if (bodyMass < 18.5) {
           System.out.println("You are Underweight.");
        }
        else if (bodyMass < 25) {
            System.out.println("You are Normal.");
        }
        else if (bodyMass < 30) {
            System.out.println("You are Overweight.");
        }
        else {
           System.out.println("You are Obese.");
        }

            System.out.println("Your BMI is "+df.format(bodyMass));
        }
        else if(option == 2){
            System.out.println("Enter your height in cm: ");
            double heightInCm = sc.nextDouble();
            System.out.println("Enter your weight in kilograms: ");
            double weightInKg = sc.nextDouble();
            double bodyMass = weightInKg / Math.pow(heightInCm/100, 2) ;
            DecimalFormat df = new DecimalFormat("0.0");

            System.out.println("Your BMI is "+df.format(bodyMass));
            if (bodyMass < 18.5) {
           System.out.println("You are Underweight.");
        }
        else if (bodyMass < 25) {
            System.out.println("You are Normal.");
        }
        else if (bodyMass < 30) {
            System.out.println("You are Overweight.");
        }
        else {
           System.out.println("You are Obese.");
        }
        }
        else{
            System.out.println("ERROR! SELECT A VALID OPTION");
        }
        sc.close();
       
    }
}