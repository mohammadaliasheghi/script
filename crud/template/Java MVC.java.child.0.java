#set( $regex = "([a-z])([A-Z]+)")
#set( $replacement = "$1-$2")
#set( $toSnake = $NAME.replaceAll($regex, $replacement).toLowerCase())
#set( $modelPackage = $PACKAGE_NAME+".model."+$NAME+"Model")
#set( $servicePackage = $PACKAGE_NAME+".service."+$NAME+"Service")
#set( $viewServicePackage = $PACKAGE_NAME+".service.View"+$NAME+"Service")
#set( $model = $NAME +"Model")

import com.cloud.security.Permission;
import com.cloud.web.security.SecureContext;
import com.jedlab.framework.web.Pagination;
import $modelPackage;
import $servicePackage;
import $viewServicePackage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/$toSnake")
@SecureContext()
@RequiredArgsConstructor
public class ${NAME}Controller {

    private final ${NAME}Service service;
    private final View${NAME}Service viewService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody $model model) {
        return ResponseEntity.ok(service.create${NAME}(model));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody $model model) {
        return ResponseEntity.ok(service.update${NAME}(model));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete${NAME}(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/list")
    public ResponseEntity<?> getList(@Valid @RequestBody $model model, @RequestParam("pageSize") Optional<Integer> pageSize, @RequestParam("page") Optional<Integer> page, Sort sort) {
        if (sort == null || sort.isEmpty())
            sort = Sort.by(Sort.Direction.DESC, "id");
        Pagination pagination = new Pagination(page, pageSize);
        return ResponseEntity.ok(viewService.listInfo(model, PageRequest.of(pagination.getEvalPage(), pagination.getEvalPageSize()), sort));
    }

    @PostMapping(value = "/export/{type}")
    public void exportCenterList(@PathVariable String type, HttpServletResponse response,
                                 @Valid @RequestBody $model model, Sort sort) {
        try {
            if (sort == null || sort.isEmpty())
                sort = Sort.by(Sort.Direction.DESC, "id");
            viewService.export(type, response, model, sort);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
