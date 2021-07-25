import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.Collections;

public class ReservationTest {

    @Mock
    private IService service;
    @InjectMocks
    private RsvMgt rsvMgt;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void ListLaptopNullTest() throws Exception {
        BDDMockito.given(service.get()).willReturn(Collections.<Laptop>emptyList());
        Cust c = new Cust(001,"cuong","quan 9", "0123456");
        Laptop laptop = new Laptop("001",123,"G3" ,"Dell");
        rsvMgt.makeRsv(c,laptop);
        Assertions.assertNull(rsvMgt.getProRsv(c.getName()));
    }

    @Test
    void notChoseAnyLaptopTest() throws Exception {
        BDDMockito.given(service.get()).willReturn(Arrays.asList(
                new Laptop("001",123,"G3" ,"Dell"),
                new Laptop("002",2665,"G7" , "Dell")
        ));
        Cust c = new Cust(001,"cuong","quan 9", "0123456");
        rsvMgt.makeRsv(c,null);
        Assertions.assertNull(rsvMgt.getProRsv(c.getName()));
    }
    @Test
    void chooseALaptop() throws Exception {
        BDDMockito.given(service.get()).willReturn(Arrays.asList(
                new Laptop("001",123,"G3" ,"Dell"),
                new Laptop("002",2665,"G7" , "Dell")
        ));
        Cust c = new Cust(001,"cuong","quan 9", "0123456");
        rsvMgt.makeRsv(c,rsvMgt.getListOfLaptop().get(1));
        Assertions.assertNotNull(rsvMgt.getProRsv(c.getName()));
    }

    @Test
    void choose2Laptop() throws Exception {
        try {
            BDDMockito.given(service.get()).willReturn(Arrays.asList(
                    new Laptop("001", 123, "G3", "Dell"),
                    new Laptop("002", 2665, "G7", "Dell")
            ));
            Cust c = new Cust(001, "cuong", "quan 9", "0123456");
            rsvMgt.makeRsv(c, rsvMgt.getListOfLaptop().get(0));
            rsvMgt.makeRsv(c, rsvMgt.getListOfLaptop().get(1));
        }
        catch (Exception ex){
            Assertions.assertEquals("Customer already make reservation",ex.getMessage());
        }

    }
    @Test
    void custNulltest() throws Exception{

        try {
            BDDMockito.given(service.get()).willReturn(Arrays.asList(
                    new Laptop("001",123,"G3" ,"Dell"),
                    new Laptop("002",2665,"G7" , "Dell")
            ));
            Cust c = null;
            rsvMgt.makeRsv(c,rsvMgt.getListOfLaptop().get(1));
            Assertions.assertNull(rsvMgt.getProRsv(c.getName()));
        }
        catch (Exception ex){
            Assertions.assertEquals(NullPointerException.class,ex.getClass());
        }
    }

}
