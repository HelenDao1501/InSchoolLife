using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assigment4
{
    public partial class frmLogin : Form
    {
        Employee employee = null;
        EmployeeData ed = new EmployeeData();
        public frmLogin()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            string username = txtUsername.Text;
            string password = txtPassword.Text;
            employee = ed.CheckLogin(username, password);
            if (employee != null)
            {
                bool Role = employee.EmpRole;
                if (Role)
                {
                    this.Hide();
                    Thread t = new Thread(new ThreadStart(showBookFrm));
                    t.Start();
                    this.Close();
                } 
                else
                {
                    this.Hide();
                    Thread t = new Thread(new ThreadStart(showChangePassFrm));
                    t.Start();
                    this.Close();
                }
            }
            else
            {
                MessageBox.Show("Invalid Username or Password");
            }
        }

        private void showChangePassFrm()
        {
            frmChangeAccount changeAccount = new frmChangeAccount(employee);
            Application.Run(changeAccount);
        }

        private void showBookFrm()
        {
            frmMaintainBook maintainBook = new frmMaintainBook();
            Application.Run(maintainBook);
        }

        private void frmLogin_Load(object sender, EventArgs e)
        {

        }
    }
}
