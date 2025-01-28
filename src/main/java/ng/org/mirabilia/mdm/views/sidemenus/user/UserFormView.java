package ng.org.mirabilia.mdm.views.sidemenus.user;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import ng.org.mirabilia.mdm.repositories.UserRepository;
import ng.org.mirabilia.mdm.services.UserService;
import ng.org.mirabilia.mdm.views.MainView;
import ng.org.mirabilia.mdm.views.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "adduser", layout = MainView.class)
@RolesAllowed({"ADMIN"})
public class UserFormView extends VerticalLayout {

    private UserService userService;
    private UserRepository userRepository;
    private UserForm userForm;
    Button backToUsersButton;



    @Autowired
    public UserFormView(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;



        backToUsersButton = new Button("Back To Users", e -> UI.getCurrent().navigate(UserManagementView.class));
//        userForm = new UserForm(userService, userRepository, v -> UI.getCurrent().navigate(UserView.class));
        userForm = new UserForm(userService, userRepository);

        add(backToUsersButton, userForm);
    }



}
