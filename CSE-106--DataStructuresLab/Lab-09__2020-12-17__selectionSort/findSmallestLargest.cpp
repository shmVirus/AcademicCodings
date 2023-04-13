#include <iostream>
int main() {
    int arraySize;
    std:: cout << "Array Size: ";
    std:: cin >> arraySize;
    int userArray[arraySize];
    for (int i=0; i<arraySize; i++) {
        std:: cin >> userArray[i];
    }
    int smallestData = userArray[0];
    int largestData = userArray[0];
    for (int i=1; i<arraySize; i++) {
        if (userArray[i] < smallestData) {
            smallestData = userArray[i];
        }
        if (userArray[i] > largestData) {
            largestData = userArray[i];
        }
    }
    std:: cout << "Smallest Value: " << smallestData << std:: endl;
    std:: cout << "Largest Value: " << largestData << std:: endl;
    return 0;
}