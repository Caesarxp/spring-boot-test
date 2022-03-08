package cn.xp.demo.thread;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2020/11/3 11:02
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class UserThreadLocal {

    static   ThreadLocal<String> str = new ThreadLocal<>();
    public String getStr() {return str.get();}
    public void setStr(String j) {str.set(j);}
    public static void main(String[] args) {
        UserThreadLocal userThreadLocal = new UserThreadLocal();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized (UserThreadLocal.class) {
                        userThreadLocal.setStr(Thread.currentThread().getName() + "的数据");
                        System.out.println(Thread.currentThread().getName() + " 编号 " + userThreadLocal.getStr());
//                    }
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
