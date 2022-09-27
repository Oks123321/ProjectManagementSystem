CREATE TABLE IF NOT EXISTS developers (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
	age INTEGER,
	gender VARCHAR(10)
	);

ALTER TABLE developers
ADD CONSTRAINT gender_enum_values
CHECK (gender IN ('male', 'female', 'unknown'));

ALTER TABLE developers
ALTER COLUMN gender SET NOT NULL;

ALTER TABLE developers owner to postgres;

CREATE TABLE IF NOT EXISTS projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    descriptions VARCHAR (200)
);
ALTER TABLE projects owner to postgres;

CREATE TABLE IF NOT EXISTS projects_developers_relation (
    projects_id BIGINT NOT NULL,
    developers_id BIGINT NOT NULL,
    FOREIGN KEY(projects_id) REFERENCES projects(id),
    FOREIGN KEY (developers_id) REFERENCES developers(id)
);

ALTER TABLE projects_developers_relation owner to postgres;

CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    branch VARCHAR(200),
    level VARCHAR(150)
);
ALTER TABLE skills owner to postgres;

CREATE TABLE developers_skills_relation (
    developers_id BIGINT NOT NULL,
	skills_id BIGINT NOT NULL,
    FOREIGN KEY (developers_id) REFERENCES developers(id),
	FOREIGN KEY(skills_id) REFERENCES skills(id)
);
ALTER TABLE developers_skills_relation owner to postgres;

CREATE TABLE IF NOT EXISTS companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    country VARCHAR(150)
);
ALTER TABLE companies owner to postgres;

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    description VARCHAR(150)
);
ALTER TABLE customers owner to postgres;

CREATE TABLE IF NOT EXISTS projects_customers_relation (
    projects_id BIGINT NOT NULL,
	customers_id BIGINT NOT NULL,
    FOREIGN KEY(customers_id) REFERENCES customers(id),
    FOREIGN KEY (projects_id) REFERENCES projects(id)
);
ALTER TABLE projects_customers_relation owner to postgres;

CREATE TABLE IF NOT EXISTS companies_developers_relation (
    developers_id BIGINT NOT NULL,
    companies_id BIGINT NOT NULL,
    FOREIGN KEY(developers_id) REFERENCES developers(id),
    FOREIGN KEY (companies_id) REFERENCES companies(id)
);
ALTER TABLE companies_developers_relation owner to postgres;
