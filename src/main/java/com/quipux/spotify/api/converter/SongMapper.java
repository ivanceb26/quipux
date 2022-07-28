package com.quipux.spotify.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.quipux.spotify.api.dto.CategoryDTO;
import com.quipux.spotify.api.dto.CategoryIconDTO;
import com.quipux.spotify.api.dto.SongDTO;
import com.quipux.spotify.api.entity.Category;
import com.quipux.spotify.api.entity.CategoryIcon;
import com.quipux.spotify.api.entity.Song;

@Mapper
public interface SongMapper {
	SongMapper MAPPER = Mappers.getMapper( SongMapper.class );

    @Mapping(target = "playlists", ignore = true)
    Song songDTOToSong(SongDTO songDTO);
    
    SongDTO songToSongDTO(Song song);
    
    Category categoryDTOtoCategory(CategoryDTO categoryDTO);
    
    Category categorytoCategoryDTO(Category category);
    
    CategoryIcon categoryIconDTOtoCategoryIcon(CategoryIconDTO categoryIconDTO);
    
    CategoryIconDTO categoryIcontoCategoryIconDTO(CategoryIcon categoryIcon);	
}