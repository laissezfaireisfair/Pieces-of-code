using System;

namespace Test1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            int[] numArray = new int[5];
            Console.WriteLine("numArray length is {0} (should be 5)", numArray.Length);

            Console.Write("numArray = { ");
            foreach (int i in numArray)
            {
                Console.Write("{0} ", i);
            }
            Console.WriteLine("}");

            int[] initedArr = { 1, 2, 3, 4, 5 };
            Console.WriteLine("initedArr length is {0} (should be 5)", initedArr.Length);
            Console.Write("initedArr = { ");
            foreach (int i in initedArr) {
                Console.Write("{0} ", i);
            }
            Console.WriteLine("}");

            int[,] matrix = new int[2, 3];
            Console.WriteLine("matrix is {0}x{1} size", matrix.GetUpperBound(0) + 1, matrix.GetUpperBound(1) + 1);
            for (int i = 0; i <= matrix.GetUpperBound(0); ++i) {
                for (int j = 0; j <= matrix.GetUpperBound(1); ++j) {
                    Console.Write("{0} ", matrix[i, j]);
                }
                Console.WriteLine("");
            }
        }
    }
}
