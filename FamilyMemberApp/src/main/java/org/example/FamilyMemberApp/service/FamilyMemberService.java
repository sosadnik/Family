package org.example.FamilyMemberApp.service;

import lombok.RequiredArgsConstructor;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberDto;
import org.example.FamilyMemberApp.model.FamilyMember;
import org.example.FamilyMemberApp.repository.FamilyMemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository repository;

    public void saveFamilyMember(FamilyMemberDto familyMemberDto){

        repository.save(
                new FamilyMember(
                        familyMemberDto.getFamilyId(),
                        familyMemberDto.getFamilyName(),
                        familyMemberDto.getGivenName()));

    }
}
