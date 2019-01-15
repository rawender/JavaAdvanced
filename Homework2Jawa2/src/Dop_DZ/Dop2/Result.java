package Dop_DZ.Dop2;

public class Result {
    Parameter[] parameters;

    public Result(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public void showInfo(){
        for (Parameter c : parameters) {
            System.out.print(c.getResult());
        }
    }
}
