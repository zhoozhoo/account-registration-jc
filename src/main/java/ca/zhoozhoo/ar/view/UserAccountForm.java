package ca.zhoozhoo.ar.view;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import ca.zhoozhoo.ar.validation.BusinessLogicConstraints;
import ca.zhoozhoo.ar.validation.FormatConstraints;
import ca.zhoozhoo.ar.validation.PasswordsEqual;
import ca.zhoozhoo.ar.validation.UniqueUsername;

@GroupSequence({ UserAccountForm.class, FormatConstraints.class, BusinessLogicConstraints.class })
@PasswordsEqual(first = "password", second = "confirmPassword", message = "Passwords do not match", groups = { BusinessLogicConstraints.class })
public class UserAccountForm {

	@NotNull(message = "Please enter username", groups = FormatConstraints.class)
	@Pattern(regexp = "^[A-Za-z0-9]{5,}$", message = "Username must have a minimum length of 5 characters and contain only letters and numbers", groups = FormatConstraints.class)
	@UniqueUsername(message = "Username already exists", groups = BusinessLogicConstraints.class)
	private String username;

	@NotNull(message = "Please enter password", groups = FormatConstraints.class)
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,})", message = "Password must have a minimum length of 8 characters and contain at least 1 number, 1 uppercase, and 1 lowercase character", groups = FormatConstraints.class)
	private String password;

	private String confirmPassword;

	public UserAccountForm() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
