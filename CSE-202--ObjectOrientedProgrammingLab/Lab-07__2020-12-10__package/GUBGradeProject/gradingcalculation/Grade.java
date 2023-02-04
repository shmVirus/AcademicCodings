import java.util.Scanner;
import gubgrading.*;

public class Grade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GUB_Grading grade = new GUB_Grading();
        int marks;
        for(int i=0; i<10; i++) {
            System.out.print("Number: ");
            marks = input.nextInt();
            grade.gradeCalculator(marks);
        }
        input.close();
    }
}