package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/devicemgt", layout = MainView.class)
@PageTitle("Device Management")
@AnonymousAllowed
public class DeviceManagementView extends VerticalLayout {

    public DeviceManagementView() {
        add(new H4("Device Management Module"));
    }
}
