import java.util.Scanner;

public class Task__03__TuitionFee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TuitionFee tuitionFeeObject = new TuitionFee();
        int perCreditFee = 2800;
        System.out.print("Credits: ");
        float takenCredit = input.nextFloat();
        System.out.print("Main Waiver: ");
        float mainWaiver = input.nextFloat();
        System.out.print("Result Waiver: ");
        float resultsWaiver = input.nextFloat();
        input.close();
        System.out.println("Discounted Tuition Fee: " + tuitionFeeObject.tuitionFeeCalculator(perCreditFee, takenCredit, mainWaiver));
        mainWaiver += resultsWaiver/2;
        System.out.println("Final Scolarshipped Tuition Fee: " + tuitionFeeObject.tuitionFeeCalculator(perCreditFee, takenCredit, mainWaiver));
    }
}

class WithoutWaiverFee {
    int tuitionFeeCalculator(int creditFee, float credits, float waiver) {
        return (int)(creditFee*credits*(waiver/100));
    }
}
class TuitionFee extends WithoutWaiverFee {
    boolean isDone = false;
    @Override
    int tuitionFeeCalculator(int creditFee, float credits, float waiver) {
        if(!isDone) {
            System.out.println("Tuition Fee: " + super.tuitionFeeCalculator(creditFee, credits, 100));
            isDone=true;
        }
        waiver = 100-waiver;
        return (int)(creditFee*credits*(waiver/100));
    }
}