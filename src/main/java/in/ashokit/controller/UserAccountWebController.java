package in.ashokit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.model.UserAccount;
import in.ashokit.service.UserAccountService;

@Controller
public class UserAccountWebController {

	@Autowired
	private UserAccountService accountService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountWebController.class);

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}

	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute("user") UserAccount account, Model model) {
		LOGGER.info("{}", account);

		String message = accountService.saveOrUpdateUserAcc(account);
		model.addAttribute("message", message);
		model.addAttribute("user", new UserAccount());
		return "index";

	}

	@GetMapping("/users")
	public String viewUsers(Model model) {

		List<UserAccount> usersList = accountService.getAllUsers();
		model.addAttribute("users", usersList);
		return "view-user";
	}

	@GetMapping("/update/{userId}")
	public String editUser(@PathVariable Integer userId, Model model) {
		UserAccount showOneUser = accountService.showOneUser(userId);
		model.addAttribute("user", showOneUser);
		return "index";
	}

	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable Integer userId, Model model) {
		accountService.deleteUserAcc(userId);
		model.addAttribute("msg", "user record deleted...!!");
		return "forward:/users";
	}

	@GetMapping("/updateStatus/{userId}/{status}")
	public String updateStatus(@PathVariable Integer userId, @PathVariable String status,Model model) {
		accountService.updateUserAccstatus(userId, status);
		
		if("Y".equals(status)) {
			model.addAttribute("msg", "User Account Activated...!!");
		}else {
			model.addAttribute("msg", "User Account D-Activated...!!");
		}
		return "forward:/users";
	}
}
