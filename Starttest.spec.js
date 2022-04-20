/// <reference types="cypress" />

describe('pet management', () => {

    it('add pet', () =>{
        cy.request({
            method: 'POST',
            url: '/pet',
            failOnStatusCode: true,
            body: {
                "id": 1,
                "category": {
                  "id": 1,
                  "name": "Dog"
                },
                "name": "Doggo",
                "photoUrls": [
                  "string"
                ],
                "tags": [
                  {
                    "id": 0,
                    "name": "string"
                  }
                ],
                "status": "available"
            }
        }).then((response)=>{
            expect(response.body).to.have.property("id", 1)
            expect(response.status).to.eql(200)
        })
    })
    
    it('view pet', ()=>{
        cy.request({
            method: 'GET',
            url: '/pet/1',
            failOnStatusCode: true,
        }).then((response)=>{
            expect(response.status).to.eql(200)
            expect(response.body).to.have.property("id", 1)
            expect(response.body).to.have.property("name", "Doggo")
        })
    })

    it('update pet', ()=>{
        cy.request({
            method: 'PUT',
            url: '/pet',
            failOnStatusCode: false,
            body: {
                "id": 1,
                "category": {
                    "id": 1,
                    "name": "Dog"
                },
                "name": "Dogssie",
                "photoUrls": [
                    "string"
                ],
                "tags": [
                    {
                    "id": 0,
                    "name": "string"
                    }
                ],
                "status": "available"
            }
        }).then((response)=>{
            expect(response.status).to.eql(200)
            expect(response.body).to.have.property("name", "Dogssie")
        })
    })

    it('delete pet', ()=>{
        cy.request({
            method: 'DELETE',
            url: '/pet/1',
            failOnStatusCode: true,
        }).then((response)=>{
            expect(response.status).to.eql(200)
            
        })
    })
})