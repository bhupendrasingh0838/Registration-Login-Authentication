package bhup.Registration.Service;

import bhup.Registration.Entity.User;
import bhup.Registration.Controller.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User save(UserRegistrationDTO userRegistrationDTO);
}
