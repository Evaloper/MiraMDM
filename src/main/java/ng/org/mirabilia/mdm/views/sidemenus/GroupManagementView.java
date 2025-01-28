package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/groupmgt", layout = MainView.class)
@PageTitle("Group Management")
@RolesAllowed({"PUBLISHER", "ADMIN", "REGULAR"})
//@AnonymousAllowed
public class GroupManagementView extends VerticalLayout {

    public GroupManagementView() {
        add(new H4("Group Management Module"));
    }
}
