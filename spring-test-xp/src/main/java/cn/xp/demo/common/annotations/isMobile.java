package cn.xp.demo.common.annotations;

import cn.xp.demo.component.isMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {isMobileValidator.class})
public @interface isMobile {
    boolean required() default true;

    String message() default "请绑定手机号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
