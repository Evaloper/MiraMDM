package ng.org.mirabilia.mdm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;
import ng.org.mirabilia.mdm.views.forms.LoginForm;
import ng.org.mirabilia.mdm.views.utils.WelcomeTextScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("login")
@AnonymousAllowed

public class LoginView extends VerticalLayout {

    private final LoginForm loginForm = new LoginForm();
    private final WelcomeTextScreen welcomeTextScreen = new WelcomeTextScreen();
    private final Image mdmImage = new Image("/images/logo.png", "LOGO");
    private final DaoAuthenticationProvider authenticationProvider;

    @Autowired
    public LoginView(DaoAuthenticationProvider authenticationProvider) {

        setSizeFull();
        setHeightFull();
        setWidthFull();


        this.authenticationProvider = authenticationProvider;

        //mdm login styling
        mdmImage.getStyle().setBackgroundColor("#0A73B7").setPadding("30px");

        if (authenticationProvider == null) {
            throw new IllegalStateException("AuthenticationManager is null");
        }

        // Handle login action
        loginForm.loginButton.addClickListener(event -> {
            String username = loginForm.username.getValue();
            String password = loginForm.password.getValue();

            // Debugging: Check the username and password values
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            try {
                // Create an authentication token with user input
                Authentication auth = new UsernamePasswordAuthenticationToken(username, password);

                // Authenticate the user using the authentication provider
                Authentication authenticatedUser = authenticationProvider.authenticate(auth);

                // Set the authenticated user in the SecurityContext

                // Check if the user is authenticated and navigate to the UserView
                if (authenticatedUser.isAuthenticated()) {
                    SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
                    UI.getCurrent().navigate("UserView");
                } else {
                    Notification.show("Authentication failed");
                }
            } catch (AuthenticationException ex) {
                Notification.show("Invalid username or password");
                ex.printStackTrace(); // Optional, for debugging
            }
        });


        //Layout SetUp
        AppLayout appLayout = new AppLayout();
        appLayout.addToNavbar(mdmImage);
        appLayout.getStyle().setMargin("0").setPadding("0");
        appLayout.getStyle().set("height", "20px");

        HorizontalLayout loginFormScreenLayout =  new HorizontalLayout();
        loginFormScreenLayout.setSizeFull();
        loginFormScreenLayout.add(welcomeTextScreen, loginForm);

        add(appLayout, loginFormScreenLayout);

    }
}






