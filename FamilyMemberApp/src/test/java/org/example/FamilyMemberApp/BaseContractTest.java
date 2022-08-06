package org.example.FamilyMemberApp;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.example.FamilyMemberApp.controller.FamilyMemberController;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberRespond;
import org.example.FamilyMemberApp.service.FamilyMemberService;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BaseContractTest {

    @BeforeEach
    public void setup(){
        List<FamilyMemberRespond> memberList = new ArrayList<>();
        memberList.add(new FamilyMemberRespond(1L,2L,"Artur", "Nowak"));
        memberList.add(new FamilyMemberRespond(2L,2L,"Agnieszka", "Nowak"));

        FamilyMemberService service = mock(FamilyMemberService.class);
        given(service.getFamilyMemberList(any())).willReturn(memberList);

        RestAssuredMockMvc.standaloneSetup(new FamilyMemberController(service));
    }
}
