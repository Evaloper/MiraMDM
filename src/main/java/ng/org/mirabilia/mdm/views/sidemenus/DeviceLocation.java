package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "/devicelocation", layout = MainView.class)
@AnonymousAllowed
public class DeviceLocation extends VerticalLayout {

    public DeviceLocation() {

    }
}
