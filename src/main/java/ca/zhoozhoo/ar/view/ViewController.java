package ca.zhoozhoo.ar.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView review(@ModelAttribute("userAccountForm") UserAccountForm userAccountForm) {

		return new ModelAndView("confirm", "userAccountForm", userAccountForm);
	}

	@ModelAttribute("userAccountForm")
	public UserAccountForm createUserAccountForm() {
		return new UserAccountForm();
	}
}
