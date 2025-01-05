package ng.org.mirabilia.mdm.views.utils;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;

public class WelcomeTextScreen extends VerticalLayout {

    private final H3 welcomeToMiraMDM;
    private final Html textUnderWelcomeToMDM;
    private final Image mockUpImage = new Image("image/Group2772.png", "Mock-up");
    private final VerticalLayout descriptionTextLayout = new VerticalLayout();



    public  WelcomeTextScreen() {
        addClassName("WelcomeTextScreen");

        setSizeFull();
        setHeightFull();
        setWidthFull();
        setClassName("descriptionTextLayout");

        //first Half of the login screen
        welcomeToMiraMDM = new H3("Welcome to MIRAMDM");
        textUnderWelcomeToMDM = new Html("<div>Simplify your mobile device management with MiraMDM. " +
                "Whether you’re managing a few devices or an entire fleet," +
                "our platform offers real-time monitoring, secure controls," +
                "and seamless integration.</div>");


        mockUpImage.getStyle().setWidth("200px");
        welcomeToMiraMDM.getStyle().setFontSize("30px").setFontWeight(700);

        descriptionTextLayout.addClassName("descriptionTextLayout");
        descriptionTextLayout.add(welcomeToMiraMDM,  textUnderWelcomeToMDM, mockUpImage);
        descriptionTextLayout.getStyle().setBackgroundColor("#E7F1F8").setJustifyContent(Style.JustifyContent.CENTER).setAlignItems(Style.AlignItems.CENTER);


        descriptionTextLayout.setHeightFull();
//        descriptionTextLayout.setWidthFull();
        descriptionTextLayout.getStyle().setMaxWidth("500px");
        add(descriptionTextLayout);


    }

}
