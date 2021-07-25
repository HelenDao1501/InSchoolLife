import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RsvMgt {
    private IService service;

    private List<Laptop> laptops = new ArrayList<Laptop>();
    //list of reservation
    private Map<String,Laptop> rsv = new HashMap<String , Laptop>();

    public List<Laptop> getListOfLaptop(){
        laptops = service.get();
        return laptops;
    }
    public void makeRsv(Cust c, Laptop laptop) throws Exception
    {
        if(c!=null) {
            if (laptops.contains(laptop)) {
                if(getProRsv(c.getName())!=null){
                    throw new Exception("Customer already make reservation");
                }else{
                    rsv.put(c.getName(), laptop);
                }

            }
        }
    }
    public Laptop getProRsv(String custName){
        return rsv.get(custName);
    }

}
