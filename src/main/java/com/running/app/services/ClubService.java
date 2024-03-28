package com.running.app.services;

import com.running.app.dtos.ClubDto;
import com.running.app.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
    ClubDto findClubById(Long clubId);
    Club saveClub(ClubDto clubDto);
    void updateClub(ClubDto club);
}
