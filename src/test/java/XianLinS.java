public class XianLinS {
    public static void main(String[] args) {
        printChars("\uD835\uDCEB\uD835\uDCF8\uD835\uDCFD、");
    }
    public static void printChars() {
        //--在控制台打印出数值为33~126的char类型数据"char ->int"
        System.out.println("===Char数据33开始===");
        for (int i = 33; i <= 126; i++) {
            System.out.println((char) i + " ->" + i);
        }
        System.out.println("===Char数据126结束===");
    }
    
    public static void printChars(String chars) {
        //--在控制台打印出chars字符串每个字符的char类型数据"char ->int"
        System.out.println("===Char数据打印开始===");
        for (int i = 0; i < chars.length(); i++) {
            System.out.println(chars.charAt(i) + " ->" + (int) chars.charAt(i));
        }
        System.out.println("===Char数据打印结束===");
    }
    
    public static void printChars(int... ints) {
        //--在控制台打印出int数组里每个数值代表的char类型数据"char ->int"
        System.out.println("===Char数据打印开始===");
        for (int aChar : ints) {
            System.out.println((char) aChar + " ->" + aChar);
        }
        System.out.println("===Char数据打印结束===");
    }
}
