#include <iostream>
#include <cstdlib>

struct node {
    int data;
    struct node *link;
} *firstNode,*currentNode,*newNode, *previousNode;

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

    currentNode = firstNode;
    previousNode = NULL;
    while(currentNode != NULL) {
        newNode = currentNode->link;
        currentNode->link = previousNode;
        previousNode = currentNode;
        currentNode = newNode;
    }
    firstNode = previousNode;

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
