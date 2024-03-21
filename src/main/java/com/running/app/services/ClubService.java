package com.running.app.services;

import com.running.app.dtos.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
}
