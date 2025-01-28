package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/devicemgt", layout = MainView.class)
@PageTitle("Device Management")
@RolesAllowed({"PUBLISHER", "ADMIN", "REGULAR"})
//@AnonymousAllowed
public class DeviceManagementView extends VerticalLayout {

    public DeviceManagementView() {

    }
}
