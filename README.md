# project15-2018

# SISTEM ZA KAFIC

Sistem za kafic koji se koristi za upravljanje porudzbinama u kaficu i generisanje izvestaja za odredjeni vremenski period.


Uputsvo za koriscenje:

U login stranici unosi se username i password radnika koji je zaduzen za odgovarajucu smenu. Ukoliko je radnik admin otvara se poseban prozor za upravljanje bazom radnika i artikla, i za generisanje izvestaja.

primer za obicnog korisnika:
username: uros.veljkovic
password: lozinka

primer za admina:
username: nikola.vujic
password: lozinka

U glavnom prozoru se nalaze stolovi na koje radnik moze da pritisne kako bi ih selektovao. Protiskom na Novi Racun dugme otvara se novi prozor u koje moze da se bitaju artikli koji idu na racun, racun je vezan za selektovani sto. Nakon dodavanja racuna u desoj strani programa se prikazuje racun crvene boje. Radnik pritiskom na taj racun moze da doda uplatu za racun. Nakon uspesne uplate racun menja boju u zelenu i ne moze se ponovo otvarati. Pritiskom na Kraj Rada dugme svi racuni se beleze u bazu i radnik se automatski izloguje, pritiskom na LogOut dugme radnik moze da se izloguje bez pamcenja racuna.

Napomena: Ukoliko scroll na listi racuna ne radi, potrebno je pritisnuti jos jednom na bilo koji obradjen racun (racun zelene boje).

U Admin prozoru nalaze se opcije za dodavanje/brisanje radnika/artikla, kao i opcija za generisanje izvestaja koja otvara nov prozor sa opcijama za generisanje izvestaja. Izvestaj je moguce sacuvati u plain-text formatu.
