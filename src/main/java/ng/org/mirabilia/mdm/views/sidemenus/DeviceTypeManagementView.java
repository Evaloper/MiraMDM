package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/devicetypemgt", layout = MainView.class)
@PageTitle("Device Type Management")
@RolesAllowed({"PUBLISHER", "ADMIN", "REGULAR"})
//@AnonymousAllowed
public class DeviceTypeManagementView extends VerticalLayout {

    public DeviceTypeManagementView() {
        add(new H4("Device Type Management Module"));
    }

}
