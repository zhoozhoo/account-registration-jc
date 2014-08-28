package ca.zhoozhoo.ar.validation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class PasswordsEqualValidator implements ConstraintValidator<PasswordsEqual, Object> {

	private String firstPasswordName;

	private String secondPasswordName;

	@Override
	public void initialize(PasswordsEqual constraintAnnotation) {
		firstPasswordName = constraintAnnotation.first();
		secondPasswordName = constraintAnnotation.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils.getProperty(value, firstPasswordName);
			final Object secondObj = BeanUtils.getProperty(value, secondPasswordName);

			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addPropertyNode(secondPasswordName).addConstraintViolation().disableDefaultConstraintViolation();

			return ((firstObj == null) && (secondObj == null)) || ((firstObj != null) && firstObj.equals(secondObj));
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			System.out.println(e.toString());
		}

		return true;
	}
}
