package ExceptionDZ;

public class Array {
    public  Array(String[][] arr){
        try {
            CheckArr.checkArray(arr);
        } catch (MyArraySizeException e){
            e.printStackTrace();
        }
        System.out.println("Сумма всех числовых значений: " + getSum(arr));
    }

    private static int getSum(String[][] arr){
        int sum = 0;
        int a = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    a = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException d){ // Ломал голову, но так и не придумал как связать MyArrayDataException с NumberFormatException.
                    d.printStackTrace();
                }
                sum += a;
            }
        return sum;
    }
}
