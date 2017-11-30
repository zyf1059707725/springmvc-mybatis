package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.entity.User;
import demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		
		request.setAttribute("userList", userService.getAllUser());
		
		return "index";
	}
	
	@RequestMapping("/getUser")
	public String getUser(String id,HttpServletRequest request){
		
		request.setAttribute("user", userService.getUser(id));
	
		return "editUser";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		
		userService.addUser(user);
		
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/delUser")
	public void delUser(String id,HttpServletResponse response){
		
		String result = "{\"result\":\"error\"}";
		
		if(userService.delUser(id)){
			result = "{\"result\":\"success\"}";
		}
		
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,Model model){
		
		if(userService.updateUser(user)){
			user = userService.getUser(user.getId());
			model.addAttribute("user", user);
			return "redirect:/user/getAllUser";
		}else{
			return "error";
		}
	}
}