package j1.s.p0011;

public class NumberManager {
    MyUtils utl = new MyUtils();
    
    public static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7'
            ,'8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    public int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        int result = utl.choiceUsing(2, "Input your choice: ", "Please input again!Only 1 or 2!", "Please input again!");
        return result;
    }
    
    public void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: " + convertBinaryToDecimal(binary));
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertBinaryToHexa(binary));
                break;
        }
    }
    
    public void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertDecimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertDecimalToHexa(decimal));
                break;
        }
    }

    public void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertHexaToBinary(hexa));
                break;
            case 2:
                System.out.println("Decimal: " + convertHexaToDecimal(hexa));
                break;
        }
    }
    
    public String convertBinaryToDecimal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toString(decimal);
    }
    
    public String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }
    
    public String convertDecimalToHexa(String decimal) {
        String hexa = Integer.toHexString(Integer.parseInt(decimal));
        return hexa;
    }
    
    public String convertDecimalToBinary(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }
    
    public String convertHexaToBinary(String hexadecimal) {
        String binary = Integer.toBinaryString(convertHexaToDecimal(hexadecimal));
        return binary;
    }
    
    public int convertHexaToDecimal(String hexadecimal) {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return decimal;
    }    
}
