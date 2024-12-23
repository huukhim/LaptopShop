package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/admin/user") // http
    public String getUserPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "/admin/user/table-user";// file html
    }

    @RequestMapping("/admin/user/{id}") // http
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        // model.addAttribute("id", user.getId());
        // model.addAttribute("email", user.getEmail());
        // model.addAttribute("fullname", user.getFullName());
        // model.addAttribute("address", user.getAddress());

        return "/admin/user/show";
    }

    @RequestMapping("/admin/user/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());// khi truy cap, model se tao mot user moi, modelAttribute o ben html
                                                  // se duoc gan', va path se la bien cua user moi do
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) { // khi nhan create, view se tra ve
                                                                                      // modelAttribute voi ten tuong
                                                                                      // ung, o day la user voi ten
                                                                                      // model la newUser
        userService.handleSaveUser(user);
        return "redirect:/admin/user"; // redirect http, k phai ten file
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String getUpdateUser(Model model, @ModelAttribute("newUser") User updatedUser) {
        User currentUser = this.userService.getUserById(updatedUser.getId());

        if (currentUser != null) {
            currentUser.setFullName(updatedUser.getFullName());
            currentUser.setPhone(updatedUser.getPhone());
            currentUser.setAddress(updatedUser.getAddress());

            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user"; // http khong phai la file
    }

    @GetMapping("admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("user", new User());
        return "admin/user/delete";
    }

    @PostMapping("admin/user/delete")
    public String getDeleteUser(@ModelAttribute("user") User user) {
        this.userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }

}
