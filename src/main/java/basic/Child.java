package basic;

public class Child extends Base {

    private static Instance instance = new Instance("Child静态变量初始化");

    private Instance instance2 = new Instance("Child成员变量初始化");

    static {
        System.out.println("执行Child静态代码块");
    }

    {
        System.out.println("执行Child实例代码块");
    }

    public Child() {
        System.out.println("执行Child构造方法");
    }

    public static void main(String[] args) {
        Base base = new Child();
        base.test();
    }
}
