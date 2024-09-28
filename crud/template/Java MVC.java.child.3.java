#set( $regex = "([a-z])([A-Z]+)")
#set( $replacement = "$1_$2")
#set( $toSnake = "view_"+$NAME.replaceAll($regex, $replacement).toLowerCase())
#set( $project = $PROJECT_NAME.replaceAll("Backend", ""))

package ir.tfa.laboratoryservice.app.entity;

import com.cloud.config.ResourceBundle;
import com.cloud.model.dto.ExportExcelDTO;
import com.cloud.model.dto.FieldDTO;
import com.jedlab.framework.spring.SpringUtil;
import com.jedlab.framework.spring.dao.BasePO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(schema = "$project", name = "$toSnake")
@Immutable
public class View${NAME} extends BasePO {

    final public static List<FieldDTO.Excel> excelFieldList = new ArrayList<>();

    static {
    }

    final public static List<String> excelFieldNameList = excelFieldList.stream().map(FieldDTO.Base::getFieldName).collect(Collectors.toList());
}
