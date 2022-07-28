package com.quipux.spotify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.spotify.api.entity.CategoryIcon;

@Repository
public interface CategoryIconRepository extends JpaRepository<CategoryIcon, Integer> {

}
