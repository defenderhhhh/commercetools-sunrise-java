package com.commercetools.sunrise.common.models.carts;

import com.commercetools.sunrise.framework.injection.RequestScoped;
import com.commercetools.sunrise.common.models.addresses.AddressBeanFactory;
import com.commercetools.sunrise.common.utils.PriceFormatter;
import io.sphere.sdk.carts.Cart;
import io.sphere.sdk.carts.LineItem;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.money.CurrencyUnit;

@RequestScoped
public class CartBeanFactory extends AbstractCartLikeBeanFactory<CartBean, Cart> {

    private final LineItemExtendedBeanFactory lineItemExtendedBeanFactory;

    @Inject
    public CartBeanFactory(final CurrencyUnit currency, final PriceFormatter priceFormatter, final ShippingInfoBeanFactory shippingInfoBeanFactory,
                           final PaymentInfoBeanFactory paymentInfoBeanFactory, final AddressBeanFactory addressBeanFactory,
                           final LineItemExtendedBeanFactory lineItemExtendedBeanFactory) {
        super(currency, priceFormatter, shippingInfoBeanFactory, paymentInfoBeanFactory, addressBeanFactory);
        this.lineItemExtendedBeanFactory = lineItemExtendedBeanFactory;
    }

    @Override
    protected CartBean getViewModelInstance() {
        return new CartBean();
    }

    @Override
    public final CartBean create(@Nullable final Cart cart) {
        return super.create(cart);
    }

    @Override
    protected final void initialize(final CartBean model, final Cart cart) {
        super.initialize(model, cart);
    }

    @Override
    LineItemBean createLineItem(final LineItem lineItem) {
        return lineItemExtendedBeanFactory.create(lineItem);
    }
}