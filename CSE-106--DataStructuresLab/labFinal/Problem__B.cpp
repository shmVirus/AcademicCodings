#include <iostream>

struct node {
    node *previousLink;
    int data;
    node *nextLink;
} *firstNode=NULL,*currentNode,*newNode;

void insertFirst (int newData) {
    newNode = new node();
    newNode->data = newData;
    newNode->nextLink = firstNode;
    newNode->previousLink = newNode;
    firstNode = newNode;
}

void displayList() {
    if (firstNode == NULL) {
        std:: cout << "Linked List is Empty" << std:: endl;
        return;
    }
    currentNode = firstNode;
    while(currentNode != NULL) {
        std:: cout << currentNode->data;
        currentNode=currentNode->nextLink;
        if (currentNode != NULL) {
            std:: cout << " ";
        } else {
            std:: cout << std:: endl;
        }
    }
}

int main() {
    int listSize, newData;
    std:: cout << "Size: ";
    std:: cin >> listSize;
    for (int i=0; i<listSize; i++) {
        std:: cin >> newData;
        insertFirst(newData);
    }
    displayList();
    return 0;
}