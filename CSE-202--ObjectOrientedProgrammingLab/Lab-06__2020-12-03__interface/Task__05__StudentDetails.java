import java.util.Scanner;

interface HighestStudent {
    public void setDetails(String name, int id, int marks);
    public void display();
}

abstract class Student implements HighestStudent {
    String studentName;
    int studentID;
    int studentMarks;

    public void setDetails(String name, int id, int marks) {
        this.studentName = name;
        this.studentID = id;
        this.studentMarks = marks;
    }
    public void display() {
        System.out.println("Details of the highest mark Student...");
        System.out.println("\tName: " + studentName);
        System.out.println("\tID: " + studentID);
        System.out.println("\tMarks: " + studentMarks);
    }
}

public class Task__05__StudentDetails {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Student objectArray[];

        System.out.print("Number of Students: ");
        int studentsNumber = input.nextInt();
        objectArray = new Student[studentsNumber];
        int searchedStudent = 0;

        for (int i=0; i<studentsNumber; i++) {
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("ID: ");
            int id = input.nextInt();
            System.out.print("Marks: ");
            int marks = input.nextInt();
            objectArray[i].setDetails(name, id, marks);
        }

        System.out.print("Search by Student ID: ");
        int searchID = input.nextInt();

        for (int i=0; i<studentsNumber; i++) {
            if (objectArray[i].studentID == searchID) {
                searchedStudent = i;
                break;
            }
        }

        objectArray[searchedStudent].display();
        input.close();
    }
}