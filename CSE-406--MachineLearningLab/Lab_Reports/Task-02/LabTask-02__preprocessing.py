#: author: @shmVirus <sabbir.tuqcx@aleeas.com>
import numpy
import pandas
import os #: to get current directory

dataFrame = pandas.read_csv(os.getcwd()+"/train.csv") #: please keep data and this code in same directory
print(dataFrame.isnull().sum()) #: printing number of rows with null values for Each Columns
#: printing total number of rows with null values
print("Total Rows with NULL Values: " + str(dataFrame.isnull().any(axis = 1).sum()) + "\n")

processedData = dataFrame.drop("Cabin",axis=1) #: dropped cabin column as it has 687 missing values
print(str(processedData.isnull().sum()) + "\n") #: verifing missing Cabin values; as Cabin removed, no missing value for Cabin

processedData["Age"] = processedData['Age'].fillna(processedData['Age'].mean()) #: filling missing Age with mean of Age
print(str(processedData.isnull().sum()) + "\n") #: now no null values of Age

print(str(processedData.loc[processedData.isnull().any(axis=1)]) + "\n" ) #: printing missing rows
#: filling missing values with random choices from Embarked column
processedData['Embarked'] = processedData['Embarked'].fillna(numpy.random.choice(processedData['Embarked']))
print(str(processedData.isnull().sum()) + "\n") #: no missing values for Embarked as well
