package org.example.Family.service;

import lombok.RequiredArgsConstructor;
import org.example.Family.client.ClientFamilyMember;
import org.example.Family.controller.dto.FamilyDto;
import org.example.Family.controller.dto.FamilyMemberDto;
import org.example.Family.model.Family;
import org.example.Family.model.FamilyMember;
import org.example.Family.repository.FamilyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository repository;
    private final ClientFamilyMember client;

    @Transactional
    public Long createFamily(FamilyDto request) {
        if (validateFamilyData(request)) {
            Long familyId = repository.saveAndFlush(
                            new Family(
                                    request.getFamilyName(),
                                    request.getNrOfInfants(),
                                    request.getNrOfChildren(),
                                    request.getNrOfAdults()))
                    .getId();
            saveMember(familyId, request.getFamilyMembers());
            return familyId;
        } else return null;
    }

    private void saveMember(Long familyId, List<FamilyMemberDto> familyMembers) {
        for (FamilyMemberDto memberDto : familyMembers) {
            client.createFamilyMember(
                    new FamilyMember(
                            familyId,
                            memberDto.getGivenName(),
                            memberDto.getFamilyName()));
        }
    }

    public boolean validateFamilyData(FamilyDto family) {
        int infants = 0;
        int children = 0;
        int adults = 0;
        for (FamilyMemberDto member : family.getFamilyMembers()) {
            if (member.getAge() >= 0 && member.getAge() <= 4) infants++;
            else if (member.getAge() > 4 && member.getAge() <= 16) children++;
            else if (member.getAge() > 16) adults++;
        }
        return family.getNrOfInfants() == infants &&
                family.getNrOfChildren() == children &&
                family.getNrOfAdults() == adults;
    }
}
