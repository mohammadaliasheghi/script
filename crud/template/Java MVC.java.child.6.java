#set( $entityPackage = $PACKAGE_NAME+".entity."+${NAME}+"Entity")
#set( $modelPackage = $PACKAGE_NAME+".model."+$NAME+"Model")

import $entityPackage;
import $modelPackage;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, componentModel = "spring")
public interface ${NAME}Mapper {

    static ${NAME}Mapper get() {
        return Mappers.getMapper(${NAME}Mapper.class);
    }

    ${NAME}Entity modelToEntity(${NAME}Model model);

    ${NAME}Model entityToModel(${NAME}Entity entity);

    List<${NAME}Model> entitiesToModels(List<${NAME}Entity> entities);
}