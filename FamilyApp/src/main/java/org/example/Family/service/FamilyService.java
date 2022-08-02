package org.example.Family.service;

import lombok.RequiredArgsConstructor;
import org.example.Family.controller.dto.FamilyDto;
import org.example.Family.model.Family;
import org.example.Family.model.FamilyMember;
import org.example.Family.repository.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository repository;

    public Long createFamily(FamilyDto request) {
        if (validateFamilyData(request)) {
            return (repository.saveAndFlush(
                            new Family(
                                    request.getFamilyName(),
                                    request.getNrOfInfants(),
                                    request.getNrOfChildren(),
                                    request.getNrOfAdults()))
                    .getId());
        } else return null;
    }

    public boolean validateFamilyData(FamilyDto family) {
        int infants = 0;
        int children = 0;
        int adults = 0;
        for (FamilyMember member : family.getFamilyMembers()) {
            if (member.getAge() >= 0 && member.getAge() <= 4) infants++;
            else if (member.getAge() > 4 && member.getAge() <= 16) children++;
            else if (member.getAge() > 16) adults++;
        }
        return family.getNrOfInfants() == infants &&
                family.getNrOfChildren() == children &&
                family.getNrOfAdults() == adults;
    }
}
