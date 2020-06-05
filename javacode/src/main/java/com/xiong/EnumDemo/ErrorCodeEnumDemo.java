package com.xiong.EnumDemo;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/29 18:09
 * @description：
 * @modified By：
 * @version: $
 */
public class ErrorCodeEnumDemo {
    enum ErrorCode {
        OK(0, "成功"),
        ERROR_A(100, "错误A"),
        ERROR_B(200, "错误B");

        ErrorCode(int number, String msg) {
            this.code = number;
            this.msg = msg;
        }

        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        @Override
        public String toString() {
            return "ErrorCode{" + "code=" + code + ", msg='" + msg + '\'' + '}';
        }

        public static String toStringAll() {
            StringBuilder sb = new StringBuilder();
            sb.append("ErrorCodeEn All Elements: [");
            for (ErrorCodeEn code : ErrorCodeEn.values()) {
                sb.append(code.getCode()).append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        for (ErrorCode e : ErrorCode.values()) {
            System.out.println(e.toString());
        }
    }

}
