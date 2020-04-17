int is_letter(char const symbol) {
  if (symbol >= 'A' && symbol <= 'Z')
    return 1;
  if (symbol >= 'a' && symbol <= 'z')
    return 1;
  return 0;
}

int move_letter_to_end_of_word(char *str) {
  if (str == NULL)
    return 1;

  int firstLetterPos = -1, lastLetterPos = -1;
  for (unsigned int i = 0; str[i] != 0; ++i) {
    if (is_letter(str[i])) {
      if (firstLetterPos == -1)
        firstLetterPos = i;
    } else if (firstLetterPos != -1) {
      lastLetterPos = i -1;
      break;
    }
  }

  if (firstLetterPos == -1 || lastLetterPos == -1)
    return 2;

  const char firstLetter = str[firstLetterPos];
  for (unsigned int i = firstLetterPos; i < lastLetterPos; ++i)
    str[i] = str[i + 1];
  str[lastLetterPos] = firstLetter;

  return 0;
}
