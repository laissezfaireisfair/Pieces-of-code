package main

import "fmt"

func main() {
	type UserID int64
	myID := UserID(54)
	fmt.Println(myID)

	var x int = 1337
	xptr := &x
	xval := *xptr
	var ptr *int = new(int)
	*ptr = 47
	fmt.Println(x, xval, *ptr)

	var arr [3]int
	fmt.Println(arr)
	otherArr := arr
	otherArr[0] = 1
	fmt.Println(otherArr)
	fmt.Println(arr)

	var slice1 []int
	slice2 := make([]int, 3, 5)
	fmt.Println(slice1)
	fmt.Println(slice2)
	slice2 = append(slice2, 54)
	slice2 = append(slice2, slice1...)
	fmt.Println(slice2)
	fmt.Println(len(slice2), cap(slice2))
	sliceHalf := slice2[2:]
	fmt.Println(sliceHalf)
	sliceCopy := make([]int, len(sliceHalf), cap(sliceHalf))
	copy(sliceCopy, sliceHalf)
	fmt.Println(sliceCopy)
}
