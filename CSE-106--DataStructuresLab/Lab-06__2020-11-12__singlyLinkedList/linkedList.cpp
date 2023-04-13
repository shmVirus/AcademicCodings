#include <iostream>

struct node {
    int data;
    node *link;
} *firstNode=NULL,*currentNode,*newNode;

void insertData (int newData) {
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

    insertData(10);
    insertData(20);
    insertData(30);
    insertData(40);
    insertData(50);

    displayList();
    
    return 0;
}