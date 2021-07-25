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
    public partial class frmMaintainFaculty : Form
    {
        List<Faculty> FacultyList;
        FacultyDB pd = new FacultyDB();      
        public frmMaintainFaculty()
        {
            InitializeComponent();
        }

        private void LoadData()
        {
            FacultyList = pd.GetFacultyList();
            if (FacultyList != null)
            {
                dgvFacultyList.DataSource = FacultyList;
            }
        }

        private void frmMaintainFaculty_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private string validate()
        {
            string check = "";
            if (txtFacultyID.Text.Trim().Length == 0)
            {
                check += "FacultyID is required!\n";
            }
            else if (int.Parse(txtFacultyID.Text) < 0)
            {
                check += "FacultyID must be >= 0!\n";
            }

            if (txtFullName.Text.Trim().Length == 0)
            {
                check += "Inputs are required!\n";
            }

            if (txtAge.Text.Trim().Length == 0)
            {
                check += "Age is required!\n";
            }
            else if (int.Parse(txtAge.Text) < 0)
            {
                check += "Age must be >= 0!\n";
            }

            if (txtAddress.Text.Trim().Length == 0)
            {
                check += "Address is required!\n";
            }
            return check;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string check = validate();
            if (check.Equals(""))
            {
                int ID = int.Parse(txtFacultyID.Text);
                string Name = txtFullName.Text;
                int Age = int.Parse(txtAge.Text);
                string Address = txtAddress.Text;
                Faculty p = pd.FindFaculty(ID);
                if (p == null)
                {
                    p = new Faculty
                    {
                        FacultyID = ID,
                        FullName = Name,
                        Age = Age,
                        Address = Address
                    };
                    bool r = pd.AddNewFaculty(p);
                    string s = (r == true ? "success" : "fail");
                    MessageBox.Show("Add faculty " + s);
                    LoadData();
                }
                else
                {
                    MessageBox.Show("Duplicate ID");
                }
            }
            else
            {
                MessageBox.Show(check);
            }
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            String check = validate();
            if (check.Equals(""))
            {
                int ID = int.Parse(txtFacultyID.Text);
                string Name = txtFullName.Text;
                int Age = int.Parse(txtAge.Text);
                string Address = txtAddress.Text;
                Faculty p = pd.FindFaculty(ID);
                if (p != null)
                {
                    p = new Faculty
                    {
                        FacultyID = ID,
                        FullName = Name,
                        Age = Age,
                        Address = Address
                    };
                    bool r = pd.UpdateFaculty(p);
                    string s = (r == true ? "success" : "fail");
                    MessageBox.Show("Update Faculty " + s);
                    LoadData();
                }
                else
                {
                    MessageBox.Show("ID does not exist");
                }
            }
            else
            {
                MessageBox.Show(check);
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtFacultyID.Text);
            Faculty p = pd.FindFaculty(ID);
            if (p != null)
            {
                bool r = pd.DeleteFaculty(p);
                string s = (r == true ? "success" : "fail");
                MessageBox.Show("Delete Faculty " + s);
                LoadData();
            }
            else
            {
                MessageBox.Show("ID does not exist");
            }
        }

        private void btnFind_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtFacultyID.Text);
            Faculty p = pd.FindFaculty(ID);
            if (p != null)
            {
                frmFacultyDetail productDetail = new frmFacultyDetail(p);
                productDetail.ShowDialog();
            }
            else
            {
                MessageBox.Show("Not Found");
            }
        }

        private void dgvProductList_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0)
            {
                DataGridViewRow row = this.dgvFacultyList.Rows[e.RowIndex];
                txtFacultyID.Text = row.Cells["ProductID"].Value.ToString();
                txtFullName.Text = row.Cells["ProductName"].Value.ToString();
                txtAge.Text = row.Cells["UnitPrice"].Value.ToString();
                txtAddress.Text = row.Cells["Quantity"].Value.ToString();
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void txtFacultyID_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
