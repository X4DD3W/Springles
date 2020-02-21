DROP TABLE if exists doctor;
DROP TABLE if exists application_user;
DROP TABLE if exists appointment;
DROP TABLE if exists medical_specialty;

CREATE TABLE doctor
(
    id              int primary key auto_increment,
    doctor_id       varchar(255),
    introduction    varchar(255),
    name        varchar(255)
);

CREATE TABLE application_user
(
    id          int primary key auto_increment,
    password    varchar(255),
    username    varchar(255)
);

CREATE TABLE medical_specialty
(
    id          int primary key auto_increment,
    name_of_specialty   varchar(255)/*,
    doctor_fkey int,
    foreign key (doctor_fkey) references doctor(id)*/
);

CREATE TABLE appointment
(
    id       int primary key auto_increment,
    date     varchar(255),
    description    varchar(255),
    email     varchar(255),
    patient_name varchar(255),
    phone_number varchar(255),
    specialist varchar(255)/*,
    doctor_fkey int,
    foreign key (doctor_fkey) references doctor(id)*/
);