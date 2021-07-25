using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.Design;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyBookLibrary;

namespace MyApp
{
    class Program
    {
        public static void menu()
        {
            Console.WriteLine("***   MENU   ***");
            Console.WriteLine("1. Add new book");
            Console.WriteLine("2. Update a book");
            Console.WriteLine("3. Delete a book");
            Console.WriteLine("4. List all book");
            Console.WriteLine("5. Quit");
        }
        static void Main(string[] args)
        {
            string ID;
            string Name;
            string Publisher;
            string Price;
            int choice;

            do
            {
                menu();
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Input Book's ID: ");
                        ID = Console.ReadLine();
                        Console.WriteLine("Input Book's name: ");
                        Name = Console.ReadLine();
                        Console.WriteLine("Input Book's Publisher: ");
                        Publisher = Console.ReadLine();
                        Console.WriteLine("Input Book's price: ");
                        Price = Console.ReadLine();
                        MyBookLibrary.MyBookLibrary.AddBook(ID, Name, Publisher, Price);
                        break;
                    case 2:
                        Console.WriteLine("Input Book's ID to update: ");
                        ID = Console.ReadLine();
                        MyBookLibrary.MyBookLibrary.UpdateBook(ID);
                        break;
                    case 3:
                        Console.WriteLine("Input Book's ID to delete: ");
                        ID = Console.ReadLine();
                        MyBookLibrary.MyBookLibrary.Deletebook(ID);
                        break;
                    case 4:
                        MyBookLibrary.MyBookLibrary.ListBook();
                        break;
                    case 5:
                        Console.WriteLine("Good bye");
                        Console.ReadLine();
                        break;
                    default: break;
                }
            } while (choice >= 1 && choice <= 4);
        }
    }
}
