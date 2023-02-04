#include <iostream>

void printList(int userList[], int upperIndex) {
    std:: cout << "Sorted Array: ";
    for (int i=0; i<upperIndex; i++) {
        std:: cout << userList[i];
        if (i+1 != upperIndex) {
            std:: cout << " ";
        }
        else {
            std:: cout << std:: endl;
        }
    }
}

void swapValue(int *firstValue, int *secondValue) {
    int temp = *firstValue;
    *firstValue = *secondValue;
    *secondValue = temp;
}

void selectionSort(int userList[], int upperIndex) {
    int minIndex;
    for (int j=0; j<upperIndex; j++) {
        minIndex = j;
        for (int k=j+1; k<upperIndex; k++) {
            if (userList[k] < userList[minIndex]) {
                minIndex = k;
            }
        }
        swapValue(&userList[minIndex], &userList[j]);
    }
}

int main() {
    int arraySize;
    std:: cout << "Array Size: ";
    std:: cin >> arraySize;
    int userList[arraySize];
    for (int i=0; i< arraySize; i++) {
        std:: cin >> userList[i];
    }
    selectionSort(userList, arraySize);
    printList(userList, arraySize);
    return 0;
}