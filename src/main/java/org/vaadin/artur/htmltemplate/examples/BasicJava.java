package org.vaadin.artur.htmltemplate.examples;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.htmltemplate.GreetService;

@Route("basic-java")
public class BasicJava extends VerticalLayout {

    public BasicJava(@Autowired GreetService service) {
        TextField textField = new TextField("Your name");
        Button button = new Button("Say hello",
                e -> Notification.show(service.greet(textField.getValue())));
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        addClassName("centered-content");
        add(textField, button);
    }

}
