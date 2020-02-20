Feature: Logowanie do aplikacji

Scenario: Poprawne logowanie
Given Uzytkownik uruchamia przegladarke
And Uzytkownik jest na stronie "https://phptravels.net/login"
When Uzytkownik w pole name "username" wpisuje "user@phptravels.com"
And Uzytkownik w pole name "password" wpisuje "demouser"
And Uzytkownik klika w przycisk '//*[@id="loginfrm"]/button'
Then Uzytkownik przechodzi na strone "https://www.phptravels.net/account/"