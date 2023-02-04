#include <iostream>

struct node {
    int data;
    struct node *nextLink;
} *firstNode,*currentNode,*newNode, *previousNode;

void insertData (int newData) {
    newNode = new node();
    newNode->data = newData;
    newNode->nextLink = NULL;
    if (firstNode == NULL) {
        firstNode = newNode;
    }
    else {
        currentNode->nextLink = newNode;
    }
    currentNode = newNode;
}

void displayList() {
    if (firstNode == NULL) {
        std:: cout << "Linked List is Empty, make a list to Print." << std:: endl;
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

void reverseList() {
    if (firstNode == NULL) {
        //std:: cout << "Linked List is Empty, make a list to Reverse." << std:: endl;
        return;
    }
    currentNode = firstNode;
    previousNode = NULL;
    while(currentNode != NULL) {
        newNode = currentNode->nextLink;
        currentNode->nextLink = previousNode;
        previousNode = currentNode;
        currentNode = newNode;
    }
    firstNode = previousNode;
}

int main() {
    int listSize, newData;
    std:: cout << "Size: ";
    std:: cin >> listSize;
    for(int i=0; i<listSize; i++) {
        std:: cin >> newData;
        insertData(newData);
    }
    reverseList();
    displayList();
    return 0;
}