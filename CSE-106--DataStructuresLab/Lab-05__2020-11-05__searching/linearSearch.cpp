#include <iostream>
int main() {
    int userList[100], searchValue, inIndex, arraySize;
    bool isFound = false;
    printf("Size: ");
    scanf("%d", &arraySize);
    for (int i=0; i<arraySize; i++) {
        scanf("%d", &userList[i]);
    }
    printf("Search: ");
    scanf("%d", &searchValue);
    for (int i=0; i<arraySize; i++) {
        if (userList[i]==searchValue) {
            isFound = true;
            inIndex = i;
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