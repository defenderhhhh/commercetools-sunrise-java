package com.commercetools.sunrise.common.pages;

import com.commercetools.sunrise.common.localization.LocalizationSelectorViewModel;
import com.commercetools.sunrise.common.models.ViewModel;
import com.commercetools.sunrise.common.models.carts.MiniCartViewModel;

public class PageHeader extends ViewModel {

    private String title;
    private String customerServiceNumber;
    private LocalizationSelectorViewModel location;
    private MiniCartViewModel miniCart;
    private PageNavMenu navMenu;

    public PageHeader() {
    }

    public PageHeader(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public LocalizationSelectorViewModel getLocation() {
        return location;
    }

    public void setLocation(final LocalizationSelectorViewModel location) {
        this.location = location;
    }

    public MiniCartViewModel getMiniCart() {
        return miniCart;
    }

    public void setMiniCart(final MiniCartViewModel miniCart) {
        this.miniCart = miniCart;
    }

    public PageNavMenu getNavMenu() {
        return navMenu;
    }

    public void setNavMenu(final PageNavMenu navMenu) {
        this.navMenu = navMenu;
    }

    public String getCustomerServiceNumber() {
        return customerServiceNumber;
    }

    public void setCustomerServiceNumber(final String customerServiceNumber) {
        this.customerServiceNumber = customerServiceNumber;
    }
}