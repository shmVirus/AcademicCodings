#include <iostream>

void printList(int userList[], int upperIndex) {
    for (int i=0; i<upperIndex; i++) {
        std:: cout << userList[i] << " ";
    }
    std:: cout << std:: endl;
}

void swapValue(int *firstValue, int *secondValue) {
    int temp = *firstValue;
    *firstValue = *secondValue;
    *secondValue = temp;
}

void bubbleSort(int userList[], int upperIndex) {
    int swapTemp;
    for (int j=0; j<upperIndex; j++) {
        for (int k=0; k<upperIndex-j; k++) {
            if (userList[k+1] < userList[k]) {
                swapValue(&userList[k], &userList[k+1]);
            }
        }
    }
    std:: cout << "Sorted List using Bubble Sort: ";
    printList(userList, upperIndex);
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
    std:: cout << "Sorted List using Selection Sort: ";
    printList(userList, upperIndex);
}

int main() {
    int elementNumber;
    std:: cout << "Enter Size: ";
    std:: cin >> elementNumber;
    int userList[elementNumber];
    int forBubble[elementNumber];
    int forInsertion[elementNumber];
    int forSelection[elementNumber];
    //14 12 45 31 65 10 25 12
    for (int i=0; i<elementNumber; i++) {
        std:: cin >> userList[i];
        forBubble[i] = forInsertion[i] = forSelection[i] = userList[i];
    }
    bubbleSort(forBubble, elementNumber);
    insertionSort(forInsertion, elementNumber);
    selectionSort(forSelection, elementNumber);
    return 0;
}