package tramdb.ui;

import javax.swing.table.AbstractTableModel;
import tramdb.daos.MajorDAO;
import tramdb.dtos.StudentDTO;
import tramdb.dtos.StudentList;

/**
 *
 * @author yiyangqianxi
 */
public class StudentModel extends AbstractTableModel {

    StudentList list;

    public StudentModel(StudentList list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj = null;
        StudentDTO stu = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                obj = stu.getStudentID();
                break;
            case 1:
                obj = stu.getFullName();
                break;
            case 2:
                MajorDAO marDAO = new MajorDAO();
                String name = null;
                try {
                    name = marDAO.findMajorNameByID(stu.getMajorID());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                obj = stu.getMajorID() + "-" + name;
                break;
            case 3:
                obj = stu.getPhone();
                break;
            case 4:
                obj = stu.getEmail();
                break;
            case 5:
                obj = stu.getAddress();
                break;
            case 6:
                obj = stu.getDateOfBirth();
                break;
            case 7:
                obj = stu.isIsDelete();
        }
        return obj;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "StudentID";
                break;
            case 1:
                columnName = "Fullname";
                break;
            case 2:
                columnName = "Major";
                break;
            case 3:
                columnName = "Phone";
                break;
            case 4:
                columnName = "Email";
                break;
            case 5:
                columnName = "Address";
                break;
            case 6:
                columnName = "DOB";
                break;
            case 7:
                columnName = "IsDelete";
                break;
        }
        return columnName;
    }

}
