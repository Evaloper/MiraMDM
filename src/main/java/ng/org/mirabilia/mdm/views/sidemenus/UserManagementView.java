package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/usermgt", layout = MainView.class)
@PageTitle("User Management")
@AnonymousAllowed
public class UserManagementView extends VerticalLayout {

    public UserManagementView() {

    }
}
