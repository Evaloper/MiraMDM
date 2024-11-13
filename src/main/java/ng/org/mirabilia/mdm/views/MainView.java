package ng.org.mirabilia.mdm.views;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(" ")
@PermitAll
public class MainView extends AppLayout{

    public MainView(){
        setContent(new H1("HIIIIIIIIIIIII"));
    }
}
