#include <iostream>
#include <cstdlib>

struct node {
    int data;
    struct node *link;
} *firstNode,*currentNode,*newNode;

int main() {

    int elementNumber, newData;
    std:: cin >> elementNumber;
    newNode = (struct node*)malloc(sizeof(struct node));
    std:: cin >> newData;
    newNode->data = newData;
    newNode->link = NULL;
    firstNode = currentNode = newNode;

    for(int i=1; i<elementNumber; i++) {
        newNode = (struct node*)malloc(sizeof(struct node));
        newNode->link = NULL;
        std:: cin >> newData;
        newNode->data = newData;
        currentNode->link = newNode;
        currentNode = currentNode->link;
    }

    bool isSwapped;
    do {
        isSwapped = false;
        currentNode = firstNode;
        while (currentNode->link != NULL) {
            if (currentNode->data > currentNode->link->data) {
                int temp = currentNode->data;
                currentNode->data = currentNode->link->data;
                currentNode->link->data = temp;
                isSwapped = true;
            }
            currentNode = currentNode->link;
        }
    } while (isSwapped);

    currentNode = firstNode;
    while(currentNode != NULL) {
        std:: cout << currentNode->data;
        currentNode=currentNode->link;
        if (currentNode != NULL) {
            std:: cout << " ";
        } else {
            std:: cout << std:: endl;
        }
    }
    return 0;
}
