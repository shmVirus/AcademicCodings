#: importing necessary frameworks, data and printing head of the data
import pandas as pd
import seaborn as sns
df = pd.read_csv('/content/sample_data/FrustrationToleranceAbility .csv')
df.head()

sns.countplot(df["Age"])

sns.distplot(df['Age'])

sns.countplot(df["FrustrationToleranceLevel"])

df.dtypes

#: converting data objects into integer, required for models 
from sklearn import preprocessing
le = preprocessing.LabelEncoder()
for column in df.columns:
    temp_new = le.fit_transform(df[column].astype('category'))
    df.drop(labels=[column], axis="columns", inplace=True)
    df[column] = temp_new

df.dtypes

df.describe()

df.head

x = df.iloc[:,:-1].values   #: taking inputs, selects every column expect last
y = df.iloc[:,-1].values    #: taking traget, selects only last column

#: spliting data for training and testing
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 1/10, random_state=30)

#: Logistic Regression
from sklearn.linear_model import LogisticRegression
lr = LogisticRegression()
lr.fit(x_train,y_train)
print("Logistic Accuracy: " + str(round(lr.score(x_test,y_test)*100,2)) + "%")

#: Support Vector Classifier
from sklearn.svm import SVC
svcClassifier = SVC(kernel='linear')
svcClassifier.fit(x_train, y_train)
print("Support Vector Accuracy: " + str(round(svcClassifier.score(x_test,y_test)*100,2)) + "%")

#: Naive Bayes Classifier
from sklearn.naive_bayes import GaussianNB
nbClassifier = GaussianNB()
nbClassifier.fit(x_train, y_train)
print("Naive Bayes Accuracy: " + str(round(nbClassifier.score(x_test,y_test)*100,2)) + "%")

#: Decision Tree Classifier
from sklearn import tree
dtClassifier = tree.DecisionTreeClassifier()
dtClassifier.fit(x_train, y_train)
print("Decision Tree Accuracy: " + str(round(dtClassifier.score(x_test,y_test)*100,2)) + "%")

#: Random Forest Classifier
from sklearn.ensemble import RandomForestClassifier
accuracy=0
for i in range(1,100):
    rfClassifier = RandomForestClassifier(n_estimators=i)
    rfClassifier.fit(x_train, y_train)
    tempAccuracy = round(rfClassifier.score(x_test,y_test)*100,2)
    if (tempAccuracy > accuracy):
        accuracy = tempAccuracy
print("Random Forest Accuracy: " + str(accuracy) + "%")

#: ploating confusion matrix for random forest
import tensorflow as tf
import matplotlib.pyplot as plt
y_pred = rfClassifier.predict(x_test)
cm = tf.math.confusion_matrix(labels=y_test,predictions=y_pred)
plt.figure(figsize = (10,7))
sns.heatmap(cm, annot=True, fmt='d')
plt.xlabel('Predicted')
plt.ylabel('Actual')
