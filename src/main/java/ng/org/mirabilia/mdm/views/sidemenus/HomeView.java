package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "HomeView", layout = MainView.class)
@PageTitle("Home")
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {

        setSpacing(true);
        setMargin(true);
        add(configureHomeView());
    }

    private HorizontalLayout configureHomeView() {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setAlignItems(Alignment.START);
        horizontalLayout.setSpacing(true);
        horizontalLayout.setMargin(true);
        horizontalLayout.setWidth("100%");
        horizontalLayout.setHeight("100%");
//        horizontalLayout.setJustifyContentMode(JustifyContentMode.EVENLY);

        Div deviceDivView = new Div();
        deviceDivView.setWidth("300px");
        deviceDivView.setHeight("150px");
        deviceDivView.getStyle().setBackground("#E7F1F8");
        deviceDivView.getStyle()
                .setBorder("5px solid #E7F1F8")
                .setBorderRadius("4px");

        Image resourceIcon = new Image("icons/deviceicon.svg", "Device Icon");
//        resourceIcon.setWidth("24px");
//        resourceIcon.setHeight("24px");
        deviceDivView.add(resourceIcon);
        deviceDivView.add("Devices");
        Icon deviceIcon = new Icon(VaadinIcon.PLUS);
//        deviceIcon.
        deviceDivView.add(deviceIcon);
        deviceDivView.add("1324");

        horizontalLayout.add(deviceDivView);
        horizontalLayout.add(deviceDivView);
        horizontalLayout.add(deviceDivView);
        horizontalLayout.add(deviceDivView);
        horizontalLayout.add(deviceDivView);

        return horizontalLayout;
    }

}
