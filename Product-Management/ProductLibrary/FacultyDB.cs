using System;
using System.Collections;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductLibrary
{
    public class FacultyDB
    {
        string strConnection;

        public FacultyDB()
        {
            strConnection = "server=.;database=PE02;uid=sa;pwd=123";
        }

        public List<Faculty> GetFacultyList()
        {
            String sql = "SELECT * FROM Faculty";
            SqlConnection con = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, con);
            List<Faculty> FacultyList = new List<Faculty>();
            try
            {
                if (con.State == ConnectionState.Closed)
                {
                    con.Open();
                }
                SqlDataReader dr = cmd.ExecuteReader(CommandBehavior.CloseConnection);
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        int ID = dr.GetInt32(0);
                        string Name = dr.GetString(1);
                        int Age = dr.GetInt32(2);
                        string Address = dr.GetString(3);
                        FacultyList.Add(new Faculty
                        {
                            FacultyID = ID,
                            FullName = Name,
                            Age = Age,
                            Address = Address
                        });
                    }
                }
            }
            catch (SqlException e)
            {
                throw new Exception(e.Message);
            }
            finally
            {
                con.Close();
            }
            return FacultyList;
        }
        

        public bool AddNewFaculty(Faculty faculty)
        {
            string SQL = "Insert Faculty values(@ID, @Name, @Age, @Address)";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            cmd.Parameters.AddWithValue("@ID", faculty.FacultyID);
            cmd.Parameters.AddWithValue("@Name", faculty.FullName);
            cmd.Parameters.AddWithValue("@Age", faculty.Age);
            cmd.Parameters.AddWithValue("@Address", faculty.Address);
            if (cnn.State == ConnectionState.Closed)
            {
                cnn.Open();
            }
            return (cmd.ExecuteNonQuery() > 0);
        }

        public bool UpdateFaculty(Faculty faculty)
        {
            string SQL = "Update Faculty set FullName=@Name, Age=@Age," +
                "Address=@Address where FacultyID=@ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            cmd.Parameters.AddWithValue("@ID", faculty.FacultyID);
            cmd.Parameters.AddWithValue("@Name", faculty.FullName);
            cmd.Parameters.AddWithValue("@Age", faculty.Age);
            cmd.Parameters.AddWithValue("@Address", faculty.Address);
            if (cnn.State == ConnectionState.Closed)
            {
                cnn.Open();
            }
            return (cmd.ExecuteNonQuery() > 0);
        }

        public bool DeleteFaculty(Faculty faculty)
        {
            string SQL = "Delete Faculty where FacultyID=@ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            cmd.Parameters.AddWithValue("@ID", faculty.);
            if (cnn.State == ConnectionState.Closed)
            {
                cnn.Open();
            }
            return (cmd.ExecuteNonQuery() > 0);
        }

        public Faculty FindFaculty(int FacultyID)
        {
            string SQL = "Select * From Faculty where FacultyID=@ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            cmd.Parameters.AddWithValue("@ID", FacultyID);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                SqlDataReader dr = cmd.ExecuteReader(CommandBehavior.CloseConnection);
                if (dr.Read())
                {
                    int ID = dr.GetInt32(0);
                    string Name = dr.GetString(1);
                    int Age = dr.GetInt32(2);
                    string Address = dr.GetString(3);
                    Faculty faculty = new Faculty()
                    {
                        FacultyID = ID,
                        FullName = Name,
                        Age = Age,
                        Address = Address
                    };
                    return faculty;
                }
            }
            catch (SqlException se)
            {
                throw new Exception(se.Message);
            }
            finally
            {
                cnn.Close();
            }
            
            return null;
        }
    }
}
