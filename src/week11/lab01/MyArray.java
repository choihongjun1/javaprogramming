package week11.lab01;

public class MyArray {
    private final int CAPACITY;
    private int count = 0;
    int[] arr;

    public MyArray(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        arr = new int[this.CAPACITY];
    }

    public void add(int e) {
        if (this.count < this.CAPACITY)
            arr[count++] = e;
        else
            System.out.println("공간부족");
    }

    public int getElement(int index) {
        if (index >= 0 && index < count)
            return arr[index];
        else
            return Integer.MAX_VALUE;
    }

    public int getCAPACITY() {
        return this.CAPACITY;
    }

    @Override
    public String toString() {
        String result = "";
        for (int e : arr) {
            result += Integer.toString(e) + "\n";
        }
        return result;
    }
}
