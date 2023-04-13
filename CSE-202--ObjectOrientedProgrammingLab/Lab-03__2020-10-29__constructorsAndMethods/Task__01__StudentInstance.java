public class Task__01__StudentInstance {
    public static void main(String[] args) {
        STUDENT studentO = new STUDENT("Sabbir", 193002069, "CSE");
        studentO.printDetails();
    }
}

class STUDENT {
    String name, dept;
    int id;
    STUDENT(String a, int b, String c) {
        name = a;
        id = b;
        dept = c;
    }
    void printDetails() {
        System.out.printf("Name: %s\nID: %d\nDepartment: %s\n", name,id,dept);
    }
}