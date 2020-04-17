// 1 - simmetric, 0 - not simmetric, -1 - invalid argument
int is_simmetric(int **matrix, unsigned int const size){
  if (matrix == NULL || size == 0)
    return -1;
  for (unsigned int i = 0; i < size; ++i)
    if (matrix[i] == NULL)
      return -1;

  for (unsigned int i = 0; i < size; ++i)
    for (unsigned int j = 0; j < size; ++j)
      if (matrix[i][j] != matrix [j][i])
        return 0;
  return 1;
}
