# Database Schema Design

## Table: users
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `email` (VARCHAR, UNIQUE, NOT NULL)
- `password` (VARCHAR, NOT NULL)
- `role` (VARCHAR, NOT NULL)

## Table: doctors
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `user_id` (BIGINT, FOREIGN KEY -> users.id)
- `name` (VARCHAR, NOT NULL)
- `specialty` (VARCHAR, NOT NULL)

## Table: patients
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `user_id` (BIGINT, FOREIGN KEY -> users.id)
- `first_name` (VARCHAR, NOT NULL)
- `last_name` (VARCHAR, NOT NULL)
- `email` (VARCHAR, NOT NULL)
- `phone` (VARCHAR, NOT NULL)
