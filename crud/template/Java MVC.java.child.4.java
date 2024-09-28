
#set( $modelPackage = $PACKAGE_NAME+".model."+$NAME+"Model")
#set( $model = $NAME +"Model")

import com.cloud.enums.ExceptionCode;
import com.cloud.exceptions.BindingException;
import com.cloud.validator.BusinessValidator;
import com.jedlab.framework.spring.SpringUtil;
import $modelPackage;
import org.springframework.stereotype.Component;

@Component
public class ${NAME}Validator implements BusinessValidator<$model> {

    @Override
    public void validate(${NAME}Model model) throws BindingException {
        BindingException bindingException = new BindingException();

        if (bindingException.getErrors().size() > 0)
            throw bindingException;
    }
}
