package org.vaadin.artur.htmltemplate.components.button;

import org.junit.Test;
import org.vaadin.artur.htmltemplate.components.FixedButton;

public class ButtonTest extends AbstractTemplateTest<FixedButton> {

    public ButtonTest() {
        super(FixedButton.class, "vaadin-button");
    }

    @Test
    public void text() {
        testTextContents("Say hello", c -> c.getText());
    }

    @Test
    public void autofocus() {
        testBooleanAttribute("autofocus", c -> c.isAutofocus());
    }

}