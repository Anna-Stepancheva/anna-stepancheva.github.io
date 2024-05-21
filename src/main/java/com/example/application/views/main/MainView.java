package com.example.application.views.main;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;


@Route("")
public class MainView extends AppLayout {

    public MainView() {
        addClassName("main-view");
        H1 title = new H1("Лёха, расслабься, это пранк");
        title.getStyle().setTextAlign(Style.TextAlign.CENTER)
                .setFontSize("40px");

        VerticalLayout vlayout = new VerticalLayout();
        vlayout.setPadding(true);
        vlayout.setAlignItems(FlexComponent.Alignment.CENTER);
        vlayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        H1 hp = new H1("С Днем Рождения!");
        hp.getStyle().setTextAlign(Style.TextAlign.CENTER)
                .setFontSize("30px");

        vlayout.add(getImage("1"));
        vlayout.add(hp);
        vlayout.add(getPoem());

        Div content = new Div();
        content.add(title);
        content.add(vlayout);
        setContent(content);
    }

    private Image getImage(String number){
        StreamResource imageResource = new StreamResource(number + ".jpg", () -> getClass().getResourceAsStream("/photo/" + number +".jpg"));
        Image img = new Image(imageResource, "1");
        img.getStyle().setWidth("700px");
        return img;
    }


    private static VerticalLayout getPoem() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        Span span = new Span();
        span.getElement().setProperty("innerHTML", POEM);
        span.getStyle().setJustifyContent(Style.JustifyContent.CENTER);
        span.getStyle().setFontSize("20px");
        layout.add(span);
        return layout;
    }

    private static final String POEM = """
            Тебе желаю, Алексей,<br>
            Чтоб жизнь сложилась, как по нотам<br>
            Чтоб было множество друзей,<br>
            Шуршали в кошельке банкноты!<br>
            Удача в руки чтоб плыла,<br>
            Не заблудилась по дороге,<br>
            Чтоб только в гору шли дела,<br>
            И счастья в жизни было много!""";
}
