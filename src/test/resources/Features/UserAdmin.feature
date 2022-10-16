Feature: User Admin Test
  Scenario: Masuk dengan tidak memasukan username
    Given User mengakses url
    When User berada di dalam halaman login
    And User memasukan username ""
    And User menekan tombol Login
    Then User mendapatkan kata informasi pada bagian username

  Scenario: Masuk dengan tidak memasukan password
    Given User mengakses url
    When User berada di dalam halaman login
    When User memasukan username "anggis15"
    And User memasukan password ""
    And User menekan tombol Login
    Then User mendapatkan kata informasi pada bagian password

  Scenario: Masuk dengan username salah dan password benar
    Given User mengakses url
    When User berada di dalam halaman login
    When User memasukan username "anggis15"
    And User memasukan password "d1k4@passw0rd"
    And User menekan tombol Login
    Then User mendapatkan kata informasi gagal login

  Scenario: Masuk dengan username benar dan password salah
    Given User mengakses url
    When User berada di dalam halaman login
    When User memasukan username "admindika"
    And User memasukan password "lalala"
    And User menekan tombol Login
    Then User mendapatkan kata informasi gagal login

  Scenario: Masuk dengan valid account
    Given User mengakses url
    When User berada di dalam halaman login
    When User memasukan username "admindika"
    And User memasukan password "d1k4@passw0rd"
    And User menekan tombol Login
    Then User berhasil login dan berada dalam halaman home

  Scenario: login sebagai admin
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    Then user berada di dashboard admin

  Scenario: klik menu view & export
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    Then user berada di halaman View & Export

  Scenario: klik button export saat data default(kosong)
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user klik button export
    Then user mendapatkan notif error export

  Scenario: klik button download saat data default(kosong)
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user klik button download
    Then user mendapatkan notif error download

  Scenario: menentukan start-date dan end-date terus filter data valid
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat data ditemukan

  Scenario: menentukan start-date dan end-date terus filter data invalid
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date invalid
    And klik filter
    Then user melihat data tidak ditemukan

  Scenario: klik View pada Data yang dipilih
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    And klik View pada Data
    Then user melihat detail data

  Scenario: klik button export data valid
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    And klik export
    Then data berhasil di export

  Scenario: klik button export data invalid
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date invalid
    And klik filter
    And klik export
    Then user mendapat notif

  Scenario: klik button download data valid
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    And klik download
    Then data berhasil didownload

  Scenario: klik button download data invalid
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date invalid
    And klik filter
    And klik donwload
    Then user mendapat notif Danger! Data Tidak Ada

  Scenario: otomatis terisi angka
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user No terisi

  Scenario: menampilkan Action(View)
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat Action (View)

  Scenario: Menampilkan Tanggal Submit
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat Tanggal Submit

  Scenario: Menampilkan Nama
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat Nama

  Scenario: Menampikan Nomor BPJS
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat Nomor BPJS

  Scenario: Menampikan Nomor KTP
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat Nomor KTP

  Scenario: Menampikan foto Faskes Awal
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat foto Faskes Awal

  Scenario: Menampilkan foto Faskes Tujuan
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat foto faskes tujuan

  Scenario: Menampikan Aggrement
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    Then user melihat Aggrement

  Scenario: Mengecek button refresh
    Given user berada di halaman login
    When user input valid username dan password
    And click login
    And user klik menu View & Export
    And user isi start date dan end date
    And klik filter
    And klik refresh
    Then user melihat data terrefresh
