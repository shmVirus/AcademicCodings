#include <iostream>

void printList(int userList[], int upperIndex) {
    for (int i=0; i<upperIndex; i++) {
        std:: cout << userList[i];
        if (i+1 != upperIndex) {
            std:: cout << " ";
        } else {
            std:: cout << std:: endl;
        }
    }
}

void swapValue(int *firstValue, int *secondValue) {
    int temp = *firstValue;
    *firstValue = *secondValue;
    *secondValue = temp;
}

void insertionSort(int userList[], int upperIndex) {
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
    std:: cout << "Sorted List using Insertion Sort: ";
    printList(userList, upperIndex);
}

int main() {
    int elementNumber=6;
    int userList[6] = {10,20,25,30,40,45};
    insertionSort(userList, elementNumber);
    return 0;
}