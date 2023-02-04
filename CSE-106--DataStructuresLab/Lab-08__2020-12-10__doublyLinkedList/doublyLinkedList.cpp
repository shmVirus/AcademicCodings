#include <iostream>

struct node {
    node *previousLink;
    int data;
    node *nextLink;
} *firstNode=NULL,*currentNode,*newNode;

void insertLast (int newData) {
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
    }
}

void insertFirst (int newData) {
    newNode = new node();
    newNode->data = newData;
    newNode->nextLink = firstNode;
    newNode->previousLink = newNode;
    firstNode = newNode;
}

void displayList() {
    currentNode = firstNode;
    if (firstNode == NULL) {
        std:: cout << "Linked List is Empty" << std:: endl;
    } 
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



void takeData() {
    int userData;
    std:: cout << "Enter Integer Data: ";
    std:: cin >> userData;
    insertLast(userData);
}

int main() {
    int listSize;
    std:: cout << "Enter List Size: ";
    std:: cin >> listSize;
    for (int i=0; i<listSize; i++) {
        takeData();
    }
    insertFirst(5);
    insertFirst(10);


    displayList();
    
    return 0;
}