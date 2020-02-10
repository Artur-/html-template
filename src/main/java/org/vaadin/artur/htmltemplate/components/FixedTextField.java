package org.vaadin.artur.htmltemplate.components;

import com.vaadin.flow.component.AttributeReader;
import com.vaadin.flow.component.textfield.TextField;

public class FixedTextField extends TextField implements AttributeReader {

	@Override
	public void readAttributes() {
		if (getElement().hasAttribute("value")) {
			String value = getElement().getAttribute("value");
			getElement().removeAttribute("value");
			setValue(value);
		}

		attributeToPropertyString("placeholder", "placeholder");
		attributeToPropertyString("pattern", "pattern");
		attributeToPropertyString("label", "label");
		attributeToPropertyString("title", "title");

		attributeToPropertyBoolean("autoselect", "autoselect");
		attributeToPropertyBoolean("autofocus", "autofocus");
		attributeToPropertyBoolean("required", "required");
		attributeToPropertyBoolean("prevent-invalid-input", "preventInvalidInput");
		attributeToPropertyBoolean("clear-button-visible", "clearButtonVisible");

		attributeToPropertyNumber("minlength", "minlength");
		attributeToPropertyNumber("maxlength", "maxlength");
	}

}