#include <stdlib.h>
#include <stdio.h>

void swap(unsigned int *a, unsigned int *b) {
  *a ^= *b;
  *b ^= *a;
  *a ^= *b;
}

void swap_char(char *a, char *b) {
  *a ^= *b;
  *b ^= *a;
  *a ^= *b;
}

void swap_ptr(char **a, char **b) {
  *a = (char*)((size_t)*a ^ (size_t)*b);
  *b = (char*)((size_t)*a ^ (size_t)*b);
  *a = (char*)((size_t)*a ^ (size_t)*b) ;
}

int main() {
  unsigned int aNum = 1, bNum = 2;
  printf("aNum = %u, bNum = %u\n", aNum, bNum);
  swap(&aNum, &bNum);
  printf("swap(aNum, bNum)\n");
  printf("aNum = %u, bNum = %u\n\n", aNum, bNum);

  char a = 'a', b = 'b';
  printf("a = %c, b = %c\n", a, b);
  swap_char(&a, &b);
  printf("swap(a, b)\n");
  printf("a = %c, b = %c\n\n", a, b);

  char *aArr, *bArr;
  aArr = (char*)malloc(sizeof(char)*2);
  bArr = (char*)malloc(sizeof(char)*2);
  aArr[0] = 'a';
  aArr[1] = 0;
  bArr[0] = 'b';
  bArr[1] = 0;
  printf("aArr = %s, bArr = %s\n", aArr, bArr);
  swap_ptr(&aArr, &bArr);
  printf("swap(aArr, bArr)\n");
  printf("aArr = %s, bArr = %s\n", aArr, bArr);
  free(aArr);
  free(bArr);
  return 0;
}
