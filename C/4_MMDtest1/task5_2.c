int replace_three_points_with_one(char *str, char **out) {
  if (str == NULL || out == NULL || *out != NULL)
    return 1;

  unsigned int const length;
  for (length = 0; str[length] != 0; ++length);
  if (length == 0)
    return 2;

  *out = (char*)malloc(sizeof(char) * (length + 1));
  if (*out == NULL)
    return 3;
  
  unsigned int i = 2, j = 0;
  while (i < length) {
    if (str[i] == '.' && str[i - 1] == '.' && str[i - 2] == '.') {
      (*out)[j] = '.';
      i += 3;
      ++j;
    } else {
      (*out)[j] = str[i-2];
      ++i;
      ++j;
    }
  }

  if (i - 2 < length) {
    (*out)[j] = str[i-2];
    if (i - 1 < length)
      (*out)[j+1] = str[i-1]
  }

  return 0;
}
