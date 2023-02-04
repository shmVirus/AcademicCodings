#include <iostream> 
char queueStorage[3];
int queueIndex = 3, frontIndex = -1, rearIndex = -1;

void enQueue(char temp) {
    if (rearIndex == queueIndex-1) printf("Overflow\n");
    else {
        if(frontIndex == -1) frontIndex = 0;
        queueStorage[++rearIndex] = temp;
    }
}
void deQueue() {
    if (/*frontIndex == -1 || */frontIndex == rearIndex+1) printf("Underflow\n");
    else {
        if (frontIndex == rearIndex+1) {
            frontIndex = -1;
            rearIndex = -1;
        }
        else printf("%c\n", queueStorage[frontIndex++]);
    }
}
void printQueue() {
    for (int i=0; i<queueIndex; i++) {
        printf("%c\n", queueStorage[i]);
    }
}
int main() {
    enQueue('A');
    enQueue('B');
    enQueue('C');
    deQueue();
    deQueue();
    enQueue('D');
    enQueue('E');
    enQueue('F');
    deQueue();
    enQueue('G');
    enQueue('H');
    deQueue();
    printQueue();
    return 0;
}