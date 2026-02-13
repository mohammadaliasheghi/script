#set( $modelPackage = $PACKAGE_NAME+".model."+$NAME+"Model")
#set( $model = $NAME +"Model")

import com.jedlab.framework.spring.service.JPARestriction;
import com.jedlab.framework.util.StringUtil;
import $modelPackage;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class View${NAME}Restriction implements JPARestriction {

    $model model;

    public View${NAME}Restriction($model model) {
        this.model = model;
    }


    @Override
    public Specification<?> countSpec(CriteriaBuilder criteriaBuilder, CriteriaQuery criteriaQuery, Root root) {
        return this::applyFilter;
    }

    @Override
    public Specification<?> listSpec(CriteriaBuilder criteriaBuilder, CriteriaQuery criteriaQuery, Root root) {
        return this::applyFilter;
    }

    private Predicate applyFilter(Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        var predicateList = new ArrayList<Predicate>();

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}
