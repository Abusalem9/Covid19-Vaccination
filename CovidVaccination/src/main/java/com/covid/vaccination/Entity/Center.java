package com.covid.vaccination.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Center {
    @Enumerated(EnumType.ORDINAL)
    private Slot slot;
}
