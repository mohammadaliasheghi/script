#set( $entityPackage = $PACKAGE_NAME+".entity."+${NAME}+"Entity")
#set( $modelPackage = $PACKAGE_NAME+".model."+$NAME+"Model")
#set( $mapperPackage = $PACKAGE_NAME+".mapper."+$NAME+"Mapper")
#set( $validatorPackage = $PACKAGE_NAME+".validator."+$NAME+"Validator")
#set( $repositoryPackage = $PACKAGE_NAME+".repository."+$NAME+"Repository")
#set( $entity = $NAME +"Entity")
#set( $model = $NAME +"Model")
#set( $mapper = $NAME +"Mapper")
#set( $repository = $NAME +"Repository")
#set( $validator = $NAME +"Validator")


import com.cloud.util.HttpUtil;
import com.cloud.util.JsonUtil;
import com.jedlab.framework.spring.dao.AbstractDAO;
import com.jedlab.framework.spring.rest.EntityResultList;
import com.jedlab.framework.spring.service.AbstractCrudService;
import $entityPackage;
import $mapperPackage;
import $modelPackage;
import $repositoryPackage;
import $validatorPackage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ${NAME}Service extends AbstractCrudService<$entity> {

    private final $repository repository;
    private final $validator validator;

    @PersistenceContext
    EntityManager em;

    public ${NAME}Service(AbstractDAO<$entity> rp, PlatformTransactionManager ptm, $repository repository, $validator validator) {
        super(rp, ptm);
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Transactional(rollbackFor = Exception.class)
    public $model create${NAME}($model model) {
        validator.validate(model);
        $entity entity = ${mapper}.get().modelToEntity(model);
        insert(entity);
        return ${mapper}.get().entityToModel(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public $model update${NAME}($model model) {
        validator.validate(model);
        $entity entity = readForUpdate(${entity}.class, model.getId(), JsonUtil.toJson(model));
        update(entity);
        return ${mapper}.get().entityToModel(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete${NAME}(Long id) {
        delete(id);
    }

    @Transactional(readOnly = true)
    public $model get(Long id) {
        return ${mapper}.get().entityToModel(findById(${entity}.class, id));
    }
}