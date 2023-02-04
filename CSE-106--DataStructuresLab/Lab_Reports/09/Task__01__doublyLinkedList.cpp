#include <iostream>

struct node {
    node *previousLink;
    int data;
    node *nextLink;
} *firstNode=NULL,*currentNode,*newNode;

void insertData(int newData) {
    newNode = new node();
    newNode->data = newData;
    if (firstNode == NULL) {
        newNode->nextLink = NULL;
        newNode->previousLink = NULL;
        firstNode = currentNode = newNode;
    }
    else {
        while(currentNode->nextLink != NULL) {
            currentNode = currentNode->nextLink;
        }
        newNode->previousLink = currentNode;
        currentNode->nextLink = newNode;
        newNode->nextLink = NULL;
        currentNode = newNode;
    }
}

void displayList() {
    if (firstNode == NULL) {
        std:: cout << "Linked List is Empty" << std:: endl;
        return;
    }
    std:: cout << "Reverse Order: ";
    while(currentNode != NULL) {
        std:: cout << currentNode->data;
        if (currentNode->previousLink != NULL) {
            std:: cout << " ";
        } else {
            std:: cout << std:: endl;
        }
        currentNode=currentNode->previousLink;
    }
}


int main() {
    int listSize, userData;
    std:: cout << "List Size: ";
    std:: cin >> listSize;
    for (int i=0; i<listSize; i++) {
        std:: cin >> userData;
        insertData(userData);
    }
    displayList();
    return 0;
}