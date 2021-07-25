
import static tram.util.MathUtil.computerFactorial;

public class Main {
    public static void main(String[] args) {
        System.out.println("5! = " + computerFactorial(5));
        
        //expected: hàm ơi, tao hi vọng m ói về 120 khi đưa 5 cho mày 
        System.out.println("5! = " + computerFactorial(5));
        
        //expected: hàm ơi, tao hi vọng m ói về 720 khi đưa 6 cho mày 
        System.out.println("6! = " + computerFactorial(6));
        //expected: hàm ơi, tao hi vọng m ói về 1 khi đưa 0 cho mày 
        System.out.println("0! = " + computerFactorial(0));
        //expected: hàm ơi, tao hi vọng m ói về 1 khi đưa 0 cho mày
        System.out.println("1! = " + computerFactorial(1));
        //expected: hàm ơi, tao hi vọng m ói về NGOẠI LỆ khi đưa -5 cho mày
        System.out.println("-5! = " + computerFactorial(-5));
        
        
        //phần code của hàm main() ta đang viết kiểu này gọi là test app
        //xem thử xem cái hàm cF() tính giai thừa chạy có đúng không
        //để test phần mềm ta làm việc sau:
        //1. chuẩn bị data, ví dụ 5, 6, 7, 0, 1, 2
        //2. tính toán trước bằng tay xem 5! là mấy, 6! là mấy, 0! là mấy
        //ví dụ tính trước đc rằng 6! là 720, 720 gọi là giá trị kì vọng EXPECTED VALUE
        
        //3. gọi lệnh, gọi app, gọi hàm chạy thử với data đã chuẩn bị 
        //coi xem hàm trả về số mấy kết quả mấy
        //ví dụ khi chạy hàm cF(6)  mà nó trả về 120, thì giá trị trả về
        //khi chạy hàm gọi là ACTUAL VALUE
        
        //4. cái hồi, mình phải so sánh xem EXPECTED VÀ ACTUAL có trùng nhau hay ko
        //nếu trùng: tức là hàm 
        
        
        //cách test này đơn giản nhưng chưa hay
        //vì: mình nhìn kết quả bằng mắt, tự so sánh giữa giá trị trả về của hàm
        //và kì vọng
        //thêm nữa nó ko cấm mình disable nút clean & build
        //code sai logic mà vẫn ra file .jar, .war
        //ta cần 1 cách khác để đảm bảo chất lượng code ngay khi viết code
        //ta cần dùng them thu vienj phụ trợ giúp kiểm soát chất lượng code
        //đó là kt TDD kèm Unit testing
        //xài thư viện JUnit, NUnit, TestNG, xUnit, MSUnit, PHPUnit, CPPUnit,...
        //những thư viện này ko bắt mình phải so sánh bằng mắt các actual vs e
    }
}
