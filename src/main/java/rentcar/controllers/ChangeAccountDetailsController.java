package rentcar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import rentcar.data.CustomerAddressData;
import rentcar.data.CustomerData;
import rentcar.dto.CustomerAddressDataDTO;
import rentcar.dto.CustomerDataDTO;
import rentcar.facade.CustomerFullDetailsFacade;
import rentcar.services.AddCustomerDataService;
import javax.servlet.http.HttpSession;


@Controller
public class ChangeAccountDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(ChangeAccountDetailsController.class);

    @Autowired
    AddCustomerDataService addCustomerDataService;

    @Autowired
    CustomerFullDetailsFacade customerFullDetailsFacade;


    @RequestMapping(value="/changeaccountdetails" , method = RequestMethod.GET)
    public String getAccountDetails(Model model, HttpSession httpSession)
    {
        if ((httpSession.getAttribute("customer") == null) || (httpSession.getAttribute("customeraddress") == null))
        {
            model.addAttribute("loginSuccessful", "Please login or create a user in order to access the account page");
            return "login";
        }
        else
        {
            model.addAttribute("customer",  httpSession.getAttribute("customer"));
            model.addAttribute("customerAddress", httpSession.getAttribute("customeraddress"));
            return "changeaccountdetails";
        }
    }

    @RequestMapping(value="/changeaccountdetails" , method = RequestMethod.POST)
    public String postRegister(@ModelAttribute("changeAccountDetailsModelAttribute") CustomerDataDTO customerDataDTO, CustomerAddressDataDTO customerAddressDataDTO, Model model, HttpSession httpSession) {

        CustomerData customerData = (CustomerData) httpSession.getAttribute("customer");

        httpSession.setAttribute("customer", customerFullDetailsFacade.updateCustomerData(customerDataDTO, customerData));
        httpSession.setAttribute("customerAddress", customerFullDetailsFacade.updateCustomerAddressData(customerAddressDataDTO, customerData));

        model.addAttribute("loginSuccessful", "New account details have been saved!");
        return "changeaccountdetails";
    }
}
