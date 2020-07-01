package top.ss007.reflection.javaTypeSystem;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by Ben.Wang on 2019/4/26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ANNOTATION_TYPE, CONSTRUCTOR, FIELD,
        METHOD, PACKAGE, PARAMETER, TYPE, TYPE_PARAMETER, TYPE_USE})
public @interface Custom {
}
