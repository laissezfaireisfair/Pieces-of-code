#include <stdlib.h>
#include <stdio.h>

typedef enum _command {PACK, UNPACK} command;
typedef enum _bool {FALSE, TRUE} bool;

bool is_string_equal(char const *str1, char const *str2) {
  for (unsigned int i = 0; str1[i] == str2[i]; ++i)
    if (str1[i] == 0)
      return TRUE;
  return FALSE;
}

command ask_command(FILE *fin) {
  char *str = (char*)malloc(sizeof(char) * 256);
  fscanf(fin, "%s", str);
  command out;
  if (is_string_equal(str, "PACK"))
    out = PACK;
  if (is_string_equal(str, "UNPACK"))
    out = UNPACK;
  free(str);
  return out;
}

/// (3)a -> aaa
void print_letters(FILE *fout, unsigned int const number, char const letter) {
  for (unsigned int i = 0; i < number; ++i)
    fprintf(fout, "%c", letter);
}

/// (1)a -> a ... (3)a -> (3)a
void print_block(FILE *fout, unsigned int const number, char const letter) {
  switch(number) {
    case 0 : break;
    case 1 : fprintf(fout, "%c", letter); break;
    case 2 : fprintf(fout, "%c%c", letter, letter); break;
    default: fprintf(fout, "(%u)%c", number, letter); break;
  }
}

void pack(FILE *fin, FILE *fout) {
  bool strEnded = FALSE;
  char const badSymbol = ')';
  unsigned int numRepeated = 0;
  for (char symbol = badSymbol, oldSymbol = badSymbol; strEnded == FALSE;) {
    oldSymbol = symbol;
    if (fscanf(fin, "%c", &symbol) == EOF) {
      strEnded = TRUE;
      print_block(fout, numRepeated, oldSymbol);
      break;
    }
    if (symbol == oldSymbol)
      ++numRepeated;
    else {
      print_block(fout, numRepeated, oldSymbol);
      numRepeated = 1;
    }
  }
}

void unpack(FILE *fin, FILE *fout) {
  bool strEnded = FALSE;
  while(strEnded == FALSE) {
    char symbol;
    if (fscanf(fin, "%c", &symbol) == EOF) {
      strEnded = TRUE;
      break;
    }

    if (symbol == '(') {
      unsigned int number;
      char letter;
      fscanf(fin, "%u)%c", &number, &letter);
      print_letters(fout, number, letter);
      continue;
    }

    fprintf(fout, "%c", symbol);
  }
}

int main() {
  FILE *fin = fopen("input.txt", "r");
  FILE *fout = fopen("output.txt", "w");
  command const inputCommand = ask_command(fin);
  if (inputCommand == PACK)
    pack(fin, fout);
  if (inputCommand == UNPACK)
    unpack(fin, fout);
  fclose(fin);
  fclose(fout);
  return 0;
}
