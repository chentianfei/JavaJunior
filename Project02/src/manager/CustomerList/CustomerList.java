package manager.CustomerList;

import manager.bean.Customer;

/**
 * 内部封装一个Customer[],提供对Customer数据的增删改查操作
 * @author tianfeichen
 *
 */

public class CustomerList {
    private static Customer[] customers;
    private static int total;


    public CustomerList(){}
    /**
     * 构造器，用来初始化customers数组
     * @param totalCustomer : 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        this.customers = new Customer[totalCustomer];
    }


    /**
     * 添加指定的客户到数组中
     * @param cust
     * @return 添加是否成功
     */
    public static boolean addCustomer(Customer cust){
        if(total > customers.length){
            return  false;
        }

        customers[total++] = cust;
        return true;
    }

    /**
     * 替换指定索引位置上的数组元素
     * @param index 从0开始
     * @param cust
     * @return
     */
    public static boolean replaceCustomer(int index,Customer cust){
        if(index>=total || index<0){
            return false;
        }

        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定索引位置上的元素
     * @param index 从0开始
     * @return
     */
    public static boolean deleteCustomer(int index){
        if(index>=total || index<0){
            return false;
        }

        for(int i = index;i < total-1;i++){
            customers[i]  = customers[i+1];
        }
        total--;
        return true;
    }


    /**
     * 获取所有的customers对象构成的数组
     * @return
     */
    public static Customer[] getCustomers(){
        Customer[] custs = new Customer[total];

        for (int i = 0;i < total; i++){
            custs[i] = customers[i];
        }

        return custs;
    }

    /**
     * 返回指定索引位置上的Customer
     * @param index
     * @return 如果输入的index位置上的元素不存在，返回null
     */
    public static Customer getCustomer(int index){
        if(index<0 || index>total){
            return null;
        }

        return customers[index];
    }

    /**
     * 返回Customer对象的个数
     * @return
     */
    public static int getTotal(){
        return total;
    }


}
