package com.xiong.EnumDemo;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/29 17:54
 * @description： 枚举 Demo 类
 * @modified By：
 * @version: $
 */
public enum ErrorCodeEn {  // 隐式继承了 java.lang.Enum 类  所以 枚举不能被继承

    OK(0){
        @Override
        public String getDescription() {
            return "成功";
        }
    },
    ERROR_A(100){
        @Override
        public String getDescription() {
            return "错误 A";
        }
    },
    ERROR_B(200){
        @Override
        public String getDescription() {
            return "错误 B";
        }
    };  // 枚举之间 逗号，隔开  分号； 结束

    private int code;
    // 构造方法：enum的构造方法只能被声明为private权限或不声明权限
    private ErrorCodeEn(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public abstract String getDescription();


    public static void main(String[] args) {
        for (ErrorCodeEn s: ErrorCodeEn.values()) {
            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
        }
    }
}
