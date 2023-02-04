# author: Sabbir <sabbir.tuqcx@aleeas.com>

#: Lists, --; ordered-changeable-allowsDuplicate
myList = ['S', 'a', 'b', 'b', 'i', 'r']
print("\nWorking with: " + str(type(myList)))
print("My List:\n\t" + str(myList))

#: Tuples, --; ordered-unchangeable-allowsDuplicate
myTuple = ('Sabbir', 'Male', 193002069)
print("\nWorking with: " + str(type(myTuple)))
print("My Tuple:\n\t" + str(myTuple))

#: Sets, --; unordered-unchangeable-noDuplicate
mySet = {'C', 'Assembly', 'Java', 'Python', 'Bash', 'Makefile'}
print("\nWorking with: " + str(type(mySet)))
print("My Set:\n\t" + str(mySet))

#: Dictionaries, uses key:value mechanism; ordered-changeable-noDuplicate
myDictionary = {
    'name' : "Sabbir",
    'batch' : 193,
    'id' : 193002069,
    'cgpa' : 1.00,
    'favoriteLanguages' : ["C", "Assesmbly"],
    'forRemove' : None
}
print("\nWorking with: " + str(type(myDictionary)))
print("Accessing Elements...")
print("\tName: " + str(myDictionary['name']))
print("\tID: " + str(myDictionary['id']))
print("\tCGPA: " + str(myDictionary['cgpa']))
print("Updating a Element...")
myDictionary['cgpa'] = 2.00
print("\tCGPA: " + str(myDictionary['cgpa']))
print("Dictionary Length before Removing an Element: " + str(len(myDictionary)))
print("\t" + str(myDictionary))
#del myDictionary['forRemove']
myDictionary.pop("forRemove")
print("Dictionary Length after Removing an Element: " + str(len(myDictionary)))
print("\t" + str(myDictionary))
