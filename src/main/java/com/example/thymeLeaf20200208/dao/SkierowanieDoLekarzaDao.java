package com.example.thymeLeaf20200208.dao;

import com.example.thymeLeaf20200208.model.SkierowanieDoLekarza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkierowanieDoLekarzaDao extends CrudRepository<SkierowanieDoLekarza, Integer> {

    @Override
    List<SkierowanieDoLekarza> findAll();


}
