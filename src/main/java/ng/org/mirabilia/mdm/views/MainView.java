package ng.org.mirabilia.mdm.views;


import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.security.AuthenticationContext;
import ng.org.mirabilia.mdm.views.sidemenus.*;
import ng.org.mirabilia.mdm.views.sidemenus.user.UserManaagementView;
import ng.org.mirabilia.mdm.views.utils.NavItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("/main")
@PageTitle("main")
@AnonymousAllowed
public class MainView extends AppLayout implements AfterNavigationObserver {

    private final List<RouterLink> routerLinks = new ArrayList<>();

    @Autowired
    final private AuthenticationContext authContext;

    public MainView(AuthenticationContext authContext){

//        authContext.getAuthenticatedUser(UserDetails.class).ifPresent((user)-> Application.globalLoggedInUsername = user.getUsername());
        this.authContext = authContext;

        configureHeader();
        configureDrawer();
//        configureMainContent();
    }

    private void configureHeader() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.addClassName("custom-toggle-button");

        Div d1 = new Div();
        d1.getStyle().setDisplay(Style.Display.FLEX);
        d1.getStyle().setAlignItems(Style.AlignItems.CENTER);
        d1.getStyle().setMarginRight("10px");
        d1.getStyle().setJustifyContent(Style.JustifyContent.START);

        Image miraLogo = new Image();
        miraLogo.setWidth("15px");
        miraLogo.setHeight("15px");
        miraLogo.setSrc("image/logo.png");
        miraLogo.getStyle().setMarginRight("12px").setMarginBottom("4px");

        Button notification = new Button();
        notification.setIcon(VaadinIcon.BELL.create());
//        notification.setWidth("40px");
//        notification.setHeight("40px");
//        notification.getStyle().setBorderRadius("50%");
        notification.getStyle().setBackgroundColor("white");
        notification.getStyle().setMarginRight("10px");

        Button admin = new Button("Admin");
        admin.setIcon(VaadinIcon.ARROW_DOWN.create());
//        admin.setWidth("40px");
//        admin.setHeight("40px");
//        admin.getStyle().setBorderRadius("50%");
        admin.getStyle().setBackgroundColor("white");
        admin.getStyle().setMarginRight("15px");
        admin.getStyle().setMarginRight("15px");

        Div headerSideComponent = new Div();
        headerSideComponent.setWidth("40px");
        headerSideComponent.setHeight("40px");
        headerSideComponent.getStyle().setDisplay(Style.Display.FLEX);
        headerSideComponent.getStyle().setAlignItems(Style.AlignItems.CENTER);
        headerSideComponent.getStyle().setJustifyContent(Style.JustifyContent.END);

        headerSideComponent.add(notification, admin);
        d1.add(miraLogo, headerSideComponent);

        HorizontalLayout header = new HorizontalLayout(toggle, d1);
//        header.addClassName("custom-header");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.setPadding(false);
        header.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        addToNavbar(header);
        setPrimarySection(Section.DRAWER);
    }

    private void configureDrawer() {
        Image logo = new Image("image/logo.png", "Logo");
//        logo.addClassName("drawer-logo");

        VerticalLayout drawerContent = new VerticalLayout(logo);

            RouterLink dashboardLink = createNavItem("Home", VaadinIcon.DASHBOARD, HomeView.class);
            drawerContent.add(dashboardLink);

            RouterLink deviceManagementLink = createNavItem("Device Management", VaadinIcon.MOBILE, DeviceManagementView.class);
            drawerContent.add(deviceManagementLink);

            RouterLink groupManagementLink = createNavItem("Group Management", VaadinIcon.GROUP, GroupManagementView.class);
            drawerContent.add(groupManagementLink);

            RouterLink userManagementLink = createNavItem("User Management", VaadinIcon.USERS, UserManaagementView.class);
            drawerContent.add(userManagementLink);

            RouterLink deviceTypeManagementLink = createNavItem("Device Type Management", VaadinIcon.MOBILE_BROWSER, DeviceTypeManagementView.class);
            drawerContent.add(deviceTypeManagementLink);

            RouterLink policyManagementLink = createNavItem("Policy Management", VaadinIcon.CHEVRON_UP, PolicyManagementView.class);
            drawerContent.add(policyManagementLink);

            RouterLink configSettingsLink = createNavItem("Configuration Settings", VaadinIcon.BRIEFCASE, ConfigurationSettings.class);
            drawerContent.add(configSettingsLink);

            RouterLink deviceLocationtLink = createNavItem("Device Location", VaadinIcon.LOCATION_ARROW, DeviceLocation.class);
            drawerContent.add(deviceLocationtLink);

//        drawerContent.addClassName("drawer-content");

//        logOutDialog.logOutButton.addClickListener(event -> authContext.logout());
        Button logoutButton = new Button("Logout", VaadinIcon.SIGN_OUT.create(),
                clickEvent -> UI.getCurrent().navigate("/login"));

//        logoutButton.addClassName("custom-logout-button");
//        logoutButton.addClassName("drawer-link");

        drawerContent.add(logoutButton);

        addToDrawer(drawerContent);
    }

    private RouterLink createNavItem(String label, VaadinIcon icon, Class<? extends com.vaadin.flow.component.Component> navigationTarget) {
        RouterLink link = new RouterLink();
//        link.addClassName("drawer-link");

        NavItem sideNavItem = new NavItem(icon.create(), label);
        link.add(sideNavItem);
        link.setRoute(navigationTarget);
        routerLinks.add(link);
        return link;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
    }

    @Override
    public Registration addAttachListener(ComponentEventListener<AttachEvent> listener) {
        return super.addAttachListener(listener);
    }

}
