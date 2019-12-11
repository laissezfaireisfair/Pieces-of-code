getFirstFromCombination:: (a, b) -> a
getFirstFromCombination tuple = fst tuple


isEqual:: (Eq a) => a -> a -> Bool
isEqual a b = a == b

toStr:: (Show a) => a -> [Char]
toStr a = show(a)
