DROP TABLE IF EXISTS USERS_COURSE;
DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    amount_enroll INTEGER
);

DROP TABLE IF EXISTS COURSE;

CREATE TABLE COURSE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL UNIQUE,
    description VARCHAR(500)
);

CREATE TABLE USERS_COURSE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    course_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES COURSE(id),
    FOREIGN KEY (user_id) REFERENCES USER(id)
);
