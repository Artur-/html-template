package org.vaadin.artur.htmltemplate.components.button;

import java.util.function.Function;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.dom.Element;

import org.github.legioth.htmltemplate.HtmlTemplate;
import org.junit.Assert;

public class AbstractTemplateTest<T extends Component> {

    private Class<T> cls;
    private String tag;

    protected AbstractTemplateTest(Class<T> cls, String tag) {
        this.cls = cls;
        this.tag = tag;
    }

    protected void testTextContents(String validValue, Function<T, String> getter) {
        T component = create(String.format("<%s>%s</%s>", tag, validValue, tag));
        Assert.assertEquals(validValue, getter.apply(component));
        component = create(String.format("<%s></%s>", tag, tag));
        Assert.assertEquals("", getter.apply(component));
    }

    protected void testBooleanAttribute(String attributeName, Function<T, Boolean> getter) {
        T component = create(String.format("<%s %s></%s>", tag, attributeName, tag));
        Assert.assertTrue(getter.apply(component));
        component = create(String.format("<%s></%s>", tag, tag));
        Assert.assertFalse(getter.apply(component));
    }

    protected void testStringAttribute(String attributeName, String validValue, Function<T, String> getter) {
        T component = create(String.format("<%s %s='%s'></%s>", tag, attributeName, validValue, tag));
        Assert.assertEquals(validValue, getter.apply(component));
        component = create(String.format("<%s></%s>", tag, tag));
        Assert.assertNull(getter.apply(component));
    }

    protected void testStringAttribute(String attributeName, String validValue, Function<T, String> getter,
            String expectedEmptyValue) {
        T component = create(String.format("<%s %s='%s'></%s>", tag, attributeName, validValue, tag));
        Assert.assertEquals(validValue, getter.apply(component));
        component = create(String.format("<%s></%s>", tag, tag));
        Assert.assertEquals(expectedEmptyValue, getter.apply(component));
    }

    protected void testDoubleAttribute(String attributeName, Double validValue, Function<T, Double> getter) {
        T component = create(String.format("<%s %s=%s></%s>", tag, attributeName, validValue, tag));
        Assert.assertEquals(validValue, getter.apply(component));
        component = create(String.format("<%s></%s>", tag, tag));
        Assert.assertEquals(Double.valueOf(0), getter.apply(component));
    }

    protected void testIntAttribute(String attributeName, Integer validValue, Function<T, Integer> getter) {
        T component = create(String.format("<%s %s=%s></%s>", tag, attributeName, validValue, tag));
        Assert.assertEquals(validValue, getter.apply(component));
        component = create(String.format("<%s></%s>", tag, tag));
        Assert.assertEquals(Integer.valueOf(0), getter.apply(component));
    }

    protected T create(String template) {
        HtmlTemplate t = HtmlTemplate.create(template);
        Element buttonElement = t.getElement().getChild(0);
        return ComponentUtil.componentFromElement(buttonElement, cls, true);
    }

}
