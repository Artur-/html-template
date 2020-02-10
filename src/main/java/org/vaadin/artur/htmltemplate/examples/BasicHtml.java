package org.vaadin.artur.htmltemplate.examples;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import org.github.legioth.htmltemplate.HtmlTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.htmltemplate.GreetService;

@Route("basic-html")
public class BasicHtml extends HtmlTemplate {

    @Id
    private TextField name;

    @Id
    private Button sayHello;

    public BasicHtml(@Autowired GreetService service) {
        sayHello.addClickListener(e -> Notification.show(service.greet(name.getValue())));
        sayHello.addClickShortcut(Key.ENTER);
    }
}