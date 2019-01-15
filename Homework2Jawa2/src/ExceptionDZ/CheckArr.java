package ExceptionDZ;

public class CheckArr {
    public static void checkArray(String[][] arr) throws MyArraySizeException {
        int maxSize = 4;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if ((i + 1)> maxSize || (j + 1) > maxSize) {
                    throw new MyArraySizeException("Выход за ограничение массива","Ошибка в значении", arr[i][j]);
                }
            }
        }
    }
}
