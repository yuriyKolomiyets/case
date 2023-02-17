package com.example.demo.service;

import com.example.demo.model.Troop;
import java.util.List;

public interface TroopService {

    List<Troop> get(Long amount);
}
