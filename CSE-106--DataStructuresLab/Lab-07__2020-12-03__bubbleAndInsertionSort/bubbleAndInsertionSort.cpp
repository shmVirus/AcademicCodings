#include <iostream>

void printList(int userList[100], int upperIndex) {
    for (int i=0; i<upperIndex; i++) {
        printf("%d", userList[i]);
        if (i+1 != upperIndex) printf(" ");
        else printf("\n");
    }
}

void swapValue(int *firstValue, int *secondValue) {
    int temp = *firstValue;
    *firstValue = *secondValue;
    *secondValue = temp;
}

void bubboleSort(int userList[100], int upperIndex) {

    for (int j=0; j<upperIndex-1; j++) {
        bool isSorted = true;
        for (int k=0; k<upperIndex-j; k++) {
            if (userList[k+1] < userList[k]) {
                swapValue(&userList[k], &userList[k+1]);
                isSorted = false;
            }
        }
        if (isSorted) break;
    }

    printf("Sorted using BubbleSort: ");
    printList(userList, upperIndex);
}

void insertionSort(int userList[100], int upperIndex) {
    int temp;
    for (int j=1; j<upperIndex; j++) {
        temp = userList[j];
        int k = j-1;
        while (k>=0 && userList[k] > temp) {
            swapValue(&userList[k], &userList[k+1]);
            k--;
        }
        userList[k+1] = temp;
    }
    printf("Sorted using InsertionSort: ");
    printList(userList, upperIndex);
}

int main() {

    int userList[100], elementNumber;
    printf("Number of Elements: ");
    scanf("%d", &elementNumber);
    for (int i=0; i< elementNumber; i++) {
        scanf("%d", &userList[i]);
    }

    bubboleSort(userList, elementNumber);
    insertionSort(userList, elementNumber);

    return 0;
}