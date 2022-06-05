package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.*;
import com.covid.vaccination.Exception.*;
import java.util.*;


public interface IdProofService {
    void saveIdProof(IdProof user);

    IdProof getIdProofById(Integer id) throws IdProofException;

    List<IdProof> getAllIdProofs() throws IdProofException;

    IdProof deleteIdProofById(Integer id) throws IdProofException;

    IdProof updateIdProof(IdProof user, String key) throws IdProofException;
}
