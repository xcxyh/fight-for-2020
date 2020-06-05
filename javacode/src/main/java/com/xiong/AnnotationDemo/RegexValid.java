package com.xiong.AnnotationDemo;


import java.lang.annotation.*;
/**
 *  @author: xiongcong
 *  @Date: 2020/5/29 13:45
 *  @Description:  自定义的 正则表达式检查 注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface RegexValid {

    enum Policy{
        EMPTY(null),
        DATE("^(?:(?!0000)[0-9]{4}([-/.]?)(?:(?:0?[1-9]|1[0-2])\\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\\1"
                + "(?:29|30)|(?:0?[13578]|1[02])\\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|"
                + "(?:0[48]|[2468][048]|[13579][26])00)([-/.]?)0?2\\2(?:29))$"),
        MAIL("^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$");
        // @formatter:on

        private String policy;

        Policy(String policy) {
            this.policy = policy;
        }

        public String getPolicy() {
            return policy;
        }

    }

    //[访问级别修饰符public or default] [数据类型] 名称() default 默认值;
    //注解属性只能使用 public 或默认访问级别（即不指定访问级别修饰符）修饰。
    String value() default "";
    Policy policy() default Policy.EMPTY;

}
