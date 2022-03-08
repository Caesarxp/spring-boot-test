package cn.xp.demo.thread;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2020/8/26 16:21
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class DemoThread implements Runnable {



    private String command;

    public DemoThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始时间 ： " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " 结束时间 ： " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "DemoThread{" +
                "command='" + command + '\'' +
                '}';
    }
}

