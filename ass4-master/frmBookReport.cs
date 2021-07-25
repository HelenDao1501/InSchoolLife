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
    public partial class frmBookReport : Form
    {
        public DataTable dtBook { get; set; }
        public frmBookReport()
        {
            InitializeComponent();
        }

        public frmBookReport(DataTable d) : this()
        {
            dtBook = d;
        }


        private void frmBookReport_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            bsBooks.DataSource = dtBook;
            dgvBookList.DataSource = bsBooks;
            bsBooks.Sort = "BookPrice DESC";
            bnBookList.BindingSource = bsBooks;
        }

        private void dgvBookList_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
