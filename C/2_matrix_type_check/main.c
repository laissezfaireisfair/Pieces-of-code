#include <stdio.h>
#include <stdlib.h>

void add_vals (int **matrix, unsigned int const size, FILE *fin){
    for (unsigned int i = 0; i < size; ++i)
      for (unsigned int j = 0; j < size; ++j)
        fscanf(fin, "%d", &matrix[i][j]);
}

int is_simmetric (int **matrix, unsigned int const size){
    for (unsigned int i = 0; i < size; ++i)
        for (unsigned int j = 0; j < size; ++j)
            if (matrix[i][j] != matrix [j][i])
                return 0;
    return 1;
}

int main(){
    FILE *fin = fopen("input.txt", "r");
    unsigned int size;
    fscanf(fin, "%u", &size);
    int **matrix = (int**)malloc(sizeof(int*) * size);
    for (unsigned int i = 0; i < size; ++i)
        matrix[i] = (int*)malloc(sizeof(int) * size);
    add_vals(matrix, size, fin);
    fclose(fin);
    int statusSimm = is_simmetric(matrix, size);
    FILE *fout = fopen("output.txt", "w");
    fprintf(fout, "%d", statusSimm);
    fclose(fout);
    for (unsigned int i = 0; i < size; ++i)
        free (matrix[i]);
    free(matrix);
    return 0;

}
