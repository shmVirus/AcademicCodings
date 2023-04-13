#include <pthread.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int rows, columns;
int option;
int matrixA[MAX][MAX], matrixB[MAX][MAX], result[MAX][MAX];

void* calculateResult(void* arg) {
    int threadNumber = (intptr_t)arg;

    if (option == 1 || option == 2) {
        for (int i = threadNumber * rows * columns / 3; i < (threadNumber + 1) * rows * columns / 3; i++) { // Each thread computes 1/3rd of matrix subtraction
            //sleep(2);
            //printf("thread %d: ", threadNumber);
            for (int j = 0; j < columns; j++) {
                if (option == 1)      result[i][j] = matrixA[i][j] + matrixB[i][j];
                else if (option == 2) result[i][j] = matrixA[i][j] - matrixB[i][j];
                //printf("%d\t", result[i][j]);
            }
            //printf("\n");
            //printf("\n");
        }
    }
    else if (option == 3) {
        for (int i = threadNumber * rows; i < threadNumber + rows; i++) {
            //sleep(2);
            //printf("thread %d: ", threadNumber);
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < rows; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
                //printf("%d\t", result[i][j]);
            }
            //printf("\n");
            //printf("\n");
        }
    }
}

void printMatrix(int matrix[MAX][MAX]) {
    for (int i = 0; i < rows; i++) {
        printf("\t");
        for (int j = 0; j < columns; j++) {
            printf("%d ", matrix[i][j]);
            if (j + 1 == columns)
                printf("\n");  // print newline when row ends
            else
                printf("\t");  // print tab while row is not finished yet
        }
    }
}

int takeNumber() {
    int input;
    scanf("%d", &input);
    return input;
}

int main(void) {  // Driver Code
    printf("Threads: ");
    int threads = takeNumber();    // total threads for calculation
    pthread_t thread[threads];

    printf("Rows: ");
    rows = takeNumber();
    printf("Columns: ");
    columns = takeNumber();

    printf("\nHow do you want to fill the matrices?\nOptions:\n\t1. Auto Generated\n\t2. Manually Input\n\t3. Exit\nSelect: ");
    option = takeNumber();

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (option == 1) {  // Generating random values in matrixA and matrixB
                matrixA[i][j] = rand() % 10;
                matrixB[i][j] = rand() % 10;
            } else if (option == 2) {  // Taking inputs from user for matrixA and matrixB
                printf("[%d][%d] of Matrix A: ", i + 1, j + 1);
                matrixA[i][j] = takeNumber();
                printf("[%d][%d] of Matrix B: ", i + 1, j + 1);
                matrixB[i][j] = takeNumber();
            } else if (option == 3) {
                return 0;
            }
        }
    }

    printf("\nMatrix A:\n");  // Displaying matrixA
    printMatrix(matrixA);
    printf("\nMatrix B:\n");  // Displaying matrixB
    printMatrix(matrixB);

    printf("\nWhat do you want to calculate?\nOptions:\n\t1. Addition\n\t2. Subtraction\n\t3. Multiplication\n\t4. Exit\nSelect: ");
    option = takeNumber();
    if (option == 4) return 0;

    for (int i = 0; i < threads; i++) {                                          // Creating threads equal to core size and compute matrix row
        pthread_create(&thread[i], NULL, &calculateResult, (void*)(intptr_t)i);  // void size 64 bits, so converting to int
    }

    for (int i = 0; i < threads; i++) {  // Waiting for join threads after compute
        pthread_join(thread[i], NULL);
    }

    if (option == 1) printf("\nAddition: \n");
    else if (option == 2) printf("\nSubtraction: \n");
    else if (option == 3) printf("\nMultiplication: \n");
    printMatrix(result);
    
    return 0;
}