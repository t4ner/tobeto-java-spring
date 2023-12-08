package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.dtos.responses.brand.GetByBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {


    List<Brand> findAllByNameLike(String name);


    List<Brand> findByNameLikeOrIdEquals(String name, int id);


    boolean existsByName(String name);
    //varsa true, yoksa false döner


    @Query("SELECT b FROM Brand b WHERE b.name LIKE %:name%")
    List<Brand> search(String name);


    @Query(value = "SELECT * FROM brands WHERE name LIKE %:name%", nativeQuery = true)
    List<Brand> search2(String name);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.brand.GetByBrandListResponse(b.name) " +
            "FROM Brand b WHERE b.name LIKE %:name%")
    List<GetByBrandListResponse> search3(String name);


    @Query(value = "SELECT b.name FROM brands b WHERE name LIKE %:name%", nativeQuery = true)
    List<GetByBrandListResponse> search4(String name);



}
