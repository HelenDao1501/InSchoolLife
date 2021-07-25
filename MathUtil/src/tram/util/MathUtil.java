
package tram.util;

/**
 *
 * @author yiyangqianxi
 */
//class chứa các hàm tiện ích hỗ trợ các phép tính toán
//do đó chúng mày sẽ là static
public class MathUtil {
    //hàm giai thừa n!= 1.2.3...n bùng nôt kết quả rất nhanh 
    //nên tràn int (2 tỉ 1) sớm, ta trrarvefe long cỡ 15! hoy
    public static long computerFactorial(int n){
        if(n < 0 || n > 15)
            throw new IllegalArgumentException("Invalid argument, n must be >= 0 & <= 15");
        
        if(n == 0 || n == 1)
            return 1; //diem dung cua giai thua
        return n * computerFactorial(n - 1);
        /*long result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
        }
        return result;*/
        
    }
    
}
