package cn.xp.demo.service;

public interface IPay {
    boolean support(String code);
    void pay();
}
