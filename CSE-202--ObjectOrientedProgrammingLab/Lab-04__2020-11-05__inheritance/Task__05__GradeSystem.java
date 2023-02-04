import java.util.Scanner;

public class Task__05__GradeSystem {
    public static void main(String[] args) {
        AIUB objectAIUB = new AIUB();
        GUB objectGUB = new GUB();
        Scanner input = new Scanner(System.in);
        System.out.print("Marks: ");
        int inputNumber = input.nextInt();
        input.close();
        objectGUB.gubGrade(inputNumber);
        objectAIUB.aiubGrade(inputNumber);
    }
}

class Grade {
    String calculateGrade(int marks, int maximum) {
        String grade;
        if(marks>=maximum)
            grade = "A+";
        else if(marks>=maximum-5)
            grade = "A";
        else if(marks>=maximum-10)
            grade =
             "A-";
        else if(marks>=maximum-15)
            grade = "B+";
        else if(marks>=maximum-20)
            grade = "B";
        else if(marks>=maximum-25)
            grade = "B-";
        else if(marks>=maximum-30)
            grade = "C+";
        else if(marks>=maximum-35)
            grade = "C";
        else if(marks>=maximum-40)
            grade = "D";
        else
            grade = "F";
        return grade;
    }
}

class AIUB extends Grade {
    void aiubGrade(int studentMarks) {
        System.out.printf("AIUB GPA: %s\n", calculateGrade(studentMarks, 90));
    }
}

class GUB extends Grade {
    void gubGrade(int studentMarks) {
        System.out.printf("GUB GPA: %s\n", calculateGrade(studentMarks, 80));
    }
}