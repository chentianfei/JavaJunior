package manager.view;

import manager.CustomerList.CustomerList;
import manager.bean.Customer;
import manager.util.Utility;

public class View {
    private CustomerList customerList = new CustomerList(20);

    public View(){}
    public View(CustomerList customerList){
        this.customerList = customerList;
    }

    public static void main(String[] args) {

    }

    public void enterMainMenu() {

        boolean isFlag = true;

        do {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            // 从键盘获取用户1-5的选择
            char menu = Utility.readMenuSelection();
            // 使用switch-case对用户的选择，进行区别处理
            switch (menu) {
                case '1':
                    addCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char exit = Utility.readConfirmSelection();
                    if (exit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }

        } while (isFlag);

    }





/*    public static void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        Customer customer = null;
        int index = 0;

        //判断有没有用户输入的那个人
        while (true){
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = Utility.readNum();
            if(index == -1){
                return;
            }
            customer = customerList.getCustomer(index-1);
            if(customer == null){
                System.out.println("查无此人，请输入正确的客户编号");
                continue;
            }else{
                break;
            }
        }

        //已经确定用户输入的人存在的情况下，执行以下操作

        System.out.print("请输入姓名（" + customer.getName() + "）:");
        customer.setName(Utility.readString(4,customer.getName()));//最大长度为20，如果没有输入就是原来的名字

        System.out.print("请输入性别（" + customer.getGender() + "）:");
        customer.setGender(Utility.readChar(customer.getGender()));//如果没有输入就是原来的性别

        System.out.print("请输入年龄（" + customer.getAge() + "）:");
        customer.setAge(Utility.readNum(customer.getAge()));//如果没有输入就是原来的年龄

        System.out.print("请输入电话（" + customer.getPhone() + "）:");
        customer.setPhone(Utility.readString(20,customer.getPhone()));//如果没有输入就是原来的电话

        System.out.print("请输入邮箱（" + customer.getEmail() + "）:");
        customer.setEmail(Utility.readString(20,customer.getEmail()));//如果没有输入就是原来的邮箱

        //将customer替换原来位置（index-1）的数组元素
        boolean result_replace = customerList.replaceCustomer(index-1,customer);
        if (result_replace) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("---------------------修改失败---------------------");
        }
    }*/

    public static void addCustomer(){
        System.out.println("---------------------添加客户---------------------");

        Customer customer =  new Customer();
        System.out.print("请输入姓名");
        customer.setName(Utility.readString(20,customer.getName()));//最大长度为20，如果没有收入就是原来的名字
        System.out.print("请输入性别");
        customer.setGender(Utility.readChar(customer.getGender()));//如果没有收入就是原来的性别
        System.out.print("请输入年龄");
        customer.setAge(Utility.readNum(customer.getAge()));//如果没有收入就是原来的年龄
        System.out.print("请输入电话");
        customer.setPhone(Utility.readString(20,customer.getPhone()));//如果没有收入就是原来的电话
        System.out.print("请输入邮箱");
        customer.setEmail(Utility.readString(20,customer.getEmail()));//如果没有收入就是原来的邮箱

        boolean flag = customerList.addCustomer(customer);
        if (flag) {
            System.out .println("---------------------添加完成---------------------");
        } else {
            System.out.println("人数已达上限，添加失败！");
        }

    }

    /**
     * 修改指定索引位置的客户信息
     */
    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        Customer customer;
        int index;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = Utility.readNum();
            if (index == -1) {
                // break;//不能使用break
                return;
            }
            // 对于用户来讲，我们让index 默认从1开始。
            customer = CustomerList.getCustomer(index - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        // 修改用户的信息
        System.out.print("姓名(" + customer.getName() + "):");
        // 如果用户输入了姓名，则返回用户输入的信息，如果用户没有输入，直接回车，则返回customer.getName()
        String name = Utility.readString(5, customer.getName());

        System.out.print("性别(" + customer.getGender() + "):");
        char gender = Utility.readChar(customer.getGender());

        System.out.print("年龄(" + customer.getAge() + "):");
        int age = Utility.readNum(customer.getAge());

        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = Utility.readString(13, customer.getPhone());

        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = Utility.readString(15, customer.getEmail());
        // 获取用户输入的属性以后，得到的最新的Customer对象
        customer = new Customer(name, gender, age, phone, email);
        // 对于用户来讲，我们让index 默认从1开始。
        boolean flag = customerList.replaceCustomer(index - 1, customer);
        if (flag) {
            System.out
                    .println("---------------------修改完成---------------------");
        } else {
            System.out
                    .println("---------------------修改失败---------------------");
        }

    }

    /**
     * 删除指定索引位置的客户
     */
    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        Customer customer;
        int index;
        for (;;) {

            System.out.print("请选择待删除客户编号(-1退出)：");
            // 针对普通用户来讲：此index从 1开始
            index = Utility.readNum();
            if (index == -1) {
                return;
            }

            customer = CustomerList.getCustomer(index - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }

        // 一旦找到相应的索引位置的customer以后，让用户决定是否确认删除
        System.out.print("确认是否删除(Y/N)：");
        char deleteOrNot = Utility.readConfirmSelection();
        if (deleteOrNot == 'Y') {
            boolean flag = customerList.deleteCustomer(index - 1);
            if (flag) {
                System.out
                        .println("---------------------删除完成---------------------");
            } else {
                System.out
                        .println("---------------------删除失败---------------------");
            }
        } else {
            return;
        }
    }

    /**
     * 获取客户列表
     */
    private void listAllCustomers() {
        System.out
                .println("---------------------------客户列表---------------------------");
        // 获取所有的客户
        Customer[] customers = custList.getAllCustomers();
        if (customers.length == 0) {
            System.out.println("没有任何客户记录！");

        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            for (int i = 0; i < customers.length; i++) {
                Customer cust = customers[i];
                // 方式一：
                // System.out.println((i + 1) + "\t" + cust.getName() + "\t"
                // + cust.getGender() + "\t" + cust.getAge() + "\t"
                // + cust.getPhone() + "\t\t" + cust.getEmail());
                // 方式二：
                System.out.println((i + 1) + "\t" + cust.info());

            }
        }
        System.out
                .println("-------------------------客户列表完成-------------------------");

    }

}
