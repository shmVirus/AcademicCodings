#include<stdio.h>
struct student {
    int id;
    char name[20];
    char dept[5];
    float cgpa;
} ob[100];
int main(void) {
    int i,n;
    scanf("%d", &n);
    for(i=0; i<n; i++) {
        scanf("%d %s %s %f", &ob[i].id, &ob[i].name, &ob[i].dept, &ob[i].cgpa);
    }
    printf("ID\tName\tDept.\tCGPA\n");
    for(i=0; i<n; i++) {
        printf("%d\t%s\t%s\t%.2f\n", ob[i].id, ob[i].name, ob[i].dept, ob[i].cgpa);
    }
    return 0;
}
