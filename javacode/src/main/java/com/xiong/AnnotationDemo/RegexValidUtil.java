package com.xiong.AnnotationDemo;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/29 13:45
 * @description： @RegexValid 的注解处理器
 * @modified By：
 * @version: $
 */
public class RegexValidUtil {
    //静态方法 check
    public static boolean check(Object obj) throws Exception {
        boolean result = true;
        StringBuilder sb = new StringBuilder();
        //通过 getDeclaredFields 反射方法获取传入对象的所有成员。
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 判断当前类的所有成员中是否 有 被 @RegexValid 注解所修饰的 成员
            if (field.isAnnotationPresent(RegexValid.class)) {
                //获取该成员变量上的 该注解
                RegexValid regexValid = field.getAnnotation(RegexValid.class);
                //获取value
                // 如果 value 为空字符串，说明没有注入自定义正则表达式，改用 policy 属性
                String value = regexValid.value();
                if ("".equals(value)) {
                    RegexValid.Policy policy = regexValid.policy();
                    value = policy.getPolicy();
                }
                // 通过设置 setAccessible(true) 来访问私有成员
                field.setAccessible(true);
                // 校验 该 成员变量 是否可以被 RegexValid 注解 修饰
                // 或 是否 通过  RegexValid 校验
                Object fieldObj = null;
                try {
                    fieldObj = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (fieldObj == null) {
                    sb.append("\n")
                            .append(String.format("%s 类中的 %s 字段不能为空！", obj.getClass().getName(), field.getName()));
                    result = false;
                } else {
                    if (fieldObj instanceof String) {
                        String text = (String) fieldObj;
                        Pattern p = Pattern.compile(value);
                        Matcher m = p.matcher(text);
                        result = m.matches();
                        if (!result) {
                            sb.append("\n").append(String.format("%s 不是合法的 %s ！", text, field.getName()));
                        }
                    } else {
                        sb.append("\n").append(
                                String.format("%s 类中的 %s 字段不是字符串类型，不能使用此注解校验！", obj.getClass().getName(), field.getName()));
                        result = false;
                    }
                }

            }
        }

        if (sb.length() > 0) {  // 正则表达式 不合法
            throw new Exception(sb.toString());
        }
        return result;
    }

}
