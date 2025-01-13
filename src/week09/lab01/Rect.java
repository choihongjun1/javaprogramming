package week09.lab01;

public class Rect {
    int width;
    int height;
    int area;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
        area = width * height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rect) {
            Rect rect = (Rect) obj;
            if (area == rect.area) {
                return true;
            }
        }
        return false;
    }
}
