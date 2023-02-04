#*  author: Sabbir <sabbir.tuqcx@aleeas.com>

##: importing libraries and dataset
import pandas                       #: for loading dataset
import matplotlib.pyplot as plot    #: for visualizing
import numpy                        #: for parallel computation
import os                           #: to get current directory
#: please keep data and this code in same directory
dataset = pandas.read_csv(os.getcwd()+"/final.csv")

##: data preProcessing
#: loc and iloc helps to select a specific row or column from the data set.
#: loc gets rows (and/or columns) with particular labels.
#: iloc gets rows (and/or columns) at integer locations.
#: loc[A:B] -> A and B are included, iloc[a:b] -> a included, but m excluded.
#: iloc[x] means x indexed row, iloc[,x] means x indexed column.
x = dataset.iloc[:,:-1].values  # values converts column to numpy array
y = dataset.iloc[:,1].values
x = x / 1000    #: scalling data to avoid overflow
y = y / 1000    #: scalling data to avoid overflow

##: spliting dataset
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x,y,test_size=1/3,random_state=0)

##: fitting the regression model
from mlFromScratch import LinearRegression
alpha = float(input("Learning Rate: ")) #: taking from user, instead manually
regressor = LinearRegression(alpha)     #: creating an instance of Linear Regression
regressor.train(x_train, y_train)       #: training the model with training data set

##: predicting results for test set
y_hat = regressor.predict(x_test)
# TODO: try getting score/accuracy if possible with Linear Regression
#print(str(regressor.score(x_test, y_test)))

##: plot the training, test sets and decison boundary
plot.scatter(x_train, y_train, color='black', label="Training Set") #: training set
plot.scatter(x_test, y_test, color='red', label="Test Set") #: test set
plot.plot(x_train, regressor.predict(x_train), color='blue', label="Regression Line")   #: regression line
plot.title("House Price Prediction")            #: title of the graph
plot.xlabel("AREA (in thousands square feets)") #: name of x-axis
plot.ylabel("PRICE (in thousand $)")            #: name of y-axis
plot.legend()                                   #: describing which is what
plot.show()                                     #: showing all plots together
