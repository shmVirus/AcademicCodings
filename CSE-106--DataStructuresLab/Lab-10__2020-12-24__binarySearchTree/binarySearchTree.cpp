#include <iostream>

struct tree {
    tree *leftLink;
    int data;
    tree *rightLink;
} *firstTree=NULL,*currentTree,*newTree;

void insertData (int newData) {
    newTree = new tree();
    newTree->data = newData;
    newTree->leftLink = NULL;
    newTree->rightLink = NULL;
    if (newData <= currentTree->data) {
        if (currentTree->leftLink == NULL) {
            currentTree->leftLink = newTree;
        }
        else {
            currentTree = currentTree->leftLink;
            insertData(newData);
        }
    }
    else {
        if (currentTree->rightLink == NULL) {
            currentTree->rightLink = newTree;
        }
        else {
            currentTree = currentTree->rightLink;
            insertData(newData);
        }
    }
}

void preOrder(struct tree *tempTree) {
    if (firstTree == NULL) {
        std:: cout << "The Tree didn't Grow." << std:: endl;
        return;
    }
    if (tempTree == NULL) return;
    std:: cout << tempTree->data << " ";
    preOrder(tempTree->leftLink);
    preOrder(tempTree->rightLink);
}

void inOrder(struct tree *tempTree) {
    if (firstTree == NULL) {
        std:: cout << "The Tree didn't Grow." << std:: endl;
        return;
    }
    if (tempTree == NULL) return;
    inOrder(tempTree->leftLink);
    std:: cout << tempTree->data << " ";
    inOrder(tempTree->rightLink);
}

void postOrder(struct tree *tempTree) {
    if (firstTree == NULL) {
        std:: cout << "The Tree didn't Grow." << std:: endl;
        return;
    }
    if (tempTree == NULL) return;
    postOrder(tempTree->leftLink);
    postOrder(tempTree->rightLink);
    std:: cout << tempTree->data << " ";
}

int main() {

    int elementNumber, newData;
    std:: cout << "Tree Size: ";
    std:: cin >> elementNumber;

    if (elementNumber>0) {
        newTree = new tree();
        std:: cout << "Data: ";
        std:: cin >> newData;
        newTree->data = newData;
        newTree->leftLink = NULL;
        newTree->rightLink = NULL;
        firstTree = currentTree = newTree;

        for(int i=1; i<elementNumber; i++) {
            std:: cout << "Data: ";
            std:: cin >> newData;
            insertData(newData);
        }
    }

    std:: cout << "Pre-Order: ";
    preOrder(firstTree);
    std:: cout << std:: endl;

    std:: cout << "In-Order: ";
    inOrder(firstTree);
    std:: cout << std:: endl;

    std:: cout << "Post-Order: ";
    postOrder(firstTree);
    std:: cout << std:: endl;

    return 0;
}