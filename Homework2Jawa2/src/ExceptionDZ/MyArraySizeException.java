package ExceptionDZ;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    String simbol;

    public MyArraySizeException(String msg1, String msg2, String symbol) {
        super(msg1);
        this.simbol = symbol;
        System.out.println(msg2 + ": " + "'" + symbol + "'");
    }
}
