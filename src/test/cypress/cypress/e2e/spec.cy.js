describe('e2e test with mocked server response', () => {
  it('passes', () => {

    cy.intercept('GET', '/command*', 'some txt').as('getCommand')

    cy.visit('/game')
    cy.get('#command').type('help{enter}')
    cy.wait('@getCommand')
    cy.get('body').contains('some txt')
  })
})

describe('breadcrumbs', () => {
  it('says "you are in the loo" in the first room', () => {
    cy.visit('/game')
    cy.get('h1').contains('you are in the loo')
  })
  it('says "you are in the washroom" in the second room', () => {
      cy.visit('/game')
      cy.get('#command').type('go to washroom{enter}')
      cy.get('h1').contains('you are in the washroom')
    })
})
