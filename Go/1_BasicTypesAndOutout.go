package main

import "fmt"
import "unicode/utf8"

func main() {
	var num1, num2 int64 = 1, 2
	sum := num1 + num2
	fmt.Println(num1, num2, sum)

	var flag bool = false
	flagCopy := flag
	fmt.Println(flag, flagCopy)

	var str1, str2 string = "Hello", ", world\n"
	str := str1 + str2
	fmt.Println(str)
	strlen := utf8.RuneCountInString(str)
	fmt.Println(strlen)
	byteString := []byte(str)
	str = string(byteString)

	const pi = 3.14159265
	fmt.Println(pi)
	const (
		zero = iota
		_
		three
		four
		five
	)
	fmt.Println(zero, three, four, five)

	const (
		_     = iota
		e     = 2.7182818 * iota
		ePow2 = e * iota
		ePow3 = e * iota
	)
	fmt.Println(e, ePow2, ePow3)
}
