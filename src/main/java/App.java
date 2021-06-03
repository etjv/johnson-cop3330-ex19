/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Edmund Johnson V
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/*
You’ll often need to see if one value is within a certain range and alter the flow of a program as a result.

Create a program to calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds. The program should prompt the user for weight and height.

Calculate the BMI by using the following formula:

bmi = (weight / (height × height)) * 703
If the BMI is between 18.5 and 25, display that the person is at a normal weight. If they are out of that range, tell them if they are underweight or overweight and tell them to consult their doctor.

Example Output
Your BMI is 19.5.
You are within the ideal weight range.
or

Your BMI is 32.5.
You are overweight. You should see your doctor.
Constraint
Ensure your program takes only numeric data. Don’t let the user continue unless the data is valid.
 */
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] arg){
        float height = getHeight();
        float weight = getWeight();
        System.out.println(output(height, weight));
    }

    private static float getHeight(){
        System.out.print("Enter your height in inches: ");
        String x = in.nextLine();
        if(!x.contains("[a-zA-Z]+")){
            return Float.parseFloat(x.replace(" ",""));
        }
        else{
            System.out.println("Only numerical digits are allowed!");
            return getHeight();
        }
    }

    private static float getWeight(){
        System.out.print("Enter your weight in pounds: ");
        String x = in.nextLine();
        if(!x.contains("[a-zA-Z]+")){
            return Float.parseFloat(x.replace(" ",""));
        }
        else{
            System.out.println("Only numerical digits are allowed!");
            return getWeight();
        }
    }

    private static String output(float height, float weight){
        DecimalFormat d = new DecimalFormat("0.0");
        float bmi = (weight / (height * height)) * 703;
        return (bmi > 18.5) || (bmi < 25)
                ? "Your BMI is " + d.format(bmi) + ".\nYou are within the ideal weight range."
                : "Your BMI is " + d.format(bmi) + ".\nYou are overweight. You should see your doctor.";
    }
}
