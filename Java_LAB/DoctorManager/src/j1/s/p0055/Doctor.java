package j1.s.p0055;


public class Doctor {
    String code;
    String name;
    String Spec;
    int avail;
    
    public Doctor(){
        code="";
        name="";
        Spec="";
        avail=0;
    }
    
    public Doctor(String code, String name, String Spec, int avail) {
        this.code = code;
        this.name = name;
        this.Spec = Spec;
        this.avail = avail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return Spec;
    }

    public void setSpec(String Spec) {
        this.Spec = Spec;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }
    
    @Override
    public String toString() {
        return code + "\t" + name + "\t" + Spec + "\t" + avail;
    }   
}
