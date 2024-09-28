#set( $modelPackage = $PACKAGE_NAME+".model."+$NAME+"Model")
#set( $restrictionPackage = $PACKAGE_NAME+".restriction.View"+$NAME+"Restriction")
#set( $viewPackage = $PACKAGE_NAME+".entity.view.View"+$NAME)
#set( $model = $NAME +"Model")
#set( $restriction = "View"+$NAME+"Restriction" )

import com.cloud.enums.EExportType;
import com.cloud.enums.ExceptionCode;
import com.cloud.enums.ModuleEnum;
import com.cloud.exceptions.BindingException;
import com.cloud.model.dto.ExportExcelDTO;
import com.cloud.util.ExportExcelUtil;
import com.jedlab.framework.spring.SpringUtil;
import com.jedlab.framework.spring.dao.AbstractDAO;
import com.jedlab.framework.spring.rest.EntityResultList;
import com.jedlab.framework.spring.rest.ResponseMessage;
import com.jedlab.framework.spring.service.AbstractCrudService;
import $restrictionPackage;
import $modelPackage;
import $viewPackage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class View${NAME}Service extends AbstractCrudService<View${NAME}> {

    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public View${NAME}Service(AbstractDAO<View${NAME}> repository, PlatformTransactionManager ptm) {
        super(repository, ptm);
    }

    @Transactional(readOnly = true)
    public EntityResultList<View${NAME}> listInfo($model model, Pageable page, Sort sort) {
        $restriction restriction = new $restriction(model);
        Page<View${NAME}> entities = load(page, View${NAME}.class, restriction, sort);
        return new EntityResultList<>(ResponseMessage.success(), entities.getContent(), entities.getTotalElements());
    }

    @Transactional(readOnly = true)
    public void export(String type, HttpServletResponse response, $model model, Sort sort) throws IOException, NoSuchFieldException, IllegalAccessException {
        EExportType eExportType;
        if ("pdf".equalsIgnoreCase(type))
            eExportType = EExportType.PDF;
        else if ("excel".equalsIgnoreCase(type))
            eExportType = EExportType.EXCEL;
        else
            throw new BindingException("ExportTypeNotValid", ExceptionCode.ERROR.getValue());
        System.out.println(eExportType);

        $restriction restriction = new $restriction(model);
        List<Object[]> dataList = dataList(View${NAME}.class, restriction, View${NAME}.excelFieldNameList, sort);
        ExportExcelDTO exportExcelDTO = new ExportExcelDTO(dataList, View${NAME}.excelFieldList, ModuleEnum.FIRST_LIST_REPORT).setSheetName(SpringUtil.getMessage("View${NAME}", null));
        ExportExcelUtil.export(exportExcelDTO, response);
    }
}
