#*  author: Sabbir <sabbir.tuqcx@aleeas.com>
#:  All of the follwing algorithms are implemented by author from scratch.


import numpy    #: for parallel calculation
import sys      #: to get maximum float number
#: numpy.dot function uses parallel calculation for multiplication,
#:  as it doesn't follow iterative apporch rather parallel, so it's faster.
#: numpy.sum is similar to numpy dot function, but for summation.

class LinearRegression:
    def __init__(self, alpha):
        self.alpha = alpha  #: learning rate
        self.bias = None    #: bias, also denoted with theta0
        self.weights = None #: coefficients of hypothesis, describes importance

    def hypothesis(self, x):
        return numpy.dot(x, self.weights) + self.bias

    def cost(self, x, y):
        return (1/(2*(y.shape[0]))) * numpy.sum((self.hypothesis(x) - y)**2)

    def gradient(self, x, y_hat, y):
        dw = (1/(x.shape[0])) * numpy.dot(numpy.transpose(x), (y_hat - y))
        db = (1/(y.shape[0])) * numpy.sum(y_hat - y)
        return dw, db

    def updateParameters(self, dw, db):
        self.weights = self.weights - self.alpha*dw
        self.bias = self.bias - self.alpha*db

    def train(self, x_train, y_train):
        self.weights = numpy.zeros(x_train.shape[1])
        self.bias = numpy.mean(y_train)
        previous_cost = sys.float_info.max  #: used to detect divergence
        iteration = 0       #: used to show cost at different iterations

        while True:
            y_hat = self.hypothesis(x_train)    #: predictions by hypothesis
            dw, db = self.gradient(x_train, y_hat, y_train)
            self.updateParameters(dw, db)       #: updating weights and bias

            cost_t = self.cost(x_train, y_train)    #: error by hypothesis
            #: bigger cost than previous cost means diverging
            cost_difference = previous_cost - cost_t
            if iteration % 1000 == 0:   #: to print cost at each thousand iteration
                print(f"Cost at {iteration}-th iteration: {cost_t}")
            if cost_difference < 0:     #: to stop training when diverging
                print(f'Cost Function is Diverging, Stopping Training...')
                break
            previous_cost = cost_t  #: current cost becomes previous for next iteration
            iteration += 1
            if numpy.linalg.norm(dw, 2) < 1e-6: #: handles overflow
                break

    def predict(self, x_test):
        #: checks if number of features and weight are equal for prediction.
        assert x_test.shape[1] == self.weights.shape[0], "Incorrect Shape"
        return self.hypothesis(x_test)

class LogisticRegression:
    def __init__(self, alpha):
        self.alpha = alpha  #: learning rate
        self.bias = None    #: bias, also denoted with theta0
        self.weights = None #: coefficients of hypothesis, describes importance

    def sigmoid(self, x):
        return 1/(1+numpy.exp(-(numpy.dot(x, self.weights) + self.bias)))

    def cost(self, x, y):   # TODO: correctly implement for logistic regression
        return numpy.sum((y * numpy.log(self.sigmoid(x)) + (1 - y) * numpy.log(1 - self.sigmoid(x))))

    def gradient(self, x, y_hat, y):
        dw = (1/(x.shape[0])) * numpy.dot(numpy.transpose(x), (y_hat - y))
        db = (1/(y.shape[0])) * numpy.sum(y_hat - y)
        return dw, db

    def updateParameters(self, dw, db):
        self.weights = self.weights - self.alpha*dw
        self.bias = self.bias - self.alpha*db

    def train(self, x_train, y_train):
        self.weights = numpy.zeros(x_train.shape[1])
        self.bias = numpy.mean(y_train)
        previous_cost = sys.float_info.max  #: used to detect divergence
        iteration = 0       #: used to show cost at different iterations

        #while True:
        for i in range(150000):
            y_hat = self.sigmoid(x_train)       #: predictions by sigmoid
            dw, db = self.gradient(x_train, y_hat, y_train)
            self.updateParameters(dw, db)       #: updating weights and bias

            # TODO: update this block after correctly implementing cost function
            #cost_t = self.cost(x_train, y_train)    #: error by hypothesis
            #: bigger cost than previous cost means diverging
            #cost_difference = previous_cost - cost_t
            #if iteration % 1000 == 0:   #: to print cost at each thousand iteration
            #    print(f"Cost at {iteration}-th iteration: {cost_t}")
            #if cost_difference < 0:     #: to stop training when diverging
            #    print(f'Cost Function is Diverging, Stopping Training...')
            #    break
            #previous_cost = cost_t  #: current cost becomes previous for next iteration
            #iteration += 1
            if numpy.linalg.norm(dw, 2) < 1e-6: #: handles overflow
                break

    def predict(self, x_test):
        #: checks if number of features and weight are equal for prediction.
        assert x_test.shape[1] == self.weights.shape[0], "Incorrect Shape"
        y_hat = self.sigmoid(x_test)

        #: classifying each target in binary manner
        class_hat = [0 if y<=0.5 else 1 for y in y_hat]
        return class_hat
