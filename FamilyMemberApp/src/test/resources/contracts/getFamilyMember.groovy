package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return member list")

    request {
        url "/getFamilyMember?familyId=2"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType('application/json')
        }
        body([
                [
                    id: 1,
                    familyId: 2,
                    givenName: "Artur",
                    familyName: "Nowak",

                ],
                [
                    id: 2,
                    familyId: 2,
                    givenName: "Agnieszka",
                    familyName: "Nowak"
                ]
        ])
    }
}
