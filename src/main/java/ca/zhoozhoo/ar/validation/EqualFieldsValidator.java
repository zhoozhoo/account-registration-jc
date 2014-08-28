package ca.zhoozhoo.ar.validation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

	private String firstFieldName;

	private String secondFieldName;

	@Override
	public void initialize(EqualFields constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			final Object firstField = BeanUtils.getProperty(value, firstFieldName);
			final Object secondField = BeanUtils.getProperty(value, secondFieldName);

			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addPropertyNode(secondFieldName).addConstraintViolation().disableDefaultConstraintViolation();

			return ((firstField == null) && (secondField == null)) || ((firstField != null) && firstField.equals(secondField));
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			System.out.println(e.toString());
		}

		return true;
	}
}
