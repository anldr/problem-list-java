package z_multi_thread;

/**
 * 饿汉式
 */
public class SingletonDesignV3 {
    private static SingletonDesignV3 instance = new SingletonDesignV3();

    private SingletonDesignV3() {

    }

    public static SingletonDesignV3 getInstance() {
        return instance;
    }
}
