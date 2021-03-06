package rentcar.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rentcar.data.CustomerData;
import rentcar.dto.CustomerDataDTO;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

@Component
public class LoginCredentialsValidator implements Validator {

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;

    public boolean supports(Class<?> clazz)
    {
        return clazz.isAssignableFrom(CustomerDataDTO.class); //returns false
    }

    public void validate(Object target, Errors errors) {

        CustomerDataDTO customerDataDTO = (CustomerDataDTO) target;
        validateLoginCredentials(customerDataDTO, errors);
    }

    public String validateLoginCredentials(CustomerDataDTO customerDataDTO, Errors errors)
    {
        return null;
    }
}
