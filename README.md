# Hospital System

## Project Description
The Hospital System project is a Java-based application that simulates the management of a hospital. It allows the user (an administrator) to perform various operations such as adding doctors, services, and patients, as well as displaying information about doctors, patients, and their bills.

## Project Files
The project consists of the following Java files:

1. `DuplicateServiceIdException.java`: Defines a custom exception for handling duplicate service IDs.
2. `Identifier.java`: Defines a base class for objects with unique IDs.
3. `Person.java`: Defines a base class for persons with basic information (name, phone, email).
4. `AdministrationStaff.java`: Defines a class for administrative staff members, which extends the `Person` class.
5. `Services.java`: Defines a class for services provided by the hospital, which extends the `Identifier` class.
6. `Employees.java`: Defines an abstract class for employees of the hospital, which extends the `Person` class.
7. `Patients.java`: Defines a class for patients, which extends the `Person` class.
8. `Doctors.java`: Defines a class for doctors, which extends the `Employees` class.
9. `HospitalSystem.java`: The main class that contains the entry point of the program and the implementation of the hospital management system.


## Features
The Hospital System project provides the following features:

1. **Add a Doctor**: Allows the user to add a new doctor to the system, including their ID, name, phone, email, salary, rank, and specialty.
2. **Add a Service**: Allows the user to add a new service to the system, including the service ID, name, and price.
3. **Add a Patient**: Allows the user to add a new patient to the system, including their ID, name, phone, email, type (A, B, or C), and the services they have received. The patient is also associated with a doctor.
4. **Print All Doctors Information**: Displays the information of all the doctors in the system.
5. **Print All Patients Information**: Displays the information of all the patients in the system.
6. **Display Specific Doctor Data**: Allows the user to view the information of a specific doctor based on their ID.
7. **Display Specific Patient Data**: Allows the user to view the information of a specific patient based on their ID.
8. **Print a Specific Patient's Bill**: Displays the bill for a specific patient based on their ID.
9. **Exit the Program**: Allows the user to exit the program.
