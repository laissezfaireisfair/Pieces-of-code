#include <stdio.h>

void add_vals (int** matrix, int size, FILE *fin){
    int i;
    int j;
    fscanf(fin, "%d", matrix[i][j]);
} //я пытался сделать тут только одну функцию пока что и у меня нихрена не запускается, к сожалению и выдаёт кучу ошибок, кек
int is_simmetric (int** matrix, unsigned int const size){
    for (unsigned int i = 0; i < size; ++i)
        for (unsigned int j = 0; j < size; ++j)
            if (matrix[i][j] != matrix [j][i])
                return 0;
    return 1;
}
int main(){
    FILE *fin = fopen("input.txt", "r");
    unsigned int size;
    fscanf(fin, "%u", &size)
    int p;
    int **p = (**int)malloc(sizeof(*int)*size);
    for (unsigned int i = 0; i < size; ++i)
        p[i]=(*int)malloc(sizeof(int)*size);
    add_vals(matrix, size, fin);
    fclose(fin);
    int status_simm;
    status_simm = is_simmetric(matrix,size);
    FILE *fout = fout ("output.txt", "w");
    fprintf (fout, "%d", status_simm);
    fclose(fout);
    for (unsigned int i = 0; i < size; ++i );
        free (p[i]);
    free(p);
    return 0

}
