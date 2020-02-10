package com.vaadin.flow.component;

public interface AttributeReader extends HasElement {

	void readAttributes();

	default void attributeToPropertyString(String attributeName, String propertyName) {
		if (getElement().hasAttribute(attributeName)) {
			String value = getElement().getAttribute(attributeName);
			getElement().removeAttribute(attributeName);
			getElement().setProperty(propertyName, value);
		}
	}

	default void attributeToPropertyBoolean(String attributeName, String propertyName) {
		if (getElement().hasAttribute(attributeName)) {
			getElement().removeAttribute(attributeName);
			getElement().setProperty(propertyName, true);
		}
	}

	default void attributeToPropertyNumber(String attributeName, String propertyName) {
		if (getElement().hasAttribute(attributeName)) {
			String value = getElement().getAttribute(attributeName);
			getElement().removeAttribute(attributeName);
			getElement().setProperty(propertyName, Double.parseDouble(value));
		}
	}

}
