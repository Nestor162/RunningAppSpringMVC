package com.running.app.services.impl;

import com.running.app.dtos.ClubDto;
import com.running.app.exceptions.ClubNotFoundException;
import com.running.app.models.Club;
import com.running.app.repositories.ClubRepository;
import com.running.app.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@Service
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClub() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream()
                .map(this::mapToClubDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClubDto findClubById(Long clubId) {

        Club club =
                clubRepository.findById(clubId).orElseThrow(() -> new ClubNotFoundException(
                "Club not found!"));
        return mapToClubDto(club);

    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    private Club mapToClub(ClubDto club) {
        return new Club(club.getId(),club.getTitle(),
                club.getPhotoURL(),club.getContent(),
                club.getCreatedOn(),club.getUpdatedOn());
    }

    public ClubDto mapToClubDto(Club club){
        return new ClubDto(club.getId(),club.getTitle(),
                club.getPhotoURL(),club.getContent(),
                club.getCreatedOn(),club.getUpdatedOn());

    }

}

