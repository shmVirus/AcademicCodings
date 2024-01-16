import java.util.Scanner;

public class Task__05__CharacterDefining {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v=0, c=0, d=0, s=0;
        String a = input.nextLine();
        input.close();
        for(int i=0; i<a.length(); i++) {
            if (a.charAt(i)>=65 && a.charAt(i)<=90 || a.charAt(i)>=97 && a.charAt(i)<=122) {
                if (a.charAt(i) == 'a' || a.charAt(i)=='e' || a.charAt(i)=='i' || a.charAt(i)=='o' || a.charAt(i)=='u' || a.charAt(i)=='A' || a.charAt(i)=='E' || a.charAt(i)=='I' || a.charAt(i)=='O' || a.charAt(i)=='U') {
                    v++;
                }
                else {
                    c++;
                }
            }
            else if (a.charAt(i)>=48 && a.charAt(i)<=57) {
                d++;
            } else {
                s++;
            }
        }
    System.out.printf("i)\t%d Vowels\nii)\t%d Consonants\niii)\t%d Digits\niv)\t%d Special Characters\n", v,c,d,s);
    }
}