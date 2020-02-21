INSERT INTO
    application_user (password, username)
    VALUES ('$2a$10$cR2ZuH7smUjKf.r3nkuRd./TZ4rClDdEthU8CzKCm0vvD1CO./QMq', 'supausa');

/*INSERT INTO
    appointment (date, description, email, patient_name, phone_number, specialist)
    VALUES ('2020-02-11 11:00:00', 'fáj a hasam!', 'zacsi@broki.hu', 'Pumped Gabó', '+361234567', 'fogorvos');

 INSERT INTO
    appointment (date, description, email, patient_name, phone_number, specialist)
    VALUES ('2020-02-12 11:00:00', 'leesett a fal', 'email@email.hu', 'Kovácsné Gizike', '+361234567', 'sebész');*/

INSERT INTO
    doctor (doctor_id, introduction, name)
    VALUES ('doctor_id1', 'Zsolt vagyok, 27 éves, 30 év tapasztalattal.', 'Zsolt');

INSERT INTO
    doctor (doctor_id, introduction, name)
    VALUES ('doctor_id2', 'Desc', 'Alajos');

INSERT INTO
    doctor (doctor_id, introduction, name)
    VALUES ('doctor_id3', 'Gitmaster', 'Nelav');

INSERT INTO
    medical_specialty (name_of_specialty)
    VALUES ('fogorvos');

INSERT INTO
    medical_specialty (name_of_specialty)
    VALUES ('sebész');

INSERT INTO
    medical_specialty (name_of_specialty)
    VALUES ('urológus');

INSERT INTO
    medical_specialty (name_of_specialty)
    VALUES ('fazekas');

INSERT INTO
    medical_specialty (name_of_specialty)
    VALUES ('pszichiáter');