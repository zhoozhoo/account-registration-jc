package ca.zhoozhoo.ar.view;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ca.zhoozhoo.ar.repository.UserAccountRepository;
import ca.zhoozhoo.ar.validation.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userAccountRepository.findByUsername(value) == null;
	}
}
