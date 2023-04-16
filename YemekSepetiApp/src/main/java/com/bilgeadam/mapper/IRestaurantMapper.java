package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.repository.entity.Product;
import com.bilgeadam.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);

    Restaurant fromDtoToRestaurant(RestaurantSaveRequestDto dto);
}

