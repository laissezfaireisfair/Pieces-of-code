numbersList = [1, 2, 3, 4]

myName = "Andrey"

mySurename = "Golubev"

myFullName = myName ++ " " ++ mySurename

myShortName = head myName : '.' : mySurename

myMatrix = [[0,1], [2, 3]]

isMyNameEqualMySurename = myName == mySurename

lengthMyFullName = length myFullName

reverseName = reverse myFullName

threeLettersOfName = take 3 myName

dropFirstLetters = drop 1 myName ++ " " ++ drop 1 mySurename

minLetterInName = minimum myName

sumSomeNumbers = sum [1..10]

multSomeNumbers = product [1..10]

isNameContainsZ = elem 'Z' myFullName
