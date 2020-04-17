int swap_str_if_need(int **matrix, unsigned int const size, unsigned int const k) {
  if (matrix == NULL || size == 0 || k >= size)
    return -1;
  for (unsigned int i = 0; i < size; ++i) // Можно объединить с циклом поиска строки, но я стараюсь не смешивать проверку корректности с логикой программы
    if (matrix[i] == NULL)
      return -1;

  unsigned int strWithMaxAbsElem = 0;
  for (unsigned int i = 0; i < size; ++i)
    if (matrix[i][k] > matrix[strWithMaxAbsElem][k])
      strWithMaxAbsElem = i;

  if (strWithMaxAbsElem == k)
    return 0;

  for (unsigned int j = 0; j < size; ++j) {
    // Swap elements:
    matrix[k][i] ^= matrix[strWithMaxAbsElem][i];
    matrix[strWithMaxAbsElem][i] ^= matrix[k][i];
    matrix[k][i] ^= matrix[strWithMaxAbsElem][i];
  }
  return 0;
}
