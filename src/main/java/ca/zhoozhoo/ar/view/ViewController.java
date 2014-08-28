package ca.zhoozhoo.ar.view;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.zhoozhoo.ar.repository.UserAccountRepository;

@Controller
public class ViewController {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@RequestMapping(value = "/userAccount", method = RequestMethod.GET)
	public String products() {
		return "userAccount";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String review(@Valid @ModelAttribute("userAccountForm") UserAccountForm userAccountForm, BindingResult result) {
		if (result.hasErrors()) {
			return "userAccount";
		}

		return "success";
	}

	@ModelAttribute("userAccountForm")
	public UserAccountForm createUserAccountForm() {
		return new UserAccountForm();
	}
}
