package manager.util;

import java.awt.font.LineMetrics;
import java.util.Scanner;

/**
 * CMUtility工具类：
 * 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，而无需考虑具体的功能实现细节。
 */
public class Utility {

    private static final Scanner sc = new Scanner(System.in);


    /**
     * 获取键盘输入内容的原始方法
     *
     * @param limit       最长输入长度
     * @param blankReturn 看允不允许返回没有内容的字符串，用于在后续修改客户信息时如果有字段不修改的话就敲回车返回空内容，而进入下一字段
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {

        String line = "";

        while (sc.hasNext()) {
            line = sc.nextLine();

            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else continue;
            }

            if (line.length() > limit || line.length() < 1) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }

            break;
        }

        return line;

    }

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            c = readKeyBoard(1, false).charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            }
            break;
        }
        return c;
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。
     */
    public static char readChar() {
        return readKeyBoard(1, false).charAt(0);
    }

    /**
     * readChar()的重载
     * 从键盘读取一个字符，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     */
    public static int readNum() {
        String str = readKeyBoard(2, false);
        while (true) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("请输入合法数字" + e);
            }
        }

    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static int readNum(int defaultValue) {
        String str;

        while (true) {

            str = readKeyBoard(2, true);

            if (str.equals("")) {
                return defaultValue;
            }

            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }

        }
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        System.out.println(str);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection() {
        char c;

        while (true) {
            c = readKeyBoard(1, false).toUpperCase().charAt(0);
            if (c != 'Y' && c != 'N') {
                System.out.print("选择错误，请重新输入：");
                continue;
            }
            break;
        }

        return c;
    }


}
