#include <iostream>

struct node {
    node *nextLink;
    std:: string studentName;
    int studentID;
    float studentAttendance;
    float studentPresentation;
    float studentAssignment;
    float studentCTOne;
    float studentCTTwo;
    float studentCTThree;
    float studentMid;
    float studentFinal;
    float studentTotalMarks;
    char *studentGPA;
} *firstNode=NULL,*currentNode,*traverseNode,*newNode,*tempNode;

float findCTAverage(float ctOne, float ctTwo, float ctThree) {
    if (ctOne>=ctTwo && ctOne>=ctThree && ctTwo>=ctThree) {
        return (ctOne+ctTwo)/2;
    } else if (ctOne>=ctTwo && ctOne>=ctThree && ctThree>=ctTwo) {
        return (ctOne+ctThree)/2;
    } else if (ctTwo>=ctOne && ctTwo>=ctThree && ctOne>=ctThree) {
        return (ctTwo+ctOne)/2;
    } else if (ctTwo>=ctOne && ctTwo>=ctThree && ctThree>=ctOne) {
        return (ctTwo+ctThree)/2;
    } else if (ctThree>=ctOne && ctThree>=ctTwo && ctOne>=ctTwo) {
        return (ctThree+ctOne)/2;
    } else if (ctThree>=ctOne && ctThree>=ctTwo && ctTwo>=ctOne) {
        return (ctThree+ctTwo)/2;
    }
}

char* findGrade(int totalMarks) {
    switch (totalMarks / 10) {
        case 10:
            return "A+";
        case 9:
            return "A+";
        case 8:
            return "A+";
        case 7:
            if (totalMarks >= 75) return "A";
            else return "A-";
        case 6:
            if (totalMarks >= 65) return "B+";
            else return "B";
        case 5:
            if (totalMarks >= 55) return "B-";
            else return "C+";
        case 4:
            if (totalMarks >= 45) return "C";
            else return "D";
        default: return "F";
    }
}

float findTotalMarks(struct node *tempNode) {
    tempNode->studentTotalMarks = tempNode->studentAttendance+tempNode->studentPresentation+tempNode->studentAssignment+findCTAverage(tempNode->studentCTOne, tempNode->studentCTTwo, tempNode->studentCTThree)+tempNode->studentMid+tempNode->studentFinal;
    return tempNode->studentTotalMarks;
}

void printParticular(struct node *tempNode) {
    std:: cout << tempNode->studentID << "-ID " << tempNode->studentName << "'s Marks: "<< std:: endl;
    std:: cout << "\tAttendance: " << tempNode->studentAttendance << std:: endl;
    std:: cout << "\tPresentation: " << tempNode->studentPresentation << std:: endl;
    std:: cout << "\tAssignment: " << tempNode->studentAssignment << std:: endl;
    std:: cout << "\tCT-1: " << tempNode->studentCTOne << std:: endl;
    std:: cout << "\tCT-2: " << tempNode->studentCTTwo << std:: endl;
    std:: cout << "\tCT-3: " << tempNode->studentCTThree << std:: endl;
    std:: cout << "\tMid: " << tempNode->studentMid << std:: endl;
    std:: cout << "\tFinal: " <<  tempNode->studentFinal << std:: endl;
    std:: cout << "\tTotal Marks: " << tempNode->studentTotalMarks << std:: endl;
    std:: cout << "\tGPA: " << tempNode->studentGPA << std:: endl;
}

void displayList() {
    traverseNode = firstNode;
        std:: cout << "List: " << std:: endl;
        printf("\tID\t\tName\t\tMarks\t\tGrade\n");
    while(traverseNode != NULL) {
        printf("\t%d\t\t", traverseNode->studentID);
        std:: cout << traverseNode->studentName;
        printf("\t\t");
        printf("%.0f\t\t", traverseNode->studentTotalMarks);
        std:: cout << traverseNode->studentGPA << std:: endl;
        traverseNode=traverseNode->nextLink;
    }
}

void swapNodes() {
    int tempStudentID = traverseNode->studentID;
    std:: string tempStudentName = traverseNode->studentName;
    float tempStudentAttendance = traverseNode->studentAttendance;
    float tempStudentPresentation = traverseNode->studentPresentation;
    float tempStudentAssignment = traverseNode->studentAssignment;
    float tempStudentCTOne = traverseNode->studentCTOne;
    float tempStudentCTTwo = traverseNode->studentCTTwo;
    float tempStudentCTThree = traverseNode->studentCTThree;
    float tempStudentMid = traverseNode->studentMid;
    float tempStudentFinal = traverseNode->studentFinal;
    float tempStudentTotalMarks = traverseNode->studentTotalMarks;
    char *tempStudentGPA = traverseNode->studentGPA;
    traverseNode->studentID = tempNode->studentID;
    traverseNode->studentName = tempNode->studentName;
    traverseNode->studentAttendance = tempNode->studentAttendance;
    traverseNode->studentPresentation = tempNode->studentPresentation;
    traverseNode->studentAssignment = tempNode->studentAssignment;
    traverseNode->studentCTOne = tempNode->studentCTOne;
    traverseNode->studentCTTwo = tempNode->studentCTTwo;
    traverseNode->studentCTThree = tempNode->studentCTThree;
    traverseNode->studentMid = tempNode->studentMid;
    traverseNode->studentFinal = tempNode->studentFinal;
    traverseNode->studentTotalMarks = tempNode->studentTotalMarks;
    traverseNode->studentGPA = tempNode->studentGPA;
    tempNode->studentID = tempStudentID;
    tempNode->studentName = tempStudentName;
    tempNode->studentAttendance = tempStudentAttendance;
    tempNode->studentPresentation = tempStudentPresentation;
    tempNode->studentAssignment = tempStudentAssignment;
    tempNode->studentCTOne = tempStudentCTOne;
    tempNode->studentCTTwo = tempStudentCTTwo;
    tempNode->studentCTThree = tempStudentCTThree;
    tempNode->studentMid = tempStudentMid;
    tempNode->studentFinal = tempStudentFinal;
    tempNode->studentTotalMarks = tempStudentTotalMarks;
    tempNode->studentGPA = tempStudentGPA;
}
void reverseList() {
    traverseNode = firstNode;
    struct node *previousNode = NULL;
    while(traverseNode != NULL) {
        tempNode = traverseNode->nextLink;
        traverseNode->nextLink = previousNode;
        previousNode = traverseNode;
        traverseNode = tempNode;
    }
    firstNode = previousNode;
}
void sortList(int sort) {
    traverseNode = firstNode;
    tempNode = traverseNode->nextLink;
    while (traverseNode->nextLink != NULL) {
        while (tempNode != NULL) {
            if (sort == 1 && traverseNode->studentID > tempNode->studentID) {
                swapNodes();
            } else if (sort == 2 && traverseNode->studentName > tempNode->studentName) {
                swapNodes();
            } else if (sort == 3 && traverseNode->studentTotalMarks > tempNode->studentTotalMarks) {
                swapNodes();
            }
            tempNode = tempNode->nextLink;
        }
        tempNode = traverseNode->nextLink;
        traverseNode = traverseNode->nextLink;
    }
}

void insertData () {
    newNode = new node();
goBack:
    std:: cout << "ID: ";
    std:: cin >> newNode->studentID;
    if (firstNode != NULL) {
        tempNode = firstNode;
        while (tempNode != NULL) {
            if (tempNode->studentID == newNode->studentID) {
                std:: cout << "This ID is already inserted,\ntry with different ";
                goto goBack; 
            }
            tempNode = tempNode->nextLink;
        }
    }
    std:: cout << "Name: ";
    std:: cin >> newNode->studentName;
    std:: cout << "Attendance: ";
    std:: cin >> newNode->studentAttendance;
    std:: cout << "Presentation: ";
    std:: cin >> newNode->studentPresentation;
    std:: cout << "Assignment: ";
    std:: cin >> newNode->studentAssignment;
    std:: cout << "CT-1: ";
    std:: cin >> newNode->studentCTOne;
    std:: cout << "CT-2: ";
    std:: cin >> newNode->studentCTTwo;
    std:: cout << "CT-3: ";
    std:: cin >> newNode->studentCTThree;
    std:: cout << "Mid: ";
    std:: cin >> newNode->studentMid;
    std:: cout << "Final: ";
    std:: cin >> newNode->studentFinal;
    newNode->studentTotalMarks = findTotalMarks(newNode);
    newNode->studentGPA = findGrade((int)newNode->studentTotalMarks);
    if (firstNode == NULL) {
        firstNode = newNode;
    } else {

        currentNode->nextLink = newNode;
    }
    currentNode = newNode;
}

void updateData() {
    traverseNode = firstNode;
    if(traverseNode == NULL) {
        std:: cout << "List is Empty; make a List first." << std:: endl;
        return;
    }
    int searchID;
goBack:
    bool isFound=false;
    bool isDone=false;
    traverseNode = firstNode;
    std:: cout << "Enter Student ID to Update: ";
    std:: cin >> searchID;
    while (traverseNode != NULL) {
        if (traverseNode->studentID==searchID) {
            isFound = true;
            break;
        }
        traverseNode = traverseNode->nextLink;
    }
    if(!isFound) {
        std:: cout << "Student ID not Found, try again." << std:: endl;
        goto goBack;
    }
    else {
        std:: cout << "Student Found, ";
        while(!isDone) {
            std:: cout << "Update Menu: " << std:: endl;
            std:: cout << "\t0. See " << traverseNode->studentID << " ID's Marks" << std:: endl;
            std:: cout << "\t1. Update Name" << std:: endl;
            std:: cout << "\t2. Update Attendance" << std:: endl;
            std:: cout << "\t3. Update Presentation" << std:: endl;
            std:: cout << "\t4. Update Assignment" << std:: endl;
            std:: cout << "\t5. Update CT-1" << std:: endl;
            std:: cout << "\t6. Update CT-2" << std:: endl;
            std:: cout << "\t7. Update CT-3" << std:: endl;
            std:: cout << "\t8. Update Mid" << std:: endl;
            std:: cout << "\t9. Update Final" << std:: endl;
            std:: cout << "\t10. Update another Student Data" << std:: endl;
            std:: cout << "\t11. Exit Updating " << traverseNode->studentID << std:: endl << std:: endl;
            int userChoice;
            std:: cout << "Select: ";
            std:: cin >> userChoice;
            switch (userChoice) {
                case 0:
                    printParticular(traverseNode);
                    break;
                case 1:
                    std:: cout << "Name: ";
                    std:: cin >> traverseNode->studentName;
                    break;
                case 2:
                    std:: cout << "Attendance: ";
                    std:: cin >> traverseNode->studentAttendance;
                    break;
                case 3:
                    std:: cout << "Presentation: ";
                    std:: cin >> traverseNode->studentPresentation;
                    break;
                case 4:
                    std:: cout << "Assignment: ";
                    std:: cin >> traverseNode->studentAssignment;
                    break;
                case 5:
                    std:: cout << "CT-1: ";
                    std:: cin >> traverseNode->studentCTOne;
                    break;
                case 6:
                    std:: cout << "CT-2: ";
                    std:: cin >> traverseNode->studentCTTwo;
                    break;
                case 7:
                    std:: cout << "CT-3: ";
                    std:: cin >> traverseNode->studentCTThree;
                    break;
                case 8:
                    std:: cout << "Mid: ";
                    std:: cin >> traverseNode->studentMid;
                    break;
                case 9:
                    std:: cout << "Final: ";
                    std:: cin >> traverseNode->studentFinal;
                    break;
                case 10:
                    goto goBack;
                    break;
                case 11:
                    isDone = true;
                    break;
            }
            traverseNode->studentTotalMarks = findTotalMarks(traverseNode);
            traverseNode->studentGPA = findGrade((int)traverseNode->studentTotalMarks);
            if (isDone) break;
        }
    }
}

void listMaker() {
    int userChoice, sortOrder;
    traverseNode = firstNode;
    if (traverseNode == NULL) {
        std:: cout << "List is Empty; make a List first." << std:: endl;
        return;
    }
    while (true) {
        std:: cout << "Display Menu: " << std:: endl;
        std:: cout << "\t1. Display by ID\n\t2. Display by Name\n\t3. Display by Marks\n\t4. Exit Printing\n";
        std:: cout << "Select: ";
        std:: cin >> userChoice;
        if (userChoice==4) return;
        std:: cout << "Display Order: " << std:: endl;
        std:: cout << "\t1. By Ascending Order\n\t2. By Descending Order\n";
        std:: cout << "Select: ";
        std:: cin >> sortOrder;
        if (sortOrder == 1) {
            sortList(userChoice);
        } else if (sortOrder == 2) {
            sortList(userChoice);
            reverseList();
        }
        displayList();
    }
}

void deleteData() {
    if(firstNode == NULL) {
        std:: cout << "List is Empty; make a List first." << std:: endl;
        return;
    }
    int searchID;
goBack:
    bool isFound=false;
    bool isDone=false;
    traverseNode = firstNode;
    std:: cout << "Enter Student ID to Delete: ";
    std:: cin >> searchID;
    while (traverseNode != NULL) {
        if (traverseNode->studentID==searchID) {
            isFound = true;
            break;
        }
        tempNode = traverseNode;
        traverseNode = traverseNode->nextLink;
    }
    if (!isFound) {
        std:: cout << "Student ID not Found, try again." << std:: endl;
        goto goBack;
    }
    else {
        while (!isDone) {
            if (traverseNode->studentID == firstNode->studentID) {
                firstNode = traverseNode->nextLink;
            } else {
                tempNode->nextLink = traverseNode->nextLink;
                if (tempNode->nextLink==NULL) currentNode = tempNode;
            }
            free(traverseNode);
            std:: cout << "Student data Deleted" << std:: endl;
            std:: cout << "\t1. Delete Another" << std:: endl;
            std:: cout << "\t2. Exit Deleting" << std:: endl;
            int userChoice;
            std:: cout << "Select: ";
            std:: cin >> userChoice;
            switch (userChoice) {
                case 1:
                    goto goBack;
                    break;
                case 2:
                    isDone = true;
            }
            if (isDone) break;
        }
    }
}
void projectMenu() {
    int userChoice;
    while(true){
        std:: cout << "Menu: " << std:: endl;
        std:: cout << "\t1. Insert a Student Data\n\t2. Update a Student Data\n\t3. See Grade List\n\t4. Delete a Student Data\n\t5. Exit\n";
        std:: cout << "Select: ";
        std:: cin >> userChoice;
        switch (userChoice) {
            case 1:
                insertData();
                break;
            case 2:
                updateData();
                break;
            case 3:
                listMaker();
                break;
            case 4:
                deleteData();
                break;
            case 5:
                return;
        }
    }
}
int main() {
    getchar();
    std:: cout << "===============================================================" << std:: endl;
    std:: cout << "꧁        Welcome to Student Result Management System        ꧂" << std:: endl << std:: endl;
    std:: cout << "●▬▬▬▬▬▬▬▬▬▬▬▬▬▬๑۩  Code written by @shmVirus  ۩๑▬▬▬▬▬▬▬▬▬▬▬▬▬▬●" << std:: endl;
    std:: cout << "===============================================================" << std:: endl;
    projectMenu();
    return 0;
}