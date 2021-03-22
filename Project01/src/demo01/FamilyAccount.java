package demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyAccount {
    private static int startMoney = 10000;
    private static List<Account> accounts = new ArrayList<Account>();//明细集合

    public static void main(String[] args) {

        boolean isFlag = true;

        while (isFlag){
            System.out.println("\n-----------------家庭收支记账软件-----------------\n");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退    出\n");
            System.out.print("                   请选择(1-4)：");

            char selection = Utility.readMenuSelection();
            switch (selection){
                case '1':
                    showAccountInfo(accounts);
                    break;

                case '2':
                    System.out.print("本次收入金额：");
                    int incomeMoney = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String incomeDesc = Utility.readDescription();
                    income(incomeDesc,incomeMoney);
                    break;

                case '3':
                    System.out.print("本次支出金额：");
                    int expendMoney = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String expendDesc = Utility.readDescription();
                    expend(expendDesc,expendMoney);
                    break;

                case '4':
                    System.out.print("确认退出，确认输入Y，取消请输N");
                    if (Utility.readComfirmSelection() == 'Y'){
                        isFlag = false;
                    }
                    break;
            }

        }

    }

    //显示明细信息
    public static void showAccountInfo(List<Account> accounts){
        System.out.println("-----------------当前收支明细记录-----------------");
        System.out.println("收支\t账户金额\t收支金额\t说    明\n");
        //遍历账户明细，显示账户明细内容
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            System.out.println(account);
        }
        System.out.println();
        System.out.println("---------------------------------------------");
    }

    //支出，将支出信息制作成account对象，装入accounts
    public static void expend(String description,int money){
        if(Account.balance >= money){
            Account account1 = new Account("支出",Account.balance-money,money,description);
            accounts.add(account1);

            //显示当前收支明细记录
            System.out.println(account1.getType() + "\t" + account1.getBalance() + "\t" +
                    account1.getMoney() + "\t" + account1.getDescription()+ "\n");
            System.out.println("---------------------登记完成-------------------");
        }else {
            System.out.println("余额不足，支出失败");
        }

    }

    //收入，将收入信息制作成account对象，装入accounts
    public static void income(String description,int money){
        Account account1 = new Account("收入",Account.balance+money,money,description);
        accounts.add(account1);
        //显示当前收支明细记录
        System.out.println(account1.getType() + "\t" + account1.getBalance() + "\t" +
                account1.getMoney() + "\t" + account1.getDescription()+ "\n");
        System.out.println("---------------------登记完成-------------------");
    }
}
