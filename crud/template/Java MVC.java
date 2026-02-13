#set( $regex = "([a-z])([A-Z]+)")
#set( $replacement = "$1_$2")
#set( $toSnake = $NAME.replaceAll($regex, $replacement).toLowerCase())
#set( $project = $PROJECT_NAME.replaceAll("Backend", ""))

import com.cloud.entity.AuditPO;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "$project", name = "$toSnake")
@Data
@Audited
public class ${NAME}Entity extends AuditPO {

}
