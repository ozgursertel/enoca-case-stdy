package com.ozgursertel.Enoca.mapper;

import com.ozgursertel.Enoca.entity.Product;
import com.ozgursertel.Enoca.entity.dto.ProductDto;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Product updateProductFromDto(ProductDto dto, @MappingTarget Product product);
}
