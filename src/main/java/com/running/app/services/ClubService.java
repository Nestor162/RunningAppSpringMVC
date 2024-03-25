package com.running.app.services;

import com.running.app.dtos.ClubDto;
import com.running.app.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
    Club saveClub(Club club);
}
