#set( $viewPackage = $PACKAGE_NAME+".entity.view.View"+$NAME)

import com.jedlab.framework.spring.dao.AbstractDAO;
import $viewPackage;
import org.springframework.stereotype.Repository;

@Repository
public interface View${NAME}Repository extends AbstractDAO<View${NAME}> {
}
