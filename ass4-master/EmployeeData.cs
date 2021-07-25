using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assigment4
{
    public class EmployeeData
    {
        string strConnection;
        public EmployeeData()
        {
            getConnectionString();
        }

        public string getConnectionString()
        {
            strConnection = ConfigurationManager.
                ConnectionStrings["BookStore"].ConnectionString;
            return strConnection;
        }

        public Employee CheckLogin(string username, string password)
        {
            Employee employee = null;
            string sql = "Select * from Employee Where EmpID=@ID And EmpPassword=@Password";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", username);
            cmd.Parameters.AddWithValue("@Password", password);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                SqlDataReader dr = cmd.ExecuteReader(CommandBehavior.CloseConnection);
                if (dr.HasRows)
                {
                    if (dr.Read())
                    {
                        string ID = dr.GetString(0);
                        string Pass = dr.GetString(1);
                        bool Role = dr.GetBoolean(2);
                        employee =  new Employee
                        {
                            EmpID = ID,
                            EmpPassword = Pass,
                            EmpRole = Role
                        };
                    }
                }
            }
            catch (SqlException e)
            {
                
            }
            finally
            {
                cnn.Close();
            }
            return employee;
        }

        public bool ChangePassword(string username, string password)
        {
            string sql = "Update Employee Set EmpPassword=@Password Where EmpID=@ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@Password", password);
            cmd.Parameters.AddWithValue("@ID", username);
            
            if (cnn.State == ConnectionState.Closed)
            {
                cnn.Open();
            }
            return (cmd.ExecuteNonQuery() > 0);
        }
    }
}
