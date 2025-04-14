package z_multi_thread;

/**
 * 懒汉式-静态内部类
 */
public class SingletonDesignV1 {
    private SingletonDesignV1() {

    }

    private static class InstanceHolder {
        private static final SingletonDesignV1 instance = new SingletonDesignV1();
    }

    public static SingletonDesignV1 getInstance() {
        return InstanceHolder.instance;
    }
}
