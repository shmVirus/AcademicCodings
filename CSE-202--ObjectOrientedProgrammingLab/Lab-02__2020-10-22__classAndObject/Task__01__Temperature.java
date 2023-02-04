import java.util.Scanner;

public class Task__01__Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Temperature object = new Temperature();
        System.out.print("Celsius: ");
        short celsius = input.nextShort();
        input.close();
        System.out.printf("Fahrenheit: %.2f\n", object.converter(celsius));
    }
}
class Temperature {
    float converter(short temp) {
        float fahrenheit = (((float)temp*9)/5)+32;
        return fahrenheit;
    }
}