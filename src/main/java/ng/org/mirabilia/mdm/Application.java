package ng.org.mirabilia.mdm;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@SpringBootApplication(scanBasePackages = {"boot.registration", "ng.org.mirabilia.mdm"}, exclude = {SecurityAutoConfiguration.class})
@PWA(name = "Mobile Device Management",
        shortName = "MiraMDM",
        description = "Mobile Device Management, developed by Mirabilia Nigeria Limited",
        iconPath = "icons/pwa-icon.png",
        offlineResources = { "icons/pwa-icon.png" })
@EnableWebSecurity
public class Application implements AppShellConfigurator {

//    public static String globalLoggedInUsername = null;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
