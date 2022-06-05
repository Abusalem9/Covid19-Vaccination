package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;

import java.util.List;
import java.util.Optional;

public interface IdProofService {
    List<IdProof> getAllIdProof() throws UserException;
}
