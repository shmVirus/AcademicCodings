#include <stdio.h>
char queueStorage[3];
int queueIndex = 3, frontIndex = 0, rearIndex = -1;

void enQueue(char temp) {
    if (rearIndex == queueIndex-1) {
        printf("Overflow\n");
    }
    else {
        if (frontIndex == -1) {
            frontIndex = 0;
        }
        queueStorage[++rearIndex] = temp;
    }
}
void deQueue() {
    if (/*frontIndex == -1 || */frontIndex == rearIndex+1) {
        printf("Underflow\n");
    }
    else {
        if (frontIndex == rearIndex+1) {
            frontIndex = -1;
            rearIndex = -1;
        }
        else {
            printf("%c\n", queueStorage[frontIndex++]);
        }
    }
}
int main() {
    enQueue('A');
    deQueue();
    deQueue();
    enQueue('B');
    enQueue('C');
    enQueue('D');
    deQueue();
    return 0;
}