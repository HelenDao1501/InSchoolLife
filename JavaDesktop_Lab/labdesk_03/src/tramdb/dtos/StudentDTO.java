package tramdb.dtos;

import java.sql.Date;



/**
 *
 * @author yiyangqianxi
 */
public class StudentDTO {

    String studentID;
    String fullName;
    String phone;
    String email;
    String address;
    Date dateOfBirth;
    boolean isDelete;
    String majorID;

    public StudentDTO() {
        
    }

    public StudentDTO(String studentID, String fullName, String phone, String email, String address, Date dateOfBirth, boolean isDelete, String majorID) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.isDelete = isDelete;
        this.majorID = majorID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

}
