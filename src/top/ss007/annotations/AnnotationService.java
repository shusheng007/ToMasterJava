package top.ss007.annotations;

import java.lang.annotation.Annotation;

public class AnnotationService {

    public void checkAnnotation() {
        Annotation[] annotations = Questioner.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof ShuSheng) {
                System.out.println(((ShuSheng) annotation).name() + ": " + ((ShuSheng) annotation).value().value());
            }
        }
    }


}
