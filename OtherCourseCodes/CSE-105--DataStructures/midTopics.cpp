/**
    Traversing
    Inserting
    Deleting
    Searching
        linerarSearch
        binarySearch
    Sorting
        bubbleSort
        inserstionSort
        selectionSort
        mergerSort
        quickSort

coded by shmVirus
**/

#include <iostream>


void printList(int userList[100], int upperIndex) {
    for (int i=0; i<upperIndex; i++) {
        std:: cout << userList[i] << " ";
    }
}

void swapValue(int *firstValue, int *secondValue) {
    int temp = *firstValue;
    *firstValue = *secondValue;
    *secondValue = temp;
}


int linearSearch(int userList[100], int upperIndex, int searchValue) {
    int inIndex=0;
    for (int i=0; i<upperIndex; i++) {
        if (userList[i] == searchValue) {
            inIndex = i;
            break;
        }
    }
    return inIndex;
}

int binarySearch(int userList[100], int lowerIndex, int upperIndex, int searchValue) {
    int inIndex=0, centerIndex;
    while (upperIndex >= lowerIndex) {
        centerIndex = (upperIndex - lowerIndex) / 2;
        if (userList[centerIndex] > searchValue) {
            upperIndex = centerIndex-1;
        } else if (userList[centerIndex] < searchValue) {
            lowerIndex = centerIndex+1;
        } else {
            inIndex = centerIndex;
            break;
        }
    }
    return inIndex;
}


void insertion(int userList[100], int upperIndex) {
    int newValue, inIndex;
    std:: cin >> newValue;
    std:: cin >> inIndex;
    inIndex--;
    for(int listSize=upperIndex; listSize>=inIndex; listSize--) {
        userList[listSize+1] = userList[listSize];
    }
    userList[inIndex] = newValue;
    upperIndex++;
    printList(userList, upperIndex);
}

void deletion(int userList[100], int upperIndex) {
    int deleteIndex, deleteValue, userChoice;
    std:: cin >> deleteValue;
    std:: cin >> userChoice;
    switch(userChoice) {
    case 1:
        deleteIndex = linearSearch(userList, upperIndex, deleteValue);
    case 2:
        deleteIndex = binarySearch(userList, 0, upperIndex, deleteValue);
    }
    for (deleteIndex; deleteIndex<upperIndex; deleteIndex++) {
        userList[deleteIndex] = userList[deleteIndex+1];
    }
    upperIndex--;
    printList(userList, upperIndex);
}


void bubbleSort(int userList[100], int upperIndex) {
    int swapTemp;
    for (int j=0; j<upperIndex; j++) {
        for (int k=0; k<upperIndex-j; k++) {
            if (userList[k+1] < userList[k]) {
                swapValue(&userList[k], &userList[k+1]);
            }
        }
    }
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
}

void selectionSort(int userList[100], int upperIndex) {
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

void mergeSortMerger(int userList[100], int lowerIndex, int centerIndex, int upperIndex) {
    int leftArrayIndex, rightArrayIndex, leftArray[50], rightArray[50];
    leftArrayIndex = centerIndex-lowerIndex+1;
    rightArrayIndex = upperIndex-centerIndex;
    for (int i=0; i<leftArrayIndex; i++) {
        leftArray[i] = userList[lowerIndex+i];
    }
    for (int j=0; j<rightArrayIndex; j++) {
        rightArray[j] = userList[centerIndex+1+j];
    }
    int i=0, j=0, k=lowerIndex;
    while (i<leftArrayIndex && j<rightArrayIndex) {
        if (leftArray[i] <= rightArray[j]) {
            userList[k] = leftArray[i];
            i++;
        } else {
            userList[k] = rightArray[j];
            j++;
        }
        k++;
    }
    while (i<leftArrayIndex) {
        userList[k] = leftArray[i];
        i++;
        k++;
    }
    while (j<rightArrayIndex) {
        userList[k] = rightArray[j];
        j++;
        k++;
    }
}
void mergeSort(int userList[100], int lowerIndex, int upperIndex) {
    int centerIndex;
    if (lowerIndex < upperIndex) {
        centerIndex = (lowerIndex+upperIndex)/2;
        mergeSort(userList, lowerIndex, centerIndex);
        mergeSort(userList, centerIndex+1, upperIndex);
        mergeSortMerger(userList, lowerIndex, centerIndex, upperIndex);
    }
}

int quickSortPartition(int userList[100], int lowerIndex, int upperIndex) {
    int pivot = userList[upperIndex];
    int i = lowerIndex-1;
    for (int j=lowerIndex; j<upperIndex; j++) {
        if (userList[j] < pivot) {
            i++;
            swapValue(&userList[i], &userList[j]);
        }
    }
    swapValue(&userList[i+1], &userList[upperIndex]);
    return (i+1);
}
void quickSort(int userList[100], int lowerIndex, int upperIndex) {
    int partitionIndex;
    if (lowerIndex < upperIndex) {
        partitionIndex = quickSortPartition(userList, lowerIndex, upperIndex);
        quickSort(userList, lowerIndex, partitionIndex-1);
        quickSort(userList, partitionIndex+1, upperIndex);
    }
}


int main() {
    int userList[100], elementNumber, userChoice;
    std:: cin >> elementNumber;
    for (int i=0; i< elementNumber; i++) {
        std:: cin >> userList[i];
    }

    std:: cin >> userChoice;
    switch(userChoice) {
    case 1:
        bubbleSort(userList, elementNumber);
        break;
    case 2:
        insertionSort(userList, elementNumber);
        break;
    case 3:
        selectionSort(userList, elementNumber);
        break;
    case 4:
        mergeSort(userList, 0, elementNumber);
        break;
    case 5:
        quickSort(userList, 0, elementNumber);
        break;
    }

    printList(userList, elementNumber);

    std:: cin >> userChoice;
    switch(userChoice) {
    case 1:
        insertion(userList, elementNumber);
        break;
    case 2:
        deletion(userList, elementNumber);
    }
    return 0;
}
