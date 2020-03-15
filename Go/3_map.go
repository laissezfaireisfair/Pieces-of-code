package main

import "fmt"

func main() {
	var users map[string]string = map[string]string{
		"name":     "Andrey",
		"surename": "Golubev",
	}
	fmt.Printf("%+v\n", users)
	otherMap := make(map[int]string, 10)
	fmt.Printf("%+v\n", otherMap)
	usersNum := len(users)
	fmt.Println(usersNum)
	surename, isExist := users["surename"]
	if isExist {
		fmt.Println(surename)
	}
	delete(users, "surename")
	_, isExist = users["surename"]
	if !isExist {
		fmt.Println("Does not exist")
	}
}
