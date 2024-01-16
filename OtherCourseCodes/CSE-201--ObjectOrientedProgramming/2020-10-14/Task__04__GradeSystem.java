import java.util.Scanner;

public class Task__04__GradeSystem {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte studentMarks = input.nextByte();
        input.close();
        switch(studentMarks/10) {
            case 10: System.out.println("A+"); break;
            case 9: System.out.println("A+"); break;
            case 8: System.out.println("A+"); break;
            case 7:
            if (studentMarks>=75) System.out.println("A");
            else System.out.println("A-");
            break;
            case 6:
            if (studentMarks>=65) System.out.println("B+");
            else System.out.println("B");
            break;
            case 5:
            if (studentMarks>=55) System.out.println("B-");
            else System.out.println("C+");
            break;
            case 4:
            if (studentMarks>=45) System.out.println("C");
            else System.out.println("D");
            break;
            default: System.out.println("Fail");
        }
	}
}