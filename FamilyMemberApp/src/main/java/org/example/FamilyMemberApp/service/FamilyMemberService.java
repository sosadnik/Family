package org.example.FamilyMemberApp.service;

import lombok.RequiredArgsConstructor;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberRequest;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberRespond;
import org.example.FamilyMemberApp.model.FamilyMember;
import org.example.FamilyMemberApp.repository.FamilyMemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    private final FamilyMemberRepository repository;

    public void saveFamilyMember(FamilyMemberRequest familyMemberDto) {
        repository.save(
                new FamilyMember(
                        familyMemberDto.getFamilyId(),
                        familyMemberDto.getFamilyName(),
                        familyMemberDto.getGivenName()));
    }

    public List<FamilyMemberRespond> getFamilyMemberList(Long familyId) {
        List<FamilyMember> allByFamilyId = repository.findAllByFamilyId(familyId);
        List<FamilyMemberRespond> familyMemberResponds = new ArrayList<>();

        for (FamilyMember member : allByFamilyId) {
            familyMemberResponds.add(new FamilyMemberRespond(
                    member.getId(),
                    member.getFamilyId(),
                    member.getFamilyName(),
                    member.getGivenName()
            ));
        }
        return familyMemberResponds;
    }
}
