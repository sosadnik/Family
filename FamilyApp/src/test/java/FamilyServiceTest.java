import org.example.Family.controller.dto.FamilyDto;
import org.example.Family.model.FamilyMember;
import org.example.Family.repository.FamilyRepository;
import org.example.Family.service.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class FamilyServiceTest {

    private FamilyService service;


    @BeforeEach
    public void setup(){
        FamilyRepository repository = mock(FamilyRepository.class);
        service = new FamilyService(repository);
    }

    @Test
    void validateFamilyData_shouldReturnFalseForIncorrectNumberOfAdults(){
        List<FamilyMember> memberList = new ArrayList<>();
        memberList.add(new FamilyMember("Artur", "Nowak", 4));
        memberList.add(new FamilyMember("Andrzej", "Nowak", 16));
        memberList.add(new FamilyMember("Antonina", "Nowak", 24));
        memberList.add(new FamilyMember("Agnieszka", "Nowak", 34));
        memberList.add(new FamilyMember("Anna", "Nowak", 34));
        FamilyDto family = new FamilyDto("Nowak",1,1,2,memberList);

        boolean actual = service.validateFamilyData(family);

        assertEquals(false, actual);
    }

    @Test
    void validateFamilyData_shouldReturnTrueForCorrectNumberOfInfants(){
        List<FamilyMember> memberList = new ArrayList<>();
        memberList.add(new FamilyMember("Artur", "Nowak", 4));
        memberList.add(new FamilyMember("Andrzej", "Nowak", 1));
        memberList.add(new FamilyMember("Antonina", "Nowak", 0));
        FamilyDto family = new FamilyDto("Nowak",3,0,0,memberList);

        boolean actual = service.validateFamilyData(family);

        assertEquals(true, actual);
    }
    @Test
    void validateFamilyData_shouldReturnFalseNotAssignPersonWithWrongAgeToAnyGroup(){
        List<FamilyMember> memberList = new ArrayList<>();
        memberList.add(new FamilyMember("Artur", "Nowak", -3));
        memberList.add(new FamilyMember("Andrzej", "Nowak", 1));
        memberList.add(new FamilyMember("Antonina", "Nowak", 0));
        FamilyDto family = new FamilyDto("Nowak",3,0,0,memberList);

        boolean actual = service.validateFamilyData(family);

        assertEquals(false, actual);
    }
}
