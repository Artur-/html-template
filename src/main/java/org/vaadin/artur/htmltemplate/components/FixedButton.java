package org.vaadin.artur.htmltemplate.components;

import com.vaadin.flow.component.AttributeReader;
import com.vaadin.flow.component.button.Button;

public class FixedButton extends Button implements AttributeReader{

	@Override
	public void readAttributes() {
        attributeToPropertyBoolean("autofocus","autofocus");
	}

}