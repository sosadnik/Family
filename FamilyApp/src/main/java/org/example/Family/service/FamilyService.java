package org.example.Family.service;

import lombok.RequiredArgsConstructor;
import org.example.Family.client.FamilyMemberClient;
import org.example.Family.controller.dto.FamilyRequest;
import org.example.Family.controller.dto.FamilyMemberRequest;
import org.example.Family.controller.dto.FamilyMemberRespond;
import org.example.Family.controller.dto.FamilyRespond;
import org.example.Family.model.Family;
import org.example.Family.model.FamilyMember;
import org.example.Family.repository.FamilyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository repository;
    private final FamilyMemberClient client;

    @Transactional
    public Long createFamily(FamilyRequest request) {
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

    private void saveMember(Long familyId, List<FamilyMemberRequest> familyMembers) {
        for (FamilyMemberRequest memberDto : familyMembers) {
            client.createFamilyMember(
                    new FamilyMember(
                            familyId,
                            memberDto.getGivenName(),
                            memberDto.getFamilyName()));
        }
    }

    public boolean validateFamilyData(FamilyRequest family) {
        int infants = 0;
        int children = 0;
        int adults = 0;
        for (FamilyMemberRequest member : family.getFamilyMembers()) {
            if (member.getAge() >= 0 && member.getAge() <= 4) infants++;
            else if (member.getAge() > 4 && member.getAge() <= 16) children++;
            else if (member.getAge() > 16) adults++;
        }
        return family.getNrOfInfants() == infants &&
                family.getNrOfChildren() == children &&
                family.getNrOfAdults() == adults;
    }

    public FamilyRespond getFamily(Long familyId) {
        Optional<Family> family = repository.findById(familyId);
        if (family.isPresent()){
            List<FamilyMemberRespond> familyMemberList = client.getFamilyMemberList(family.get().getId());
            return new FamilyRespond(
                    familyId,
                    family.get().getFamilyName(),
                    family.get().getNrOfInfants(),
                    family.get().getNrOfChildren(),
                    family.get().getNrOfAdults(),
                    familyMemberList);
        } else return null;
    }
}
