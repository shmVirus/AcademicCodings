#include <iostream>
int main() {
    int userList[100], searchValue=5, inIndex, arraySize, upperIndex, lowerIndex, centerIndex;
    bool isFound = false;
    printf("Size: ");
    scanf("%d", &arraySize);
    for (int i=0; i<arraySize; i++) {
        scanf("%d", &userList[i]);
    }
    printf("Search: ");
    scanf("%d", &searchValue);
    upperIndex = arraySize-1;
    lowerIndex = 0;
    while (upperIndex >= lowerIndex) {
        centerIndex = (upperIndex + lowerIndex) / 2;
        if (userList[centerIndex] > searchValue) {
            upperIndex = centerIndex-1;
        } else if (userList[centerIndex] < searchValue) {
            lowerIndex = centerIndex+1;
        } else {
            isFound = true;
            inIndex = centerIndex;
            break;
        }
    }
    inIndex++;
    if(isFound) {
        printf("%d Found in %d Position\n", searchValue, inIndex);
    }
    else {
        printf("%d not Found on the List\n", searchValue);
    }
    return 0;
}