package demo01;

import java.util.Scanner;

public class Utility {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * 从键盘读数据
     * @param num 最多读几个
     * @return 最大的字符串
     */
     public static String readkeybord(int num){
         String line = "";

         while (sc.hasNext()){
             line = sc.nextLine();
             if(line.length()<1 || line.length()>num){
                 System.out.println("输入长度有误（不大于" + num + "）请重新输入：");
             }else{
                 break;
             }

         }

         return line;
     }


    // 读数字 主要在读取金额时使用
    public static int readNumber(){
         int num;
         while (true){
             try {
                 num = Integer.parseInt(readkeybord(4));
                 break;
             }catch(NumberFormatException e){
                 System.out.println("请输入正确数字：" + e);
             }
         }

        return num;
    }
    // 读字符串 主要在读取说明内容时使用
    public static String readDescription(){
         return readkeybord(20);
    }
    // 读选择代码
    public static char readMenuSelection(){
        char c;
        while(true){
            c = readkeybord(1).charAt(0);
            if (c!='1' && c!='2' && c!='3' && c!='4'){
                System.out.println("请输入合法数字");
            }else{
                break;
            }
        }
        return c;
    }

    // 读退出确认码
    public static char readComfirmSelection(){
        char c;
        while (true) {
            c = readkeybord(1).toUpperCase().charAt(0);
            if (c=='Y' || c=='N'){
                break;
            }else{
                System.out.println("选择错误，请重新输入");
            }
        }

        return c;
    }

}
