package com.summernote.controller;

import com.summernote.dto.UserDTO;
import com.summernote.model.User;
import com.summernote.repository.UserRepository;
import com.summernote.service.UserService;
import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Miguel Castro
 */
@Controller
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserService userService;
    
    @GetMapping("/index")
    public ModelAndView allUsers(UserDTO userDTO, ModelMap model){
        
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("users", userService.getAllUsersDTO());
        
        return modelAndView;
    }
    
    @GetMapping("/register")
    public ModelAndView registerUser(User user){
        
        ModelAndView modelAndView = new ModelAndView("register");
        
        return modelAndView;
    }
    
    @PostMapping("/save")
    public ModelAndView saveUser(@Valid User user, BindingResult result, RedirectAttributes attr){
        
        ModelAndView mvIndex = new ModelAndView("redirect:/index");
        ModelAndView mvSave = new ModelAndView("register");
        
        if (result.hasErrors()) {
            
            return mvSave;
        }
        
        user.setDateNow(LocalDateTime.now());
        userRepository.save(user);
        attr.addFlashAttribute("sucess", "Saved successfully!");
        
        return mvIndex;
        
    }
}