using ProductLibrary;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProductManagement
{
    public partial class frmFacultyDetail : Form
    {
        public Faculty faculty { get; set; }
        public frmFacultyDetail()
        {
            InitializeComponent();
        }
        public frmFacultyDetail(Faculty p) : this()
        {
            faculty = p;
            InitData();
        }

        private void InitData()
        {
            lbDetail.Text = "FacultyID: " + faculty.FacultyID.ToString() + "\n" +
                "Name: " + faculty.FullName + "\n" +
                "Age: " + faculty.Age.ToString() + "\n" +
                "Address: " + faculty.Address + "\n";
     
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void lbDetail_Click(object sender, EventArgs e)
        {

        }
    }
}
