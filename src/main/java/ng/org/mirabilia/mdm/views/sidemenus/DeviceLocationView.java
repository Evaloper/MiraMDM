package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "DeviceLocation", layout = MainView.class)
@PageTitle("User | Mobile Device Management")

@PermitAll
public class DeviceLocationView extends VerticalLayout {

    public DeviceLocationView(){
        add(new H4("Device Location Module"));
    }
}
