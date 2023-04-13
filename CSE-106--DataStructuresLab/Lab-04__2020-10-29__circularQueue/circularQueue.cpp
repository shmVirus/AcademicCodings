#include <iostream> 
char queueStorage[3];
int queueIndex = 3, frontIndex = -1, rearIndex = -1;

void enQueue(char temp) {
    if (frontIndex==0 && rearIndex==queueIndex-1 || frontIndex==rearIndex+1) {
        printf("Overflow\n");
    }
    else {
        if (frontIndex == -1) {
            frontIndex = 0;
            rearIndex = 0;
        }
        else if (rearIndex==queueIndex-1) {
            rearIndex = 0;
        }
        else {
            rearIndex++;
        }
        queueStorage[rearIndex] = temp;
    }
}

void deQueue() {
    if (frontIndex == -1) {
        printf("Underflow\n");
    }
    else {
        if (frontIndex == rearIndex) {
            printf("%c\n", queueStorage[frontIndex]);
            frontIndex = -1;
            rearIndex = -1;
        }
        else if (frontIndex==queueIndex-1) {
            printf("%c\n", queueStorage[frontIndex]);
            frontIndex = 0;
        }
        else {
            printf("%c\n", queueStorage[frontIndex++]);
        }
    }
}

int main() {
    enQueue('A');
    enQueue('B');
    deQueue();
    deQueue();
    deQueue();
    enQueue('C');
    enQueue('D');
    deQueue();
    enQueue('E');
    enQueue('F');
    enQueue('G');
    deQueue();
    deQueue();
    return 0;
}