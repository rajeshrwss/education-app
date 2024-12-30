package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.binding.ForgotPwdForm;
import com.example.demo.binding.LoginForm;
import com.example.demo.binding.SignUpForm;
import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.ApplicationEntity;
import com.example.demo.entity.EnquiryEntity;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.AdminService;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.EnquiryService;
import com.example.demo.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private StudentService studentService;

	@Autowired
	private EnquiryService enquiryService;

	@Autowired
	private ApplicationService appService;

	@Autowired
	private AdminService adminService;

	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}

	@GetMapping("/demo")
	public String getDemoPage() {
		return "demo";
	}

	@GetMapping("/register")
	public String getRegisterPage(Model model) {

		model.addAttribute("signUpForm", new SignUpForm());
		return "registration";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("signUpForm") SignUpForm signupForm, Model model) {
		String message = studentService.registerUser(signupForm);
		model.addAttribute("message", message);
		return "registration";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		// System.out.println("Calling..");
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping("/login")
	public String loginStudent(@ModelAttribute("loginForm") LoginForm loginForm, Model model, HttpSession session) {

		boolean isAuthenticated = studentService.authenticate(loginForm.getEmailId(), loginForm.getPassword());

		if (isAuthenticated) {
			session.setAttribute("UserEmail", loginForm.getEmailId());
			return "redirect:/dashboard"; // Home page after successful login
		} else {
			model.addAttribute("error", "Invalid credentials");
			return "login"; // return to login page if authentication fails
		}
	}

	@GetMapping("/forgotpwd")
	public String showForgotPasswordPage(Model model) {
		// System.out.println("Calling..");
		model.addAttribute("forgotPwdForm", new ForgotPwdForm());
		return "forgotpwd";
	}

	@GetMapping("/forgotpwd1")
	public String showForgotPwdPage(Model model) {
		// System.out.println("Calling..");
		model.addAttribute("forgotPwdForm", new ForgotPwdForm());
		return "forgotpwd1";
	}

	@PostMapping("/forgotpwd")
	public String resetPassword(@ModelAttribute("forgotPwdForm") ForgotPwdForm forgotPwdForm, Model model) {
		String message = studentService.resetPwd(forgotPwdForm.getEmailId());
		model.addAttribute("message", message);
		return "forgotpwd";
	}

	@PostMapping("/forgotpwd1")
	public String resetPwd(@ModelAttribute("forgotPwdForm") ForgotPwdForm forgotPwdForm, Model model) {
		String message = studentService.resetPwd(forgotPwdForm.getEmailId(), forgotPwdForm.getNewPassword(),
				forgotPwdForm.getConfirmPassword());
		model.addAttribute("message", message);
		return "forgotpwd1";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		String username = (String) session.getAttribute("UserEmail");
		if (username == null) {
			return "redirect:/login";
		}
		model.addAttribute("appEntity", new ApplicationEntity());
		model.addAttribute("username", username);
		return "dashboard";
	}

	@PostMapping("/dashboard")
	public String postStudentDetails(@ModelAttribute("appEntity") ApplicationEntity appEntity, HttpSession session,
			Model model) {

		ApplicationEntity savedAppentity = appService.saveApplicationDtls(appEntity);

		// Store the updated list back into the session
		session.setAttribute("savedAppentity", savedAppentity);

		if (!savedAppentity.equals(null)) {
			String message = "Data Saved Successfully..";
			model.addAttribute("message", message);
		}

		model.addAttribute("appEntity", new ApplicationEntity());
		String username = (String) session.getAttribute("UserEmail");
		model.addAttribute("username", username);

		return "dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@GetMapping("/about")
	public String getAboutPage() {
		return "about";
	}

	@GetMapping("/services")
	public String getServicePage() {
		return "services";
	}

	@GetMapping("/faQ")
	public String getFaQPage() {
		return "faQ";
	}

	@GetMapping("/contact")
	public String getContactPage(Model model) {
		model.addAttribute("enquiryEntity", new EnquiryEntity());
		return "contact";
	}

	@PostMapping("/contact")
	public String PostContactPage(@ModelAttribute("enquiryEntity") EnquiryEntity enquiryEntity, Model model) {
		String postQuestion = enquiryService.postQuestion(enquiryEntity);
		model.addAttribute("message", postQuestion);
		model.addAttribute("enquiryEntity", new EnquiryEntity());
		return "contact";
	}

	@GetMapping("/apply")
	public String getApplicationPage() {
		return "applyForm";
	}

	@PostMapping("/adminLogin")
	public String postLoginPage(@ModelAttribute("adminEntity") AdminEntity adminEntity, Model model,
			HttpSession session) {
		boolean isAuthenticated = adminService.authenticate(adminEntity.getEmailId(), adminEntity.getPassword());
		if (isAuthenticated) {
			session.setAttribute("adminEmail", adminEntity.getEmailId());
			return "redirect:/adminDashboard"; // Home page after successful login
		} else {
			model.addAttribute("error", "Invalid credentials");
			return "adminLogin"; // return to login page if authentication fails
		}
	}

	@GetMapping("/adminLogin")
	public String getLoginPage(Model model) {
		model.addAttribute("adminEntity", new AdminEntity());
		return "adminLogin";
	}

	@GetMapping("/adminDashboard")
	public String adminDashboard(HttpSession session, Model model) {
		String adminUsername = (String) session.getAttribute("adminEmail");

		List<ApplicationEntity> studentDataList = appService.getAllApplications();

		if (adminUsername == null) {
			return "redirect:/adminLogin";
		}
		System.out.println("displayList " + studentDataList);
		model.addAttribute("studentDataList", studentDataList);
		model.addAttribute("adminUser", adminUsername);
		return "adminDashboard";
	}
}
