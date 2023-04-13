# Importing the libraries
import pandas as pd
from matplotlib import pyplot as plt
import numpy as np
#matplotlib inline
#Load the data
df = pd.read_csv("customer_churn.csv")
df.sample(5)

#First of all, drop customerID column as it is of no use
df.drop('customerID',axis='columns',inplace=True)
df.dtypes

#Quick glance at above makes me realize that TotalCharges should be float but it is an object. Let's check what's going on with this column
df.TotalCharges.values

#It is string. Lets convert it to numbers, some values seems to be not numbers but blank string. Let's find out such rows
pd.to_numeric(df.TotalCharges,errors='coerce').isnull()
df[pd.to_numeric(df.TotalCharges,errors='coerce').isnull()]
df.shape
df.iloc[488].TotalCharges
df[df.TotalCharges!=' '].shape

#Remove rows with space in TotalCharges
df1 = df[df.TotalCharges!=' ']
df1.shape
df1.dtypes
df1.TotalCharges = pd.to_numeric(df1.TotalCharges)
df1.TotalCharges.values
df1[df1.Churn=='No']

#Data Visualization
tenure_churn_no = df1[df1.Churn=='No'].tenure
tenure_churn_yes = df1[df1.Churn=='Yes'].tenure

plt.xlabel("tenure")
plt.ylabel("Number Of Customers")
plt.title("Customer Churn Prediction Visualiztion")

blood_sugar_men = [113, 85, 90, 150, 149, 88, 93, 115, 135, 80, 77, 82, 129]
blood_sugar_women = [67, 98, 89, 120, 133, 150, 84, 69, 89, 79, 120, 112, 100]

plt.hist([tenure_churn_yes, tenure_churn_no], rwidth=0.95, color=['green','red'],label=['Churn=Yes','Churn=No'])
plt.legend()

mc_churn_no = df1[df1.Churn=='No'].MonthlyCharges
mc_churn_yes = df1[df1.Churn=='Yes'].MonthlyCharges

plt.xlabel("Monthly Charges")
plt.ylabel("Number Of Customers")
plt.title("Customer Churn Prediction Visualiztion")

blood_sugar_men = [113, 85, 90, 150, 149, 88, 93, 115, 135, 80, 77, 82, 129]
blood_sugar_women = [67, 98, 89, 120, 133, 150, 84, 69, 89, 79, 120, 112, 100]

plt.hist([mc_churn_yes, mc_churn_no], rwidth=0.95, color=['green','red'],label=['Churn=Yes','Churn=No'])
plt.legend()


#Many of the columns are yes, no etc. Let's print unique values in object columns to see data values
def print_unique_col_values(df):
    for column in df:
        if df[column].dtypes=='object':
            print(f'{column}: {df[column].unique()}')
print_unique_col_values(df1)

#Some of the columns have no internet service or no phone service, that can be replaced with a simple No
df1.replace('No internet service','No',inplace=True)
df1.replace('No phone service','No',inplace=True)
print_unique_col_values(df1)

#Convert Yes and No to 1 or 0
yes_no_columns = ['Partner','Dependents','PhoneService','MultipleLines','OnlineSecurity','OnlineBackup', 'DeviceProtection','TechSupport','StreamingTV',' StreamingMovies','PaperlessBilling','Churn']

for col in yes_no_columns:
    df1[col].replace({'Yes': 1,'No': 0},inplace=True)
for col in df1:
    print(f'{col}: {df1[col].unique()}')

df1['gender'].replace({'Female':1,'Male':0},inplace=True)
df1.gender.unique()
'''
#Convert Yes and No to 1 or 0
yes_no_columns = ['Partner','Dependents','PhoneService','MultipleLines','OnlineSecurity','OnlineBackup','DeviceProtection','TechSupport','StreamingTV','StreamingMovies','PaperlessBilling','Churn']

for col in yes_no_columns:
    df1[col].replace({'Yes': 1,'No': 0},inplace=True)
for col in df1:
    print(f'{col}: {df1[col].unique()}')

df1['gender'].replace({'Female':1,'Male':0},inplace=True)
df1.gender.unique()
'''
#One hot encoding for categorical columns
df2 = pd.get_dummies(data=df1, columns=['InternetService','Contract','PaymentMethod'])
df2.columns
df2.sample(5)
df2.dtypes

cols_to_scale = ['tenure','MonthlyCharges','TotalCharges']

from sklearn.preprocessing import MinMaxScaler
scaler = MinMaxScaler()
df2[cols_to_scale] = scaler.fit_transform(df2[cols_to_scale])

for col in df2:
    print(f'{col}: {df2[col].unique()}')
#Train test split
X = df2.drop('Churn',axis='columns')
y = df2['Churn']

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X,y,test_size=0.2,random_state=5)
X_train.shape
X_test.shape
X_train[:10]
len(X_train.columns)

#Build a model (ANN) in tensorflow/keras
import tensorflow as tf
from tensorflow import keras

model = keras.Sequential([
    keras.layers.Dense(26, input_shape=(26,), activation='relu'),
    keras.layers.Dense(15, activation='relu'),
    keras.layers.Dense(1, activation='sigmoid')
])

# opt = keras.optimizers.Adam(learning_rate=0.01)
model.compile(optimizer='adam',loss='binary_crossentropy',metrics=['accuracy'])
model.fit(X_train, y_train, epochs=100)
model.evaluate(X_test, y_test)
yp = model.predict(X_test)

yp[:5]
y_pred = []

for element in yp:
    if element > 0.5:
        y_pred.append(1)
    else:
        y_pred.append(0)

y_pred[:10]
y_test[:10]

from sklearn.metrics import confusion_matrix , classification_report
print(classification_report(y_test,y_pred))

import seaborn as sn
cm = tf.math.confusion_matrix(labels=y_test,predictions=y_pred)

plt.figure(figsize = (10,7))
sn.heatmap(cm, annot=True, fmt='d')
plt.xlabel('Predicted')
plt.ylabel('Truth')

y_test.shape
#Accuracy
round((862+229)/(862+229+137+179),2)

#Precision for 0 class. i.e. Precision for customers who did not churn
round(862/(862+179),2)

#Precision for 1 class. i.e. Precision for customers who actually churned
round(229/(229+137),2)

#Recall for 0 class
round(862/(862+137),2)
round(229/(229+179),2)
