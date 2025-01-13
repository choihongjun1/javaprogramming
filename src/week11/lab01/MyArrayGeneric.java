package week11.lab01;

public class MyArrayGeneric<T> {
    private final int CAPACITY;
    private int count = 0; // 저장된 개수
    T[] arr;

    public MyArrayGeneric(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        arr = (T[]) new Object[this.CAPACITY];
    }

    public void add(T e) {
        if (this.count < this.CAPACITY)
            arr[count++] = e;
        else
            System.out.println("공간부족");
    }

    public T getElement(int index) {
        if (index >= 0 && index < count)
            return arr[index];
        else
            return null;
    }

    public int getCAPACITY() {
        return this.CAPACITY;
    }

    @Override
    public String toString() {
        String result = "";
        for (T e : arr) {
            result += e + "\n";
        }
        return result;
    }
}

