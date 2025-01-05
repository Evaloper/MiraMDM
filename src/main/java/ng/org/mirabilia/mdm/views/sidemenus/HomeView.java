package ng.org.mirabilia.mdm.views.sidemenus;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import ng.org.mirabilia.mdm.views.MainView;

@Route(value = "", layout = MainView.class)
@PageTitle("Home")
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {

        setWidth("350px");
        setHeight("170px");
//        setSpacing(true);
//        setMargin(true);
        getStyle()
                .set("border", "1px solid #e0e0e0")
                .set("border-radius", "8px")
                .set("box-shadow", "0px 4px 6px rgba(0,0,0,0.1)")
                .set("background-color", "#f9fcff");

        add(configureHomeView());
    }

    private HorizontalLayout configureHomeView() {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setAlignItems(Alignment.AUTO);
//        horizontalLayout.setSpacing(true);
//        horizontalLayout.setMargin(true);
        horizontalLayout.setWidthFull();;
//        horizontalLayout.getStyle().setMaxWidth("339px").setMaxHeight("160px")
//                .set("border", "1px solid #e0e0e0")
//                .set("border-radius", "8px")
//                .set("box-shadow", "0px 4px 6px rgba(0,0,0,0.1)")
//                .set("background-color", "#f9fcff");;
//        horizontalLayout.setWidth("100%");
//        horizontalLayout.setHeight("100%");

        VerticalLayout deviceCardLogo = new VerticalLayout();
        deviceCardLogo.getStyle().setWidth("80px").setHeight("80px")
                .setBorder("1px").setBorderRadius("8px");
//                .setBackgroundColor("white");
        Icon userIcon = VaadinIcon.USER.create();
        userIcon.getStyle().setAlignSelf(Style.AlignSelf.FLEX_START).setMargin("auto");
        userIcon.setSize("35px");
        userIcon.getStyle()
                .set("color", "#0d6efd");
        deviceCardLogo.add(userIcon);

        H4 devicePlaceholder = new H4("Devices");
        devicePlaceholder.getStyle()
                .set("margin", "5px 0")
                .set("font-size", "16px")
                .set("color", "#000");

        HorizontalLayout plusLogo = new HorizontalLayout();
        deviceCardLogo.getStyle().setWidth("50px").setHeight("50px")
                .setBorder("1px").setBorderRadius("8px");
//                .setBackgroundColor("white");
        Icon plusIcon = VaadinIcon.PLUS.create();

        plusIcon.getStyle().setAlignSelf(Style.AlignSelf.CENTER).setMargin("auto");
        plusIcon.setSize("50px");
        plusIcon.getStyle()
                .set("color", "#F47415");
        plusLogo.add(plusIcon);

        VerticalLayout topLayer = new VerticalLayout();
        topLayer.setSpacing(true);
        topLayer.setMargin(false);
        topLayer.setAlignItems(Alignment.CENTER);

        H4 deviceCountPlaceholder = new H4("4321");
        deviceCountPlaceholder.getStyle()
                .set("margin", "5px 0")
                .set("font-size", "16px")
                .set("color", "#000");

        VerticalLayout lowerLayer = new VerticalLayout();
        lowerLayer.setSpacing(true);
        lowerLayer.setMargin(true);
        lowerLayer.setAlignItems(Alignment.CENTER);

        topLayer.add(deviceCardLogo, devicePlaceholder, plusLogo);
        lowerLayer.add(deviceCountPlaceholder);

        horizontalLayout.add(userIcon);

        return horizontalLayout;
    }

}
