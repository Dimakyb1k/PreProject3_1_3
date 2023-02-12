package com.example.preproject3_1_3.controller;

import com.example.preproject3_1_3.dao.UserRepository;
import com.example.preproject3_1_3.model.Role;
import com.example.preproject3_1_3.model.User;
import com.example.preproject3_1_3.service.RoleService;
import com.example.preproject3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    @Autowired

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("")
    public String showAllUser(ModelMap model) {
        List<User> messages = userService.getAllUser();
        model.addAttribute("messages", messages);
        return "admin";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap model) {

        model.addAttribute("messages", new User());

        model.addAttribute("roles", roleService.getAllRole());


        return "userInfo";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("messages") User user) {

        userService.addUser(user);

        return "redirect:/admin";
    }

    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";

    }

    @GetMapping("/user-update/{id}")
    public String updateUser(@PathVariable("id") Long id, ModelMap model) {
        User messages = userService.findUserById(id);
        model.addAttribute("messages", messages);
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "userInfo";
    }
    @PatchMapping("/{id}")
    public String Update(@ModelAttribute("user") @Valid User updUser, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "redirect:/admin";
        userService.update(id, updUser);
        return "redirect:/admin";
    }
}