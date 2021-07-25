package tdd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tram.util.MathUtil;

/**
 *
 * @author yiyangqianxi
 */
public class MathUtilTest {
    
    @Test
    public void testSuccessfulCases(){
        //hàm này test những tình huống thành công, tức là đưa đầu vào tử tế cho hàm cF()
        //Assert.assertEquals(55, 55);
        assertEquals(1, MathUtil.computerFactorial(0));
        assertEquals(1, MathUtil.computerFactorial(1));
        assertEquals(2, MathUtil.computerFactorial(2));
        assertEquals(6, MathUtil.computerFactorial(3));
        assertEquals(24, MathUtil.computerFactorial(4));
        assertEquals(120, MathUtil.computerFactorial(5));
    }
    
    //mỗi @Test biến hàm thành một hàm main() riêng biệt và shift-f6 chạy 
    //cmt @Test phế hàm này thành hàm bt, ko đc chạy trong lần shift f6
    //trò này do thư viện JUnit nó bày ra, bày thêm màu sắc XANH ĐỎ nữa
    @Test(expected = IllegalArgumentException.class)
    //Test(expected = NumberFormatException.class)
    public void testFailedCases(){
        //hàm này test những tình huống cà chớn, tức là đưa đầu vào cà chớn
        //ví dụ cF(-5) sao mà tính đc, cF(20) to quá, tràn số của em mất
        //Ngoại lệ là 1 thứ ko thể so sánh 
        //Exception là 1 tình huống ko dự liệu được, do đó nó ko vó value
        //do đó ko thể so sánh được, ko thể xài hàm assertEquals()
        //vậy ta phải xài chiêu khác khi chơi vs ngoại lệ
        //tao kỳ vọng rằng khi đưa ra cF(-5) thì hàm cF()  mày sẽ ném ra cái 
        //ngoại lệ thông báo rằng tham số cà chớn
        //câu này viết thế nào trong code để ra đc mày xanh hay đỏ
        MathUtil.computerFactorial(-5);
    }
    /*public MathUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

//dù code bạn sai logic nhưng bạn vẫn ra được file.jar, .war khi clean & build
//nguy hiểm, không tốt tẹo nào
//ta sẽ chơi trò disable nút bấm clean & build nếu code còn đang màu đỏ
//tức là sai logic không như kì vọng
//chơi với JUnit thì làm được trò này
//chơi truyền thống sout() JOptionPane, ghi ra file log môn thầy Khánh. thua
//but any thing can buid file .jar .war
//hãy nhớ 2 con số: NB 8.2 1005.