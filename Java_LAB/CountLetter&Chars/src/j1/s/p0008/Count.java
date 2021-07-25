package j1.s.p0008;

import java.util.HashMap;
import java.util.Map; 
import java.util.Scanner;
import java.util.StringTokenizer;

public class Count {
    //xai charmap + wordmap
    Map<Character, Integer> charCounter = new HashMap<>();
    Map<String, Integer> wordCounter = new HashMap<>();

    public void display() {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }
    
    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) 
                continue;
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1); //nếu chưa có key thì nó sẽ thêm vào 1 key mới
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1); //có key rồi thì auto cộng cho key có sẵn
            }
        }
        
       //dung phan tach chuoi thanh cac pt
       //bo khoang trang space
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter your content: ");
            String content = sc.nextLine();      
            Count counter = new Count();
            counter.analyze(content);
            counter.display();
            do {
                System.out.println("Do you wanna continue ?");
                choice = sc.nextLine();
                if (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")) {
                    System.err.println("Just Y or N");
                }
            } while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));     
        } while (!choice.equalsIgnoreCase("N"));
        
        
    }
}

