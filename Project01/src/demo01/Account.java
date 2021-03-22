package demo01;

public class Account {
    private String type;//记录"收入"或"支出"
    public static int balance = 10000;//余额
    private int money;//本次金额
    private String description;//收支说明


    public Account() {
    }
    public Account(String type,int balance,int money,String description){
        this.type = type;
        this.balance = balance;
        this.money = money;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return type + "\t" + balance + "\t" + money + "\t" + description +"\n";
    }
}
