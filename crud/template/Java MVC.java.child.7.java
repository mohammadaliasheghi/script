#set( $entityPackage = $PACKAGE_NAME+".entity."+${NAME}+"Entity")

import com.jedlab.framework.spring.dao.AbstractCrudDAO;
import $entityPackage;
import org.springframework.stereotype.Repository;

@Repository
public interface ${NAME}Repository extends AbstractCrudDAO<${NAME}Entity> {
}
