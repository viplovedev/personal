package dev.viplove.springbootstarter.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.viplove.springbootstarter.model.User;
import dev.viplove.springbootstarter.security.tracking.ActiveUserStore;
import dev.viplove.springbootstarter.security.tracking.LoggedUser;
import dev.viplove.springbootstarter.service.UserService;

@RestController
@RequestMapping("/users")
public class UserCtrl {
	
	@Autowired
	UserService uS;
	
	@PostMapping
	public ResponseEntity<User> save(User u){
		
		User saved = uS.addUser(u);
		ResponseEntity<User> retval = new ResponseEntity<>(saved,HttpStatus.OK);
		return retval;
	}
	
	@Autowired
    ActiveUserStore activeUserStore;
 
    @RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
    public String getLoggedUsers(HttpServletRequest request) {
    	 HttpSession session = request.getSession(false);
    	 LoggedUser user = null;
         if (session != null) {
             user = (LoggedUser) session.getAttribute("user");
             return user.toString();
         }
         return "No one is logged in!!!";
    }
    
    @GetMapping(value="/logout")
    public void logout(HttpServletRequest request) throws ServletException {
    	request.logout();
    }
}
