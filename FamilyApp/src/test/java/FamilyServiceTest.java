import org.example.Family.client.FamilyMemberClient;
import org.example.Family.controller.dto.FamilyRequest;
import org.example.Family.controller.dto.FamilyMemberRequest;
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
        FamilyMemberClient familyMemberClient = mock(FamilyMemberClient.class);
        service = new FamilyService(repository, familyMemberClient);
    }

    @Test
    void validateFamilyData_shouldReturnFalseForIncorrectNumberOfAdults(){
        List<FamilyMemberRequest> memberList = new ArrayList<>();
        memberList.add(new FamilyMemberRequest("Artur", "Nowak", 4));
        memberList.add(new FamilyMemberRequest("Andrzej", "Nowak", 16));
        memberList.add(new FamilyMemberRequest("Antonina", "Nowak", 24));
        memberList.add(new FamilyMemberRequest("Agnieszka", "Nowak", 34));
        memberList.add(new FamilyMemberRequest("Anna", "Nowak", 34));
        FamilyRequest family = new FamilyRequest("Nowak",1,1,2,memberList);

        boolean actual = service.validateFamilyData(family);

        assertEquals(false, actual);
    }

    @Test
    void validateFamilyData_shouldReturnTrueForCorrectNumberOfInfants(){
        List<FamilyMemberRequest> memberList = new ArrayList<>();
        memberList.add(new FamilyMemberRequest("Artur", "Nowak", 4));
        memberList.add(new FamilyMemberRequest("Andrzej", "Nowak", 1));
        memberList.add(new FamilyMemberRequest("Antonina", "Nowak", 0));
        FamilyRequest family = new FamilyRequest("Nowak",3,0,0,memberList);

        boolean actual = service.validateFamilyData(family);

        assertEquals(true, actual);
    }
    @Test
    void validateFamilyData_shouldReturnFalseNotAssignPersonWithWrongAgeToAnyGroup(){
        List<FamilyMemberRequest> memberList = new ArrayList<>();
        memberList.add(new FamilyMemberRequest("Artur", "Nowak", -3));
        memberList.add(new FamilyMemberRequest("Andrzej", "Nowak", 1));
        memberList.add(new FamilyMemberRequest("Antonina", "Nowak", 0));
        FamilyRequest family = new FamilyRequest("Nowak",3,0,0,memberList);

        boolean actual = service.validateFamilyData(family);

        assertEquals(false, actual);
    }
}
