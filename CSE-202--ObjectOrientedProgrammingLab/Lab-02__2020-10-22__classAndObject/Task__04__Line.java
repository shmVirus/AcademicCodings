import java.util.Scanner;

public class Task__04__Line {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        Line object = new Line();
        short x1, x2, y1, y2;
        x1 = input.nextShort();
        y1 = input.nextShort();
        x2 = input.nextShort();
        y2 = input.nextShort();
        input.close();
        System.out.printf("Slope: %.2f\n", object.lineSlope(x1, x2, y1, y2));
    }
}
class Line {
    float lineSlope(short x1,short x2,short y1,short y2) {
        return ((float)y1-(float)y2)/((float)x1-(float)x2);
    }
}