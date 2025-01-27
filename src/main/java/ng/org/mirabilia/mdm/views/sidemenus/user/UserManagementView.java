package ng.org.mirabilia.mdm.views.sidemenus.user;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import ng.org.mirabilia.mdm.domain.entities.User;
import ng.org.mirabilia.mdm.repositories.UserRepository;
import ng.org.mirabilia.mdm.services.UserService;
import ng.org.mirabilia.mdm.views.MainView;
import ng.org.mirabilia.mdm.views.utils.DeleteDialog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "usermgt", layout = MainView.class)
@PageTitle("User Management")
@AnonymousAllowed
public class UserManagementView extends VerticalLayout {

    Button addNewUser;
    TextField search = new TextField();

    @Autowired
    UserRepository userRepository;
    UserService userService;


    @Autowired
    public UserManagementView(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;

        //filtering text
        search.setPlaceholder("search");
        search.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        search.setClearButtonVisible(true);
        search.setValueChangeMode(ValueChangeMode.LAZY);
        search.addValueChangeListener(e -> userService.findByUsername(search.getValue()));

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.getStyle().set("background-color", "white");

        HorizontalLayout actionBar = new HorizontalLayout();
        Button bulkEditButton = new Button("Bulk Edit");
        bulkEditButton.getStyle()
                .set("background-color", "#f39c12")
                .set("color", "white");

        HorizontalLayout actionBarTwo = new HorizontalLayout();
        actionBarTwo.add(search);

        addNewUser = new Button("ADD USER", e -> UI.getCurrent().navigate(UserFormView.class));
        addNewUser.setPrefixComponent(new Icon(VaadinIcon.PLUS));

        setSizeFull();
        setPadding(true);
        setSpacing(true);
        getStyle().set("margin", "0 auto"); // Center the layout

        actionBar.add(addNewUser, bulkEditButton);
        actionBar.setSpacing(true);

        //inline styling
        FlexLayout gridLayout = new FlexLayout();
        gridLayout.setWidthFull();
        gridLayout.getStyle()
                .set("display", "grid")
                .set("grid-template-columns", "repeat(4, auto)")  // Ensures 3 cards per row
                .set("gap", "15px 15px")  // Spacing between cards
                .setAlignSelf(Style.AlignSelf.CENTER)
                .setAlignItems(Style.AlignItems.CENTER);

        addNewUser.getStyle()
                .set("background-color", "#0d6efd")
                .set("color", "#ffffff")
                .set("border-radius", "4px")
                .set("padding", "10px 15px");

        // Mock data (replace this with database query)
        List<User> users = userRepository.findAll();
        UserCard card;


        // Add user cards to the layout
        for (User user : users) {
            card = new UserCard(user);

            //inline styling for the cards
            card.setWidth("350px");
            card.setHeight("150px");
            card.getStyle()
                    .set("border", "1px solid #ddd")
                    .set("border-radius", "8px")
                    .set("box-shadow", "0px 4px 6px rgba(0,0,0,0.1)")
                    .set("background-color", "#E7F1F8")
                    .set("padding", "15px");

            card.setAlignItems(Alignment.CENTER);
            card.setJustifyContentMode(JustifyContentMode.CENTER);

            card.deleteIcon.addClickListener(e -> {
                Dialog deleteDialog = new DeleteDialog(
                        () -> {
                            userService.deleteUser(user.getId());
                        }
                );
                deleteDialog.open();
            });
            gridLayout.add(card);
        }
        mainLayout.add(actionBar,actionBarTwo, gridLayout);
        add(mainLayout);
    }
}


