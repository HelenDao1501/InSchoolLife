using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Swap
{
    class Program
    {

        static void Swap<T>(ref T a, ref T b)
        {
            T temp;
            temp = a;
            a = b;
            b = temp;
        }
        static void Main(string[] args)
        {
             int a = 10, b = 90;
            Console.WriteLine("Before swap: {0}, {1}", a, b);
            Swap<int>(ref a, ref b);
            Console.WriteLine("After swap: {0}, {1}", a, b);


            String s1 = "Hello", s2 = "There";
            Console.WriteLine("Before swap: {0}, {1}!", s1, s2);
            Swap<string>(ref s1, ref s2);
            Console.WriteLine("After swap: {0}, {1}!", s1, s2);
            Console.ReadLine();

        }

    }
}
