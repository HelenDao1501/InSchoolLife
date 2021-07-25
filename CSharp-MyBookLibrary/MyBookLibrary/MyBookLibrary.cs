using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace MyBookLibrary
{
    public class MyBookLibrary
    {
        private string ID;

        public string getID
        {
            get { return ID; }
            set { ID = value; }
        }

        private string Name;

        public string getName
        {
            get { return Name; }
            set { Name = value; }
        }

        private string Publisher;

        public string getPublisher
        {
            get { return Publisher; }
            set { Publisher = value; }
        }

        private string Price;

        public string getPrice
        {
            get { return Price; }
            set { Price = value; }
        }

        public MyBookLibrary()
        {
            ID = null;
            Name = null;
            Publisher = null;
            Price = null;
        }

        public MyBookLibrary(string ID, string Name, string Publisher, string Price)
        {
            this.ID = ID;
            this.Name = Name;
            this.Publisher = Publisher;
            this.Price = Price;
        }

        static List<MyBookLibrary> BookList = new List<MyBookLibrary>();

        public static MyBookLibrary SearchBook(string ID)
        {
            MyBookLibrary Book = null;
            foreach (var book in BookList)
            {
                if(ID == book.ID)
                {
                    Book = book;
                }
            }
            return Book;

        }

        public static void AddBook (string ID, string Name, string Publisher, string Price)
        {
            if (SearchBook(ID)==null)
            {
                BookList.Add(new MyBookLibrary(ID, Name, Publisher, Price));
                Console.WriteLine("Them sach thanh cong");
            }
        }

        public static void UpdateBook(string ID)
        {
            MyBookLibrary book = SearchBook(ID);
            if (book != null)
            {
                Console.WriteLine("Ma sach: " + book.ID);
                Console.WriteLine("Nhap ten sach: ");
                book.Name = Console.ReadLine();
                Console.WriteLine("Nhap nha san xuat: ");
                book.Publisher = Console.ReadLine();
                Console.WriteLine("Nhap gia sach: ");
                book.Price = Console.ReadLine();
                Console.WriteLine("Cap nhat thong tin sach thanh cong");
            }
            else
            {
                Console.WriteLine("Khong tim thay sach co ma: " + ID);
            }
        }

        public static void Deletebook(string ID)
        {
            MyBookLibrary book = SearchBook(ID);
            if (book != null)
            {
                BookList.Remove(book);
                Console.WriteLine("Xoa sach thanh cong");
            }
        }

        public void BookInfo(MyBookLibrary book)
        {
            Console.WriteLine("Book's ID: " + book.ID);
            Console.WriteLine("Book's Name: " + book.Name);
            Console.WriteLine("Book's Publisher: " + book.Publisher);
            Console.WriteLine("Book's Price: " + book.Price);
        }

        public static void ListBook()
        {
            Console.WriteLine("Book's List");
            foreach (var book in BookList)
            {
                book.BookInfo(book);
                Console.ReadLine();
            }
        }
    }
}
