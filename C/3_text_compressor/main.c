#include <stdlib.h>
#include <stdio.h>

typedef enum _command {PACK, UNPACK, BAD_COMMAND} command;
typedef enum _bool {FALSE, TRUE} bool;
typedef enum _error {OK, DIVISION_BY_ZERO, NULL_POINTER, INVALID_ARGUMENT, BAD_INPUT,
	 						RUNTIME_ERROR, LENGTH_ERROR} error;

void print_error(char const * const filename, error const err) {
	FILE *fout = fopen(filename, "w");
	if (fout == NULL)
		exit(RUNTIME_ERROR);
  switch(err) {
    case(OK):               fprintf(fout, "ok\n"); break;
    case(DIVISION_BY_ZERO): fprintf(fout, "division by zero\n"); break;
    case(NULL_POINTER):     fprintf(fout, "null pointer\n"); break;
    case(INVALID_ARGUMENT): fprintf(fout, "invalid argument\n"); break;
    case(BAD_INPUT):        fprintf(fout, "bad input\n"); break;
    case(RUNTIME_ERROR):    fprintf(fout, "runtime error\n"); break;
    case(LENGTH_ERROR):     fprintf(fout, "length error\n"); break;
  }
	fclose(fout);
}

bool is_string_equal(char const *str1, char const *str2) {
  if (str1 == NULL || str2 == NULL)
    return NULL_POINTER;

  for (unsigned int i = 0; str1[i] == str2[i]; ++i)
    if (str1[i] == 0)
      return TRUE;
  return FALSE;
}

error ask_command(FILE *fin, command *out) {
  if (fin == NULL)
    return NULL_POINTER;

  char *str = (char*)malloc(sizeof(char) * 256);
  fscanf(fin, "%s", str);
  *out = BAD_COMMAND;
  if (is_string_equal(str, "PACK"))
    *out = PACK;
  if (is_string_equal(str, "UNPACK"))
    *out = UNPACK;
  free(str);

  if (*out == BAD_COMMAND)
    return BAD_INPUT;
  return OK;
}

/// (3)a -> aaa
error print_letters(FILE *fout, unsigned int const number, char const letter) {
  if (fout == NULL)
    return NULL_POINTER;

  for (unsigned int i = 0; i < number; ++i)
    fprintf(fout, "%c", letter);
  return OK;
}

/// (1)a -> a ... (3)a -> (3)a
error print_block(FILE *fout, unsigned int const number, char const letter) {
  if (fout == NULL)
    return NULL_POINTER;

  switch(number) {
    case 0 : break;
    case 1 : fprintf(fout, "%c", letter); break;
    case 2 : fprintf(fout, "%c%c", letter, letter); break;
    default: fprintf(fout, "(%u)%c", number, letter); break;
  }
  return OK;
}

error pack(FILE *fin, FILE *fout) {
  if (fin == NULL || fout == NULL)
    return NULL_POINTER;

  bool strEnded = FALSE;
  char const badSymbol = ')';
  unsigned int numRepeated = 0;
  for (char symbol = badSymbol, oldSymbol = badSymbol; strEnded == FALSE;) {
    oldSymbol = symbol;
    if (fscanf(fin, "%c", &symbol) == EOF) {
      strEnded = TRUE;
      error status = print_block(fout, numRepeated, oldSymbol);
      if (status != OK)
        return status;
      break;
    }
    if (symbol == oldSymbol)
      ++numRepeated;
    else {
      error status = print_block(fout, numRepeated, oldSymbol);
      if (status != OK)
        return status;
      numRepeated = 1;
    }
  }
  return OK;
}

error unpack(FILE *fin, FILE *fout) {
  if (fin == NULL || fout == NULL)
    return NULL_POINTER;

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
      error status = print_letters(fout, number, letter);
      if (status != OK)
        return status;
      continue;
    }

    fprintf(fout, "%c", symbol);
  }
  return OK;
}

int main() {
  char const * const INPUT_FILE_NAME  = "input.txt";
  char const * const OUTPUT_FILE_NAME = "output.txt";
  FILE *fin  = fopen(INPUT_FILE_NAME, "r");
  FILE *fout = fopen(OUTPUT_FILE_NAME, "w");
  command inputCommand;
  ask_command(fin, &inputCommand);
  if (inputCommand == PACK) {
    error status = pack(fin, fout);
    if (status != OK)
      print_error(OUTPUT_FILE_NAME, status);
  }
  if (inputCommand == UNPACK) {
    error status = unpack(fin, fout);
    if (status != OK)
      print_error(OUTPUT_FILE_NAME, status);
  }
  fclose(fin);
  fclose(fout);
  return 0;
}
