package basic;

public class Base {

    private static Instance instance = new Instance("Base静态变量初始化");

    private Instance instance2 = new Instance("Base成员变量初始化");

    static {
        System.out.println("执行Base静态代码块");
    }

    {
        System.out.println("执行Base实例代码块");
    }

    public Base() {
        System.out.println("执行Base构造方法");
    }

    void test() {
        System.out.println("test");
    }
}
