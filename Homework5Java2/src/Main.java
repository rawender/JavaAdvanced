public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    static float[] fillArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        return arr;
    }

    static void disassembleAssemble(float[] arr) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long b = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr,0,a1,0,h);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr,h,a2,0,h);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - b);

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(a1,0,arr,0,h);
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(a2,0,arr,h,h);
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - b);
    }

    public static void main(String[] args) {
        float[] arr = new float[size];

        fillArray(arr);

        disassembleAssemble(arr);

    }
}

