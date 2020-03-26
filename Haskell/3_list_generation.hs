alphabet = ['A'..'Z']++['a'..'z']

dividableByTwo = [0,2..]

tral = take (54*4) (cycle "LOH ")

fiftyFourDividableByTwoAndThree = take 54 [x | x <- dividableByTwo, mod x 3 == 0]

listtral = repeat "LOH"

threeTral = replicate 3 "LOH"

fiftyFourSquaresOfDividableByThree = take 54 [x*x | x <- [1..], mod x 3 == 0]

sums = [x + y | x <- [1,3..9], y <- [2,4..10]]

nouns = ["Saposhnik", "Portnoij", "Pekar", "Aptekar"]

adjs = ["Poshiloij", "Strannij", "Neumelij"]

makeCharacterList = [x ++ " " ++ y | x <- adjs, y <- nouns]

removeNonLetters str = [smb | smb <- str, elem smb alphabet]
