import java.util.Scanner;
public class Problem__B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hours: ");
        int h = input.nextInt();
        System.out.print("Minutes: ");
        int m = input.nextInt();
        System.out.print("Seconds: ");
        int s = input.nextInt();
        input.close();
        TimeShow objectOne = new TimeShow();
        objectOne.display();
        TimeShow objectTwo = new TimeShow(s,m,h);
        objectTwo.display();
        TimeShow objectThree = new TimeShow(objectTwo);
        objectThree.display();
    }
}
class TimeShow {
    private int second, minute, hour;
    TimeShow() {
        System.out.print("For Default Constructor-> ");
    }
    TimeShow(int s, int m, int h) {
        hour = h;
        minute = m;
        second = s;
        System.out.print("For Constructor with Value-> ");
    }
    TimeShow(TimeShow objectTwo) {
        hour = objectTwo.hour;
        minute = objectTwo.minute;
        second = objectTwo.second;
        System.out.print("For Constructor with Reference-> ");
    }
    void display(){
        System.out.println(hour+"h:"+minute+"m:"+second+"s");
    }
}
