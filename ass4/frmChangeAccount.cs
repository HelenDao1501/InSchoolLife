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
    public partial class frmChangeAccount : Form
    {
        EmployeeData ed = new EmployeeData();
        public Employee employee { get; set; }
        public frmChangeAccount()
        {
            InitializeComponent();
        }

        public frmChangeAccount(Employee e):this()
        {
            employee = e;
        }

        private void txtCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmChangeAccount_Load(object sender, EventArgs e)
        {
            txtUsername.Text = employee.EmpID;
            txtPassword.Text = employee.EmpPassword;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            string OldPassword = employee.EmpPassword;
            string Password = txtPassword.Text;
            string Confirm = txtConfirm.Text;

            if (!Password.Equals(OldPassword)) { 
                if (Password.Equals(Confirm))
                {
                    bool r = ed.ChangePassword(employee.EmpID, Password);
                    if (r)
                    {
                        frmLogin login = new frmLogin();
                        this.Hide();
                        login.Show();
                        MessageBox.Show("Change password successful!");
                    }
                    else
                        MessageBox.Show("Change password fail!");
                }
                else
                {
                    MessageBox.Show("Confirm and Password must be the same!");
                }
            }
            else
            {
                MessageBox.Show("New Password must be different!");
            }
        }
    }
}
