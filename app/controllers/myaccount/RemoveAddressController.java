package controllers.myaccount;

import com.commercetools.sunrise.framework.controllers.cache.NoCache;
import com.commercetools.sunrise.framework.reverserouters.myaccount.AddressBookReverseRouter;
import com.commercetools.sunrise.framework.reverserouters.myaccount.AuthenticationReverseRouter;
import com.commercetools.sunrise.framework.template.engine.TemplateRenderer;
import com.commercetools.sunrise.framework.hooks.RegisteredComponents;
import com.commercetools.sunrise.myaccount.CustomerFinder;
import com.commercetools.sunrise.myaccount.addressbook.AddressFinder;
import com.commercetools.sunrise.myaccount.addressbook.addressbookdetail.viewmodels.AddressBookPageContentFactory;
import com.commercetools.sunrise.myaccount.addressbook.removeaddress.DefaultRemoveAddressFormData;
import com.commercetools.sunrise.myaccount.addressbook.removeaddress.RemoveAddressControllerAction;
import com.commercetools.sunrise.myaccount.addressbook.removeaddress.SunriseRemoveAddressController;
import com.commercetools.sunrise.framework.components.CommonControllerComponentsSupplier;
import controllers.PageHeaderControllerComponentsSupplier;
import io.sphere.sdk.customers.Customer;
import play.data.FormFactory;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

@NoCache
@RegisteredComponents({
        CommonControllerComponentsSupplier.class,
        PageHeaderControllerComponentsSupplier.class
})
public final class RemoveAddressController extends SunriseRemoveAddressController<DefaultRemoveAddressFormData> {

    private final AuthenticationReverseRouter authenticationReverseRouter;
    private final AddressBookReverseRouter addressBookReverseRouter;

    @Inject
    public RemoveAddressController(final TemplateRenderer templateRenderer,
                                   final FormFactory formFactory,
                                   final CustomerFinder customerFinder,
                                   final AddressFinder addressFinder,
                                   final RemoveAddressControllerAction removeAddressControllerAction,
                                   final AddressBookPageContentFactory addressBookPageContentFactory,
                                   final AuthenticationReverseRouter authenticationReverseRouter,
                                   final AddressBookReverseRouter addressBookReverseRouter) {
        super(templateRenderer, formFactory, customerFinder, addressFinder, removeAddressControllerAction, addressBookPageContentFactory);
        this.authenticationReverseRouter = authenticationReverseRouter;
        this.addressBookReverseRouter = addressBookReverseRouter;
    }

    @Override
    public String getTemplateName() {
        return "my-account-address-book";
    }

    @Override
    public Class<DefaultRemoveAddressFormData> getFormDataClass() {
        return DefaultRemoveAddressFormData.class;
    }

    @Override
    public CompletionStage<Result> handleNotFoundCustomer() {
        return redirectTo(authenticationReverseRouter.logInPageCall());
    }

    @Override
    public CompletionStage<Result> handleNotFoundAddress() {
        return redirectTo(addressBookReverseRouter.addressBookDetailPageCall());
    }

    @Override
    public CompletionStage<Result> handleSuccessfulAction(final Customer updatedCustomer, final DefaultRemoveAddressFormData formData) {
        return redirectTo(addressBookReverseRouter.addressBookDetailPageCall());
    }
}