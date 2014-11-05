Feature: Load a CSA into the cloud

  Background: Onboard a new CSA

@focus
  Scenario: As a party I want to load a CSA into the cloud So that I am ready to upload trades
    Given the following actors exist and are connected to the CollateralCloud
    | Actor        | Name  |
    | Party        | A     |
    | Party        | B     |
    When the actors perform the following actions
    | Actor      | Message | Parameter |
    | A          | Upload  | CSA       |
    Then the following results should occur
    | Actor    | Message | MessageCount | Payload   |
    | A        | Ack     | 1            |           |
