package z_multi_thread;

/**
 * 双重校验锁
 */
public class SingletonDesignV4 {
    private volatile static SingletonDesignV4 instance;

    private SingletonDesignV4() {

    }

    public static SingletonDesignV4 getInstance() {
        if (instance == null) {
            synchronized (SingletonDesignV4.class) {
                if (instance == null) {
                    instance = new SingletonDesignV4();
                }
            }
        }
        return instance;
    }
}
