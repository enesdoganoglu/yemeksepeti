package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.repository.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T22:47:01+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IProductMapperImpl implements IProductMapper {

    @Override
    public Product fromDtoToProduct(ProductSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.productName( dto.getProductName() );
        product.category( dto.getCategory() );
        product.cost( dto.getCost() );

        return product.build();
    }
}
