using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assigment4
{
    public partial class frmMaintainBook : Form
    {
        BookData bd = new BookData();
        DataTable dtBook;
        public frmMaintainBook()
        {
            InitializeComponent();
        }

       
        private void btnUpdate_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtBookID.Text);
            string Name = txtBookName.Text;
            float Price = float.Parse(txtBookPrice.Text);
            Book book = new Book()
            {
                BookID = ID,
                BookName = Name,
                BookPrice = Price
            };
            bool r = bd.UpdateBook(book);
            string s = (r == true ? "successful" : "fail");
            MessageBox.Show("Update " + s);
            LoadData();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtBookID.Text);
            bool r = bd.DeleteBook(ID);
            string s = (r == true ? "successful" : "fail");
            MessageBox.Show("Delete " + s);
            LoadData();
        }

        private void frmMaintainBook_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            dtBook = bd.GetBooks();
            bsBooks.DataSource = dtBook;

            txtBookID.DataBindings.Clear();
            txtBookName.DataBindings.Clear();
            txtBookPrice.DataBindings.Clear();

            txtBookID.DataBindings.Add("Text", bsBooks, "BookID");
            txtBookName.DataBindings.Add("Text", bsBooks, "BookName");
            txtBookPrice.DataBindings.Add("Text", bsBooks, "BookPrice");


            lbTotalPrice.Text = "Total Price: " + dtBook.Compute("SUM(BookPrice)", string.Empty);

            dgvBookList.DataSource = bsBooks;
            bsBooks.Sort = "BookID ASC";
            bnBookList.BindingSource = bsBooks;
        }

        private void txtNameFilter_TextChanged(object sender, EventArgs e)
        {
            DataView dv = dtBook.DefaultView;
            String filter = "BookName like '%" + txtNameFilter.Text + "%'";
            dv.RowFilter = filter;
            lbTotalPrice.Text = "Total Price: " + dtBook.Compute("SUM(BookPrice)", filter);
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int ID = 1;
            if (dtBook.Rows.Count > 0)
            {
                ID = int.Parse(dtBook.Compute("MAX(BookID)", "").ToString()) + 1;
            }
            string Name = txtBookName.Text;
            float Price = float.Parse(txtBookPrice.Text);
            Book book = new Book()
            {
                BookID = ID,
                BookName = Name,
                BookPrice = Price
            };
            bool r = bd.AddNewBook(book);
            string s = (r == true ? "successful" : "fail");
            MessageBox.Show("Add " + s);
            LoadData();
        }

        private void btnReport_Click(object sender, EventArgs e)
        {
            DataTable dtAllBook = bd.GetBooks();
            frmBookReport bookReport = new frmBookReport(dtAllBook);
            bookReport.ShowDialog();
        }
    }
}
