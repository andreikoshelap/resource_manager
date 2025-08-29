package com.gatto.resource.mapper;


import com.gatto.resource.dto.ResourceDTO;
import com.gatto.resource.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    ResourceDTO resourceToResourceDTO(Resource order);

    Resource resourceDTOToResource(ResourceDTO orderDTO);
}
