package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "main", layout = MainView.class)
@PageTitle("Home")
//@AnonymousAllowed
@RolesAllowed({"PUBLISHER", "ADMIN", "REGULAR"})
public class HomeView extends VerticalLayout {

    public HomeView() {
        setWidth("100%");
        setPadding(true);
        setAlignItems(Alignment.CENTER);

        Div mainContainer = new Div();
        mainContainer.getStyle()
                .set("padding", "30px")
                .set("display", "grid")
                .set("grid-template-columns", "repeat(3, 1fr)")
                .set("gap", "30px")
                .set("max-width", "1200px")
                .set("width", "90%")
                .set("margin", "0 auto");

        mainContainer.add(
                createCard("Devices", "3034", VaadinIcon.MOBILE.create()),
                createCard("Groups", "6", VaadinIcon.GROUP.create()),
                createCard("Users", "3034", VaadinIcon.USER.create()),
                createCard("Roles", "3034", VaadinIcon.STAR.create()),
                createCard("Device types", "3034", VaadinIcon.DESKTOP.create()),
                createCard("Policies", "3034", VaadinIcon.FILE.create())
        );

        add(mainContainer);
    }

    private Div createCard(String title, String value, com.vaadin.flow.component.icon.Icon icon) {
        Div card = new Div();
        card.getStyle()
                .set("background-color", "#E8F4FF")
                .set("padding", "15px")
                .set("border-radius", "8px")
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("align-items", "flex-start")
                .set("position", "relative")
                .set("min-height", "150px");

        // Top section with icon and plus button
        HorizontalLayout topSection = new HorizontalLayout();
        topSection.setWidthFull();
        topSection.setJustifyContentMode(JustifyContentMode.BETWEEN);
        topSection.setAlignItems(Alignment.CENTER);

        // Icon
        icon.setSize("24px");
        icon.getStyle().set("color", "#007BFF");
        topSection.add(icon);

        Div titleDiv = new Div();
        titleDiv.setText(title);
        titleDiv.getStyle()
                .set("color", "#000")
                .set("font-weight", "700")
                .set("font-size", "14px")
                .set("margin-top", "7px")
                .set("text-align", "left")  // Explicitly set text alignment
                .set("align-self", "flex-start")  // Ensures div aligns to start
                .set("width", "100%"); // Makes sure the div takes full width
        topSection.add(titleDiv);

        // Plus button
        Button plusButton = new Button(VaadinIcon.PLUS.create());
        plusButton.getElement().getStyle().set("color", "#F47415");
        topSection.add(plusButton);

        card.add(topSection);

        // Value (now in the middle)
        Div valueDiv = new Div();
        valueDiv.setText(value);
        valueDiv.getStyle()
                .set("font-size", "24px")
                .set("font-weight", "bold")
                .set("color", "#000")
                .set("margin", "15px 0");
        card.add(valueDiv);

        return card;
    }
}