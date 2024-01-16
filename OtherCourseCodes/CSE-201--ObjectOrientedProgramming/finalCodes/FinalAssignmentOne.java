interface Student {
    void details();
}

class A implements Student {
    @Override
    public void details() {
        System.out.println("My Name is Sabbir");
    }
}
class B implements Student {
    @Override
    public void details() {
        System.out.println("My StudentID is 193002069");
    }
}

public class FinalAssignmentOne {
    public static void main(String[] args) {
        A name = new A();
        name.details();
        B id = new B();
        id.details();
    }
}