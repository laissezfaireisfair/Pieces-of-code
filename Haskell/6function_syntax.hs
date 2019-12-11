sayMe :: Int -> String
sayMe 1 = "One"
sayMe 2 = "Two"
sayMe 3 = "Three"
sayMe 4 = "Four"
sayMe 5 = "Five"
sayMe _ = "WRONG NUM"

factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n-1)

addVec :: (Num a) => (a,a) -> (a,a) -> (a,a)
addVec (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

letters = ['A'..'Z']++['a'..'z']
rmTrashSymbols :: String -> String
rmTrashSymbols "" = ""
rmTrashSymbols (x:xs) = if elem x letters
                        then x : rmTrashSymbols xs
                        else rmTrashSymbols xs

bmiCheck :: Double -> Double -> String
bmiCheck weight height
                       | bmi <= skinny = "Underweight"
                       | bmi <= normal = "Normal weight"
                       | bmi <= fat = "Overweight"
                       | otherwise = "Obesity"
                       where bmi = weight / height ^ 2
                             skinny = 18.5
                             normal = 25
                             fat = 30

countCylinderSquare :: Double -> Double -> Double
countCylinderSquare radius height =
                                    let sideSquare = 2 * pi * radius * height
                                        topSquare = pi * radius ^ 2
                                    in sideSquare + 2 * topSquare
