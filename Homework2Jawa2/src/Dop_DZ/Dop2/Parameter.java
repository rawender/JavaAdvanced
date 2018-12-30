package Dop_DZ.Dop2;

public class Parameter {
    double weight;
    double height;

    public Parameter(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public String getResult() {
        String result = null;
        if (BodyMassIndex.getBMI(weight, height) < 18.5) {
            result = "under ";
        } else if (BodyMassIndex.getBMI(weight, height) >= 18.5 && BodyMassIndex.getBMI(weight, height) < 25.0) {
            result = "normal ";
        } else if (BodyMassIndex.getBMI(weight, height) >= 25.0 && BodyMassIndex.getBMI(weight, height) < 30.0) {
            result = "over ";
        } else if (BodyMassIndex.getBMI(weight, height) >= 30.0) {
            result = "obese ";
        }
        return result;
    }
}
