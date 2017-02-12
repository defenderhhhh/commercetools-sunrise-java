package com.commercetools.sunrise.shoppingcart.checkout.payment.view;

import com.commercetools.sunrise.shoppingcart.checkout.AbstractCheckoutPageContent;
import play.data.Form;

public class CheckoutPaymentPageContent extends AbstractCheckoutPageContent {

    private Form<?> paymentForm;
    private CheckoutPaymentFormSettingsBean paymentFormSettings;

    public CheckoutPaymentPageContent() {
    }

    public Form<?> getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(final Form<?> paymentForm) {
        this.paymentForm = paymentForm;
    }

    public CheckoutPaymentFormSettingsBean getPaymentFormSettings() {
        return paymentFormSettings;
    }

    public void setPaymentFormSettings(final CheckoutPaymentFormSettingsBean paymentFormSettings) {
        this.paymentFormSettings = paymentFormSettings;
    }
}
