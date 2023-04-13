#include <stdio.h>
struct student
{
     int id;
     char name[20];
     char dept[5];
     float cgpa;
} ob[100];
int main(void)
{
     int i, j, n, s;
     FILE *Pi = freopen("input.txt", "r", stdin);
     scanf("%d", &n);
     for (i = 0; i < n; i++)
     {
          scanf("%d %s %s %f", &ob[i].id, ob[i].name, ob[i].dept, &ob[i].cgpa);
     }
     printf("ID\tName\tDept.\tCGPA\n");
     for (i = 0; i < n; i++)
     {
          printf("%d\t%s\t%s\t%.2f\n", ob[i].id, ob[i].name, ob[i].dept, ob[i].cgpa);
     }
     // printf("Enter ID to search student\n");
     scanf("%d", &s);
     for (j = 0; j <= i; j++)
     {
          if (s == ob[j].id)
          {
               printf("ID\tName\tDept.\tCGPA\n");
               printf("%d\t%s\t%s\t%.2f\n", ob[j].id, ob[j].name, ob[j].dept, ob[j].cgpa);
          }
     }
     return 0;
}
