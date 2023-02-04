import java.util.Scanner;

public class Task__04__checkCharacter {
    public static void main(String[] args) {
        userCharacter object = new userCharacter();
        object.findType();

    }
}

class Type {
    boolean isDigit = false;
    boolean isVowel = false;
    boolean isConsonant = false;
    boolean isSpecial = false;

    void findType(char ch) {
        if (ch>=65 && ch<=90 || ch>=97 && ch<=122) {
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
                isVowel = true;
            } else {
                isConsonant = true;
            }
        } else if (ch>=48 && ch<=57) {
            isDigit = true;
        } else {
            isSpecial = true;
        }
    }
}

class userCharacter extends Type {
    void findType() {
        Scanner input = new Scanner(System.in);
        System.out.print("Charecter: ");
        char n = input.next().charAt(0);
        input.close();
        findType(n);
        if (isDigit) {
            System.out.println("\"" + n + "\" is a Digit");
        }
        else if (isVowel) {
            System.out.println("\"" + n + "\" is a Vowel");
        }
        else if (isConsonant) {
            System.out.println("\"" + n + "\" is a Cosonant");
        }
        else if (isSpecial) {
            System.out.println("\"" + n + "\" is a Special Character");
        }
    }
}