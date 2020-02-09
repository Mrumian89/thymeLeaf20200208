package com.example.thymeLeaf20200208.service;

import com.example.thymeLeaf20200208.dto.SkierowanieDoLekarzaDTO;
import com.example.thymeLeaf20200208.model.SkierowanieDoLekarza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkierowanieMapper2 {
    SkierowanieDoLekarzaDTO toDTO(SkierowanieDoLekarza skierowanieDoLekarza);
    SkierowanieDoLekarza toDB(SkierowanieDoLekarzaDTO skierowanieDoLekarzaDTO);

}
