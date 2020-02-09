package com.example.thymeLeaf20200208.service;

import com.example.thymeLeaf20200208.dao.SkierowanieDoLekarzaDao;
import com.example.thymeLeaf20200208.dto.SkierowanieDoLekarzaDTO;
import com.example.thymeLeaf20200208.model.SkierowanieDoLekarza;
import com.example.thymeLeaf20200208.model.SkierowanieService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Primary
@Service
public class SkierowanieDBService implements SkierowanieService {

    SkierowanieDoLekarzaDao dao;

    public SkierowanieDBService(SkierowanieDoLekarzaDao dao){
        this.dao = dao;
    }

    @Override
    public Collection<SkierowanieDoLekarzaDTO> listSkierowanie() {
        return dao.findAll();
    }

    @Override
    public SkierowanieDoLekarzaDTO getSkierowanie(Integer id) {
        return dao.findById(id)
                .orElseThrow(()-> new TestController.NotFoundException());
    }

    @Override
    public void deleteSkierowanie(Integer id) {
        SkierowanieDoLekarza skierowanieDoLekarza = getSkierowanie(id);
        dao.delete(skierowanieDoLekarza);
    }

    @Override
    public SkierowanieDoLekarzaDTO createSkierowanie(SkierowanieDoLekarzaDTO skierowanie) {
        return dao.save(skierowanie);
    }

    @Override
    public SkierowanieDoLekarzaDTO updateskierowanie(SkierowanieDoLekarzaDTO skierowanie) {
        SkierowanieDoLekarza skierowanieDoLekarza = getSkierowanie(skierowanie.getId());
        skierowanieDoLekarza.setLekarz(skierowanie.getLekarz());
        skierowanieDoLekarza.setPacjent(skierowanie.getPacjent());
        skierowanieDoLekarza.setTermin(skierowanie.getTermin());
        return dao.save(skierowanieDoLekarza);
    }
}
