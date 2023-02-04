import numpy as np
import pandas as pd
import os
df = pd.read_csv(os.getcwd()+"/train.csv")
df

print(df.head())

df.drop("Name",axis=1,inplace=True)
df.drop("Ticket",axis=1,inplace=True)
df.drop("PassengerId",axis=1,inplace=True)
df.drop("Cabin",axis=1,inplace=True)
df.drop("Embarked",axis=1,inplace=True)
df.info()

print(df.isnull().sum())

updated_df = df
updated_df['Age']=updated_df['Age'].fillna(updated_df['Age'].mean())
updated_df.info()

updated_df = df.dropna(axis=1)
updated_df.info()

updated_df = df.dropna(axis=0)  # changed newdf to df from manual
y1 = updated_df['Survived']
updated_df.drop("Survived",axis=1,inplace=True)
updated_df.info()

#-------------------------

# Importing pandas and numpy libraries
import pandas as pd
import numpy as np

# Creating a dummy DataFrame of 15 numbers randomly ranging from 1-100 for age
df = pd.DataFrame({'Age': [42, 15, 67, 55, 1, 29, 75, 89, 4, 10, 15, 38, 22, 77]})

# Printing DataFrame Before sorting Continuous to Categories
# A column of name 'Label' is created in DataFrame
# Categorizing Age into 4 Categories
# Baby/Toddler: (0,3], 0 is excluded & 3 is included
# Child: (3,17], 3 is excluded & 17 is included
# Adult: (17,63], 17 is excluded & 63 is included
# Elderly: (63,99], 63 is excluded & 99 is included
df['Label'] = pd.cut(x=df['Age'], bins=[0, 3, 17, 63, 99], labels=['Baby/Toddler', 'Child', 'Adult', 'Elderly'])

# Printing DataFrame after sorting Continuous to Categories
print(df)

# Check the number of values in each bin
print("Categories: ")
print(df['Label'].value_counts())

#-------------------------------
# Import libraries
import numpy as np
import pandas as pd

# Import dataset
df = pd.read_csv('Iris.csv')

print(df['Species'].unique())

# Import label encoder
from sklearn import preprocessing

# label_encoder object knows how to understand word labels.
label_encoder = preprocessing.LabelEncoder()

# Encode labels in column 'species'.
df['Species']= label_encoder.fit_transform(df['Species'])

df['Species'].unique()

#-------------------------------

# example of a ordinal encoding
from numpy import asarray
from sklearn.preprocessing import OrdinalEncoder
# define data
data = asarray([['red'], ['green'], ['blue']])
print(data)
# define ordinal encoding
encoder = OrdinalEncoder()
# transform data
result = encoder.fit_transform(data)
print(result)


#-----------------------

# example of a one hot encoding
from numpy import asarray
from sklearn.preprocessing import OneHotEncoder
# define data
data = asarray([['red'], ['green'], ['blue']])
print(data)
# define one hot encoding
encoder = OneHotEncoder(sparse=False)
# transform data
onehot = encoder.fit_transform(data)
print(onehot)

#--------------------------------

import pandas as pd
# create data
df = pd.DataFrame([ [180000, 110, 18.9, 1400], [360000, 905, 23.4, 1800], [230000, 230, 14.0, 1300], [60000, 450, 13.5, 1500]], columns=['Col A', 'Col B', 'Col C', 'Col D'])
df_min_max_scaled = df.copy()

# apply normalization techniques
for column in df_min_max_scaled.columns:
    df_min_max_scaled[column] = (df_min_max_scaled[column] - df_min_max_scaled[column].min()) / (df_min_max_scaled[column].max() - df_min_max_scaled[column].min())

# view normalized data
print(df_min_max_scaled)
