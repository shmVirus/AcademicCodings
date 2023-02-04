#*  author: Sabbir <sabbir.tuqcx@aleeas.com>


##: importing libraries and dataset
import pandas                       #: for loading dataset
import matplotlib.pyplot as plot    #: for visualizing
import numpy                        #: for parallel computation
import os                           #: to get current directory
import warnings                     #: to igonore unnecessary overflow warnings

#: ignoring overflow warrning from console for floats
warnings.filterwarnings("ignore")
#: please keep data and this code in same directory
dataset = pandas.read_csv(os.getcwd()+"/diabetes.csv")

##: data preProcessing
#: loc and iloc helps to select a specific row or column from the data set.
#: loc gets rows (and/or columns) with particular labels.
#: iloc gets rows (and/or columns) at integer locations.
#: loc[A:B] -> A and B are included, iloc[a:b] -> a included, but m excluded.
#: iloc[x] means x indexed row, iloc[,x] means x indexed column.
# iloc[:,:n] selects first n columns, iloc[:,n] selects n-indexed column.
x = dataset.iloc[:,:-1].values  # values converts column to numpy array
y = dataset.iloc[:,-1].values

##: spliting dataset
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x,y,test_size=1/3,random_state=0)

##: fitting the regression model
from mlFromScratch import LogisticRegression
alpha = float(input("Learning Rate: ")) #: taking from user, instead manually
classifier = LogisticRegression(alpha)  #: creating an instance of Logistic Regression
classifier.train(x_train, y_train)      #: training the model with training data set

##: predicting results for test set
y_hat = classifier.predict(x_test)
accuracy = numpy.sum(y_hat==y_test)/len(y_test) * 100
print(f"Accuracy of the Model: {accuracy}%")

# TODO: implement visualization for Logistic Regression model
##: plot the training, test sets and decison boundary
#plot.scatter(x_train, y_train, color='black', label="Training Set") #: training set
#plot.scatter(x_test, y_test, color='red', label="Test Set") #: test set
#plot.plot(x_train, regressor.predict(x_train), color='blue', label="Regression Line")   #: regression line
#plot.title("House Price Prediction")            #: title of the graph
#plot.xlabel("AREA (in thousands square feets)") #: name of x-axis
#plot.ylabel("PRICE (in thousand $)")            #: name of y-axis
#plot.legend()                                   #: describing which is what
#plot.show()                                     #: showing all plots together
