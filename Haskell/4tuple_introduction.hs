combineNameAndSurename name surename = (name, surename)

getNameFromCombination tuple = fst tuple

getSurenameFromCombination tuple = snd tuple

nouns = ["Saposhnik", "Portnoij", "Pekar", "Aptekar"]

adjs = ["Poshiloij", "Strannij", "Neumelij"]

zipCharacters = zip nouns adjs

getTriangles = [(c, b, a) | a <- [1..1000], b <- [1..a], c <- [1..b], a*a == b*b + c*c]
