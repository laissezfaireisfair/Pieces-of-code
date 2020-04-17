#include <stdlib.h>
#include <stdio.h>

int main() {
  int accum = 0;
  for (int n = 1, factorial = 1; n <= 10; ++n, factorial *= n) {
    int const sign = (n % 2) ? -1 : 1;
    accum += sign * factorial * factorial;
  }
  printf("%d\n", accum);
  return 0;
}
