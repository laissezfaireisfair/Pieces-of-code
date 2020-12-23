using System;

namespace HelloApp
{
    class Program
    {
        static bool CheckAge(in uint age) // in - const reference, ref - reference, out - reference that must be initialised
                                          // params - list of parameters to array
        {
            const uint majorityAge = 18;
            return age >= majorityAge;
        }

        static void Main(string[] args)
        {
            Console.Write("Type your name: ");
            string name = Console.ReadLine();
            Console.WriteLine($"Hello, {name}!");
            Console.Write("Type your age: ");
            uint userAge = Convert.ToUInt32(Console.ReadLine());
            if (CheckAge(age: userAge))
            {
                Console.WriteLine("Access granted.");
            }
            else
            {
                Console.WriteLine("Children aren't allowed here, sorry.");
            }
        }
    }
}
