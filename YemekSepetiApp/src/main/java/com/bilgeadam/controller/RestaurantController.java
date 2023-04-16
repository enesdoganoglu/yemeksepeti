package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.repository.entity.Restaurant;
import com.bilgeadam.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constant.ApiUrls.*;

@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(@RequestBody @Valid RestaurantSaveRequestDto dto){
        return ResponseEntity.ok(restaurantService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findALl(){
        return ResponseEntity.ok(restaurantService.findAll());
    }
}
