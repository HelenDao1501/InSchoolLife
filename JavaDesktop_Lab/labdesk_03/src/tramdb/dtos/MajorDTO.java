package tramdb.dtos;

/**
 *
 * @author yiyangqianxi
 */
public class MajorDTO {

    String majorName;
    String majorID;


    public MajorDTO() {
      
    }

    public MajorDTO(String majorName, String majorID) {
        this.majorName = majorName;
        this.majorID = majorID;
        

    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    

}
