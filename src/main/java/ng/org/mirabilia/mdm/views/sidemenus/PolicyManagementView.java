package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/policymgt", layout = MainView.class)
@PageTitle("Policy Management")
@RolesAllowed({"PUBLISHER", "ADMIN", "REGULAR"})
//@AnonymousAllowed
public class PolicyManagementView extends VerticalLayout {

    public PolicyManagementView() {

    }
}
