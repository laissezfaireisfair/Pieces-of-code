int is_letter(char const symbol) {
  if (symbol >= 'A' && symbol <= 'Z')
    return 1;
  if (symbol >= 'a' && symbol <= 'z')
    return 1;
  return 0;
}

int is_vowel(char const letter) {
  if (letter == 'E' || letter == 'Y' || letter == 'U')
    return 1;
  if (letter == 'O' || letter == 'A' || letter == 'I')
    return 1;
  if (letter == 'e' || letter == 'y' || letter == 'u')
    return 1;
  if (letter == 'o' || letter == 'a' || letter == 'i')
    return 1;
  return 0;
}

int count_syllables(char *str, int **out) {
  if (str == NULL || out == NULL || *out != NULL)
    return 1;

  unsigned int const length;
  for (length = 0; str[length] != 0; ++length);
  if (length == 0)
    return 2;

  // Out[1] - number of words with 1 syllable, etc
  /* Можно было сделать эффективнее по памяти, но для этого пришлось бы
     реализовывать ассоциативные контейнеры (аналог map в С++) */
  *out = (int*)malloc(sizeof(int) * length);
  if (*out == NULL)
    return 3;

  for (unsigned int i = 0, wordBeginned = 0, vowelCounter = 0; i < length; ++i) {
    char const symbol = str[i];
    if (is_letter(symbol)) {
        wordBeginned = 1;
        if (is_vowel(symbol))
          ++vowelCounter;
    }

    if (!is_letter(symbol) && wordBeginned) {
      (*out)[vowelCounter] += 1;
      wordBeginned = 0;
      vowelCounter = 0;
    }
  }

  return 0;
}
