package bhup.Registration.Controller;

import bhup.Registration.Service.UserService;
import bhup.Registration.Controller.dto.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }
   /*
    @GetMapping
    public String showRegistratinForm(Model model){
        model.addAttribute("user", new UserRegistrationDTO());  // both the methods i.e @ModelAttribute and GetMapping bind into the single method
        return "registration";
    }

    */

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO userRegistrationDTO) {
        userService.save(userRegistrationDTO);
        return "redirect:/registration?success";
    }
}
