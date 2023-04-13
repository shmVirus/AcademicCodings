import pandas as pd
dt= pd.read_csv('iris.csv')

x= dt.iloc[:,[0,1,2,3]].values
y= dt.iloc[:,-1].values
from sklearn.model_selection import train_test_split
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=5)
from sklearn.svm import SVC
clf= SVC( kernel='linear' )
clf.fit(x_train,y_train)

pr=clf.predict(x_test)
#print(pr)
#print(x_test)
count=0
match=0
for i in range(0,len(pr)):
    if pr[i]==y_test[i]:
        match=match+1
    #else:
        #print(pr[i]+" "+ y_test[i])
    count=count+1

print(f"Number of Test Case: {count}")
print(f"Number of Correctly Identified Class: {match}")
print(f"Accuracy ={match/count*100}%")
#print(clf.predict([[4.9,2.4,3.3,1]]))
from sklearn.metrics import confusion_matrix
cm=confusion_matrix(y_test,pr)
from sklearn.metrics import confusion_matrix, ConfusionMatrixDisplay
disp = ConfusionMatrixDisplay(confusion_matrix=cm,display_labels=clf.classes_)
disp.plot()
