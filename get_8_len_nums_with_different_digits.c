#include <stdio.h>
#include <stdlib.h>

short areDigitsDifferent(unsigned int const num) {
  unsigned int tNum = num;
  unsigned short usedDigits[8];
  for (unsigned int i = 0 ; i < 9; ++i) {
    unsigned int const digit = tNum % 10;
    for (unsigned int j = 0; j < i; ++j)
      if (usedDigits[j] == digit)
        return 0;
    usedDigits[i] = digit;
    tNum /= 10;
  }
  return 1;
}

int get_nums(unsigned int array[], unsigned int const arraySize) {
  if (array == NULL) {
    printf("get_nums(): Null pointer input.\n");
    return 1;
  }
  for (unsigned int i = 10000000, counter = 0; i <= 99999999; ++i) {
    if (counter >= arraySize) {
      printf("get_nums(): Array overflow.\n");
      return 2;
    }
    if (areDigitsDifferent(i)) {
      array[counter] = i;
      ++counter;
    }
  }
  return 0;
}

int print_nums(unsigned int const array[], unsigned int const arraySize) {
  if (array == NULL) {
    printf("print_nums(): Null pointer input.\n");
    return 1;
  }
  for (unsigned int i = 0; i < arraySize; ++i)
    if (array[i] != 0)
      printf("%u ", array[i]);
  printf("\n");
  return 0;
}

int main() {
  // 9 * permutations(9, 7); because first digit cannot be null
  unsigned int const size = 1632960;
  unsigned int *array = malloc(sizeof(unsigned int) * size);
  if (get_nums(array, size) != 0)
    return 1;
  if (print_nums(array, size) != 0)
    return 2;
  free(array);
  return 0;
}
