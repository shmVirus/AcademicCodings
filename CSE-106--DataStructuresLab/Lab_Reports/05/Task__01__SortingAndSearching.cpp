#include <iostream>

bool isSorted=false;

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


int linearSearch(int userList[], int upperIndex, int searchValue) {
    int inIndex=-1;
    for (int i=0; i<upperIndex; i++) {
        if (userList[i] == searchValue) {
            inIndex = i;
            break;
        }
    }
    return inIndex;
}

int binarySearch(int userList[], int lowerIndex, int upperIndex, int searchValue) {
    int inIndex=-1, centerIndex;
    while (upperIndex >= lowerIndex) {
        centerIndex = (upperIndex + lowerIndex) / 2;
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
    isSorted = true;
}

int main() {
    int inIndex, elementNumber, searchValue, userChoice;
    std:: cout << "List Size: ";
    std:: cin >> elementNumber;
    int userList[elementNumber];
    for (int i=0; i<elementNumber; i++) {
        std:: cin >> userList[i];
    }
goBack:
    std:: cout << "Search: ";
    std:: cin >> searchValue;
    inIndex = linearSearch(userList, elementNumber, searchValue);
    if (inIndex != -1) {
        std:: cout << "Using Linear Search: " << searchValue << " found at " << inIndex+1 << "th Position." << std:: endl;
    }
    else {
        std:: cout << "Using Linear Search: " << searchValue << " not found on the List." << std:: endl;
    }
    if (!isSorted) {
        insertionSort(userList, elementNumber);
        std:: cout << "List after Sorting: ";
        printList(userList, elementNumber);
    }
    inIndex = binarySearch(userList, 0, elementNumber, searchValue);
    if (inIndex != -1) {
        std:: cout << "Using Binary Search: " << searchValue << " found at " << inIndex+1 << "th Position." << std:: endl;
    }
    else {
        std:: cout << "Using Binary Search: " << searchValue << " not found on the List." << std:: endl;
    }
chooseAgain:
    std:: cout << "1. Search Another\n2. Exit Searching\nSelect: ";
    std:: cin >> userChoice;
    if (userChoice==1) goto goBack;
    else if (userChoice==2) return 0;
    else goto chooseAgain;
    return 0;
}