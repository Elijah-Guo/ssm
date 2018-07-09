package cn.itheima.binge.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//运行期有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {
    String value();
}
