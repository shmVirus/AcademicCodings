#include <iostream>

struct node {
    int data;
    node *link;
} *firstNode=NULL,*currentNode,*newNode;

void insertLast(int newData) {
    newNode = new node();
    newNode->data = newData;
    newNode->link = NULL;
    if (firstNode == NULL) {
        firstNode = newNode;
    }
    else {

        currentNode->link = newNode;
    }
    currentNode = newNode;
}

void insertFirst(int newData) {
    newNode = new node();
    newNode->data = newData;
    newNode->link = firstNode;
    firstNode = newNode;
}

void displayList() {
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
} 

int main() {
    int listSize, userData;
    std:: cout << "List Size: ";
    std:: cin >> listSize;
    for (int i=0; i<listSize; i++) {
        std:: cin >> userData;
        insertLast(userData);
    }
    displayList();
    std:: cout << "Beginning Size: ";
    std:: cin >> listSize;
    for (int i=0; i<listSize; i++) {
        std:: cin >> userData;
        insertFirst(userData);
    }
    displayList();
    
    return 0;
}