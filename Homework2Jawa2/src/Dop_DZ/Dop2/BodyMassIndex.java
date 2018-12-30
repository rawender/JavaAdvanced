package Dop_DZ.Dop2;

public class BodyMassIndex{
    private static double bmi;

    public static double getBMI(double weight, double height){
        bmi = weight / (height * height);
        return bmi;
    }

}
