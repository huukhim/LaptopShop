package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/") // gui yeu cau den sever
    public String getHomePage(Model model) {
        List<User> arrUsers = userService.getAllUsersByEmail("odinkun20303@gmail.com");
        System.out.println(arrUsers);

        model.addAttribute("eric", "test");
        return "hello"; // return ve file view nhu html,jsp,... tuc la khi vao url "/" thi se hien thi
                        // file view ma chung ta return
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        this.userService.handleSaveUser(hoidanit); // luu vao database
        return "hello";
    }
}
