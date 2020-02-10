package org.vaadin.artur.htmltemplate.components.button;

import org.junit.Test;
import org.vaadin.artur.htmltemplate.components.FixedTextField;

public class TextFieldTest extends AbstractTemplateTest<FixedTextField> {

    public TextFieldTest() {
        super(FixedTextField.class, "vaadin-text-field");
    }

    @Test
    public void label() {
        testStringAttribute("label", "Name", c -> c.getLabel());
    }

    @Test
    public void placeholder() {
        testStringAttribute("placeholder", "foo", c -> c.getPlaceholder());
    }

    @Test
    public void autoselect() {
        testBooleanAttribute("autoselect", c -> c.isAutoselect());
    }

    @Test
    public void clearButtonVisible() {
        testBooleanAttribute("clear-button-visible", c -> c.isClearButtonVisible());
    }

    @Test
    public void autofocus() {
        testBooleanAttribute("autofocus", c -> c.isAutofocus());
    }

    @Test
    public void maxlength() {
        testIntAttribute("maxlength", 10, c -> c.getMaxLength());
    }

    @Test
    public void minlength() {
        testIntAttribute("minlength", 3, c -> c.getMinLength());
    }

    @Test
    public void required() {
        testBooleanAttribute("required", c -> c.isRequired());
    }

    @Test
    public void preventInvalidInput() {
        testBooleanAttribute("prevent-invalid-input", c -> c.isPreventInvalidInput());
    }

    @Test
    public void pattern() {
        testStringAttribute("pattern", "1-2-3", c -> c.getPattern());
    }

    @Test
    public void title() {
        testStringAttribute("title", "1-2-3", c -> c.getTitle());
    }

    @Test
    public void value() {
        testStringAttribute("value", "Hello world", c -> c.getValue(), "");
    }

}