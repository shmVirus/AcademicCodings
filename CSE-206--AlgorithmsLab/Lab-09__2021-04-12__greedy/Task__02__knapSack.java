import java.util.Scanner;

class Task__02__knapSack {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        float totalProfit=0;
        int trackItem=0;

        System.out.print("Items: ");
        int itemNumber = input.nextInt();
        int items[][] = new int[2][itemNumber];

        for (int i=0; i<itemNumber; i++) {
            System.out.print("Weight of "+ (i+1) +"-th Item: ");
            items[0][i] = input.nextInt();
        }

        for (int i = 0; i < itemNumber; i++) {
            System.out.print("Value of "+ (i+1) +"-th Item: ");
            items[1][i] = input.nextInt();
        }

        System.out.print("Weight of KnapSack: ");
        int knapSack = input.nextInt();
        input.close();

        int tempKnapSack = knapSack;
        while (tempKnapSack > 0) {
            float tempMax = 0;
            for (int i=0; i<itemNumber; i++) {
                if (((float) items[1][i])/((float) items[0][i]) > tempMax) {
                    tempMax = ((float) items[1][i]) / ((float) items[0][i]);
                    trackItem = i;
                }
            }
            if (items[0][trackItem] > tempKnapSack) {
                System.out.println("Weight of " + (trackItem+1) + "-th Item: " + tempKnapSack);
                totalProfit += tempKnapSack*tempMax;
                tempKnapSack = -1;
            }
            else {
                System.out.println("Weight of " + (trackItem+1) + "-th Item: " + items[0][trackItem]);
                tempKnapSack -= items[0][trackItem];
                totalProfit += (float) items[1][trackItem];
                items[1][trackItem] = 0;
            }
        }
        System.out.println("Total Profit: " + totalProfit + "$");
    }
}