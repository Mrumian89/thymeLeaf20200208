package com.example.thymeLeaf20200208.model;

import java.util.Collection;
import java.util.List;

import com.example.thymeLeaf20200208.dto.SkierowanieDoLekarzaDTO;
import com.example.thymeLeaf20200208.model.SkierowanieDoLekarza;

public interface SkierowanieService {

    Collection<SkierowanieDoLekarzaDTO> listSkierowanie();
    SkierowanieDoLekarzaDTO getSkierowanie(Integer id);
    void deleteSkierowanie(Integer id);
    SkierowanieDoLekarzaDTO createSkierowanie(SkierowanieDoLekarzaDTO skierowanie);
    SkierowanieDoLekarzaDTO updateskierowanie(SkierowanieDoLekarzaDTO skierowanie);
}
