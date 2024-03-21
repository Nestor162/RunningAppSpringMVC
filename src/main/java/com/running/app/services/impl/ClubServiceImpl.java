package com.running.app.services.impl;

import com.running.app.dtos.ClubDto;
import com.running.app.models.Club;
import com.running.app.repositories.ClubRepository;
import com.running.app.services.ClubService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClub() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club ->
           new ClubDto(club.getId(),club.getTitle(),
                    club.getPhotoURL(),club.getContent(),
                    club.getCreatedOn(),club.getUpdatedOn()))
             .collect(Collectors.toList());
    }

    }

