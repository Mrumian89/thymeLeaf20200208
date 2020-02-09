/*
package com.example.thymeLeaf20200208.model;

import com.example.thymeLeaf20200208.service.TestController;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class SkierowanieMapService implements SkierowanieService {

    public static class NotFoundException extends RuntimeException {
    }

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private Map<Integer, SkierowanieDoLekarza> skierowania = new HashMap<>();


    @Override
    public Collection<SkierowanieDoLekarza> listSkierowanie() {
        return skierowania.values();
    }

    @Override
    public SkierowanieDoLekarza getSkierowanie(Integer id) {
        SkierowanieDoLekarza skierowanieDoLekarza = skierowania.get(id);
        if(skierowanieDoLekarza == null) {
            throw new TestController.NotFoundException();
        }
        return skierowanieDoLekarza;
    }

    @Override
    public void deleteSkierowanie(Integer id) {
        skierowania.remove(id);
    }

    @Override
    public SkierowanieDoLekarza createSkierowanie(SkierowanieDoLekarza skierowanie) {
        skierowanie.setId(atomicInteger.getAndIncrement());
        skierowania.put(skierowanie.getId(), skierowanie);
        return skierowanie;
    }

    @Override
    public SkierowanieDoLekarza updateskierowanie(SkierowanieDoLekarza skierowanie) {
        SkierowanieDoLekarza existing = getSkierowanie(skierowanie.getId());
        existing.setLekarz(skierowanie.getLekarz());
        existing.setPacjent(skierowanie.getPacjent());
        existing.setTermin(skierowanie.getTermin());
        skierowania.put(existing.getId(), existing);
        return existing;
    }
}
*/
