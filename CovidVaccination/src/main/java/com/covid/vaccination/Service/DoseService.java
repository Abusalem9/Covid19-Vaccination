package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Dose;
import com.covid.vaccination.Exception.DoseException;

import java.util.List;

public interface DoseService {
    void saveDose(Dose dose);

    Dose getDoseById(Integer id) throws DoseException;

    List<Dose> getAllDoses() throws DoseException;

    Dose deleteDoseById(Integer id) throws DoseException;

    Dose updateDose(Dose dose, String key) throws DoseException;
}
