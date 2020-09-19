CC = g++
CFLAGS = -Wall -Wextra -pedantic -std=c++17 -lnana -I include

run : build/main.out

clean:
	rm -rf build/*

build/main.out: src/main.cpp
	$(CC) $(CFLAGS) $< -o $@