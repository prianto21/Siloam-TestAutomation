Feature: User Sales Test

  Background: user is logged in
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigate to the homepage sales

  Scenario: check user berada di homapage sales
    Then user is navigate to the homepage sales

  #Scenario: check user berada di menu input data
    When klik menu input
    Then user berada di Form Input

  #Scenario: check menu input data dengan data valid
    When user mengisi Nama,Nomor Bpjs,Nomor Ktp,Alamat,Kota Ktp,faskes awal,faskes tujuan dan alasan
    And User klik Simpan Data
    Then user berada di form upload document
