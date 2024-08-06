package Hospital;

import java.util.Vector;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HospitalSystem {

    // participants names method
    public static void msg() {

        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("Welcome to the hospital system");
        System.out.println("Student name: Hammad Mohammed Noor");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
    }

    // program options method
    public static void options() {

        System.out.println("1. Add a doctor");
        System.out.println("2. Add a service");
        System.out.println("3. Add a paitent");
        System.out.println("4. Print all doctors informations");
        System.out.println("5. Print all patient informations");
        System.out.println("6. Display specific doctor data");
        System.out.println("7. Display specific patient data");
        System.out.println("8. Print a specific patient's bill");
        System.out.println("9. Exit the program");
    }

    // method to check if the id of specific doctor is exist
    public static boolean checkDoctorIdExist(int ID, Vector<Doctors> docs) {

        for (int j = 0; j < docs.size(); j++) {

            if (docs.get(j).getId() == ID) {

                // return true if the ids are matched
                return true;
            }
        }

        // return false if the ids aren't matched
        return false;

    }

    // method to get specific doctor object by his id
    public static Doctors getDocById(int ID, Vector<Doctors> docs) {

        int doctor = 0;

        for (int d = 0; d < docs.size(); d++) {

            if (docs.get(d).getId() == ID) {

                doctor = d;
            }
        }

        return docs.get(doctor);
    }

    // method to check if the id of specific patient is exist
    public static boolean checkPatientIdExist(int ID, Vector<Patients> patients) {

        for (int j = 0; j < patients.size(); j++) {

            if (patients.get(j).getId() == ID) {

                return true;
            }
        }

        return false;

    }

    // method to get specific patient object by his id
    public static Patients getPatById(int ID, Vector<Patients> patients) {

        int patient = 0;

        for (int p = 0; p < patients.size(); p++) {

            if (patients.get(p).getId() == ID) {

                patient = p;
            }
        }

        return patients.get(patient);
    }

    // method that throws custom exception if same service id is utilized again
    static void checkServiceId(int ID, Vector<Services> services) throws DuplicateServiceIdException {

        for (int k = 0; k < services.size(); k++) {

            if (ID == services.get(k).getId()) {

                throw new DuplicateServiceIdException("Invalid service ID. This service\n" + "ID is already utilized!");
            }
        }

    }

    // method to check if specific service is exist
    static boolean checkServiceIdExist(int ID, Vector<Services> services) {

        for (int s = 0; s < services.size(); s++) {

            if (ID == services.get(s).getId()) {

                // return true if the ids are matched
                return true;
            }
        }

        // return if the ids aren't matched
        return false;

    }

    // method to get specific service object by its id
    public static Services getServById(int ID, Vector<Services> services) {

        int service = 0;

        for (int s = 0; s < services.size(); s++) {

            if (services.get(s).getId() == ID) {

                service = s;
            }
        }

        return services.get(service);
    }

    // method to check if the input is int
    public static int checkIfInt() {

        Scanner scanInt = new Scanner(System.in);
        try {

            return scanInt.nextInt();

        } catch (InputMismatchException ex) {

            // print a message if the exception happens
            System.out.println("Enter a valid type");
        }

        return -1;
    }

    // method to check if the input is double
    public static double checkIfDouble() {

        Scanner scanDouble = new Scanner(System.in);
        try {

            return scanDouble.nextDouble();

        } catch (InputMismatchException ex) {

            // print a message if the exception happens
            System.out.println("Enter a valid type");
        }

        return -1;
    }

    public static void main(String[] args) throws DuplicateServiceIdException {

        // vector to store Doctors class objects
        Vector<Doctors> doctors = new Vector<Doctors>();
        // vector to store AdministrationStaff class objects
        Vector<AdministrationStaff> administrations = new Vector<AdministrationStaff>();
        // vector to store services class objects
        Vector<Services> services = new Vector<Services>();
        // vector to store patients class objects
        Vector<Patients> patients = new Vector<Patients>();

        Doctors doc1 = new Doctors(1, "Ahmad", "Ali", "055555555", "ahmed@mail.com", 20000.00, "Medical director", "Neurosurgeon");
        Doctors doc2 = new Doctors(2, "Mohammad", "hussam", "055555555", "mohammad@mail.com", 20000.00, "Senior resident", "Neurosurgeon");

        AdministrationStaff admin1 = new AdministrationStaff(3, "Mohammad", "Atif", "055555555", "mo@mail.com", 50000.00, "Chief");
        AdministrationStaff admin2 = new AdministrationStaff(4, "Hammad", "Ali", "055555555", "hm@mail.com", 30000.00, "Chief assistant");
        AdministrationStaff admin3 = new AdministrationStaff(5, "Mahmoud", "Mohammad", "055555555", "mh@mail.com", 60000.00, "Scretary");

        // add objects to the vecotrs
        doctors.add(doc1);
        doctors.add(doc2);
        administrations.add(admin1);
        administrations.add(admin2);
        administrations.add(admin3);

        msg();
        boolean exit = false;
        int choice = 0;
        Scanner input = new Scanner(System.in);

        boolean exist = false;

        // check from adminstration first name and last name
        int errorDetector = 0;

        // loop to check the adminstration name 
        while (exist == false) {

            if (errorDetector > 0) { // if > 0, means this adminstration is not exist

                System.out.println("This adminstration is not exsist");
            }
            System.out.print("Enter your first name: ");
            String fNameIn = input.nextLine();

            System.out.print("Enter your last name: ");
            String lNameIn = input.nextLine();

            // check from the adminstration first and last name if it's exist or not
            for (int i = 0; i < administrations.size(); i++) {

                String checkFirstName = administrations.get(i).getFirstName();
                String checkLastName = administrations.get(i).getLastName();

                if (fNameIn.equals(checkFirstName) && lNameIn.equals(checkLastName)) {
                    // to exit the loop
                    exist = true;
                } else {
                    errorDetector++;
                }

            }
        }

        Scanner StringInputs = new Scanner(System.in);

        if (exist == true) { // if the adminstration has entered his first and last name correctly

            while (exit == false) {

                // print the program options
                options();
                System.out.print("Enter your choice:");
                try {
                    choice = input.nextInt();
                } catch (InputMismatchException ex) {

                    // print a message if the exception happens
                    System.out.println("Enter a valid type");
                    input.nextLine();
                    choice = 0;
                }

                switch (choice) {

                    case 1:

                        // case 1: add a doctor
                        // entering the doctor required informations
                        System.out.print("Enter doctor id: ");
                        int id = checkIfInt();

                        if (id == -1) {

                            continue;
                        }

                        if (id < 0) {

                            System.out.println("Enter a valid id number");
                            continue;
                        }

                        // check if doctor id is used
                        if (checkDoctorIdExist(id, doctors) == true) {

                            System.out.println("This doctor id is exist");
                            continue;
                        }
                        ;

                        System.out.print("Enter doctor first name: ");
                        String fName = StringInputs.nextLine();

                        System.out.print("Enter doctor last name: ");
                        String lName = StringInputs.nextLine();

                        System.out.print("Enter doctor phone number: ");
                        String phone = StringInputs.nextLine();

                        System.out.print("Enter doctor email: ");
                        String email = StringInputs.nextLine();

                        System.out.print("Enter doctor salary: ");
                        double salary = checkIfDouble();

                        if (salary == -1) {

                            continue;
                        }

                        if (salary < 0) {

                            System.out.println("Enter a valid number");
                            continue;
                        }

                        System.out.print("Enter doctor rank: ");
                        String rank = StringInputs.nextLine();

                        System.out.print("Enter doctor specialty: ");
                        String specialty = StringInputs.nextLine();

                        // create an object from the Doctors calss [create a doctor]
                        Doctors doctor = new Doctors(id, fName, lName, phone, email, salary, rank, specialty);

                        if (doctors.add(doctor) != true) {

                            System.out.println("Error");

                        } else { // if the object has been created successfully

                            System.out.println("Operation completed successfully");

                        }

                        break;

                    case 2:

                        // case 2: add a service
                        // entering the service required informations
                        System.out.print("Enter service id: ");
                        int serviceId = checkIfInt();

                        if (serviceId == -1) {
                            continue;
                        }

                        if (serviceId < 0) {

                            System.out.println("Enter a valid srevice id");
                            continue;
                        }

                        // check if the service id enterd by the user is exist
                        checkServiceId(serviceId, services);

                        System.out.print("Enter service name: ");
                        String serviceName = StringInputs.nextLine();

                        System.out.print("Enter service price: ");
                        double servicePrice = checkIfDouble();

                        if (servicePrice == -1) {
                            continue;
                        }

                        if (servicePrice < 0) {

                            System.out.println("Enter a valid number");
                            continue;
                        }

                        // create object from the Services class [create a service]
                        Services service = new Services(serviceId, serviceName, servicePrice);
                        if (services.add(service) != true) {

                            System.out.println("Error");

                        } else {

                            System.out.println("Operation completed successfully");
                        }

                        break;

                    case 3:

                        // case 3: add a patient
                        // entering the patient required informations
                        System.out.print("Enter patient id: ");
                        int patientId = checkIfInt();

                        if (patientId == -1) {

                            continue;
                        }

                        if (patientId < 0) {

                            System.out.println("Enter a valid patient id!");
                            continue;
                        }

                        // check if patient id is used
                        if (checkPatientIdExist(patientId, patients) == true) {

                            System.out.println("This patient id is exist");
                            continue;
                        }
                        ;

                        System.out.print("Enter patient first name: ");
                        String patientFirstName = StringInputs.nextLine();

                        System.out.print("Enter patient last name: ");
                        String patientLirstName = StringInputs.nextLine();

                        System.out.print("Enter patient phone number: ");
                        String patientPhone = StringInputs.nextLine();

                        System.out.print("Enter patient email: ");
                        String patientEmail = StringInputs.nextLine();

                        System.out.print("Enter your type: [A,B or C]: ");
                        String type = StringInputs.nextLine();

                        // check if the entered is a valid patient type
                        if (type.equals("A") || type.equals("B") || type.equals("C")) {

                        } else {

                            System.out.println("Enter a valid patient type!");
                            continue;
                        }

                        boolean addService = true;
                        //array to temporary store all the services choosed by the patient
                        int serviceIds[] = new int[services.size()];
                        int counter = 0;
                        double bill = 0;
                        while (addService == true) { // loop to get all the services selected for the patient

                            if (counter > 0) { // check if the patient want to add another service 

                                System.out.println("Enter true: to add another service \nEnter false: to exit add services ");

                                String add = StringInputs.nextLine();

                                if (add.equals("false")) { // if the patient does not want to add another service, exit the loop

                                    break;
                                }
                            }

                            System.out.println("Enter service id: ");
                            System.out.print("[");
                            for (int s = 0; s < services.size(); s++) {

                                System.out.print(services.get(s).getId() + ": " + services.get(s).getName() + ", ");
                            }
                            System.out.println("]");
                            int servId = checkIfInt();

                            if (servId == -1) {

                                continue;
                            }

                            if (servId < 0) {

                                System.out.println("Enter a valid service id");

                                continue;
                            }

                            boolean duplicatedService = false;
                            // check if the patient added this service before
                            for (int ids = 0; ids < serviceIds.length; ids++) {

                                if (servId == serviceIds[ids]) {

                                    // error message for choosing the same service again
                                    System.out.println("You have added this service before!");
                                    duplicatedService = true;
                                    break;
                                }
                            }

                            if (duplicatedService == true) {

                                continue;
                            }

                            // method to check if service id exsit 
                            if (checkServiceIdExist(servId, services) == false) {

                                System.out.println("This service is not exist!");
                                continue;
                            }

                            serviceIds[counter] = servId;
                            // count the bill of all services
                            bill += getServById(servId, services).getPrice();
                            counter++;
                            // if the user added all the avilable services
                            if (counter > services.size() - 1) {
                                break;
                            }

                        }

                        System.out.println("Enter doctor id: ");
                        System.out.print("[");
                        for (int d = 0; d < doctors.size(); d++) {

                            System.out.print(doctors.get(d).getId() + ": " + doctors.get(d).getFirstName() + " " + doctors.get(d).getLastName() + " ");
                        }
                        System.out.println("]");
                        int docId = checkIfInt();

                        if (docId == -1) {

                            continue;
                        }

                        if (docId < 0) {

                            System.out.println("Enter a valid service id!");

                            continue;
                        }

                        // method to check if doctor id exsit 
                        if (checkDoctorIdExist(docId, doctors) == false) {

                            System.out.println("This doctor is not exist!");
                            continue;
                        }

                        Patients patient = new Patients(patientId, patientFirstName, patientLirstName, patientPhone, patientEmail, type, bill);

                        // get services choosed by the pateint by its id from the Vector [services]
                        for (int i = 0; i < serviceIds.length; i++) {

                            for (int s = 0; s < services.size(); s++) {

                                if (serviceIds[i] == services.get(s).getId()) {

                                    // add the services choosed by the patient to the Vector [services] of the patient
                                    patient.setServices(services.get(s));
                                }
                            }
                        }

                        // get the doctor choosed by the pateint
                        for (int d = 0; d < doctors.size(); d++) {

                            if (docId == doctors.get(d).getId()) {

                                // add the doctor object to the patient's Vector [doctors]                                             
                                patient.setDoctor(doctors.get(d));

                                // add the patient to the doctros's vecotr [patients]
                                doctors.get(d).getPatients().add(patient);
                            }
                        }

                        if (patients.add(patient) != true) {

                            System.out.println("Error");

                        } else {

                            System.out.println("Operation completed successfully");

                        }
                        break;

                    case 4:

                        // case 4: print all doctors informations
                        int docCount = 0;

                        for (Doctors doc : doctors) { // pring each doctor object 

                            System.out.println(doc);
                            docCount++;
                        }

                        if (docCount == 0) {

                            System.out.println("There is no doctor added to the system yet");
                        }

                        break;

                    case 5:

                        // case 5: print all pateints informations
                        int patientCount = 0;

                        for (Patients pat : patients) { // print each patient object

                            System.out.println(pat);
                            patientCount++;
                        }

                        if (patientCount == 0) {

                            System.out.println("There is no patient added to the system yet");
                        }

                        break;

                    case 6:

                        // case 6: display specific doctor data
                        System.out.print("Enter the doctor id: ");
                        int doctorId = checkIfInt();

                        if (doctorId == -1) {

                            continue;
                        }

                        if (doctorId < 0) {

                            System.out.println("Enter a valid doctor id!");
                            continue;
                        }

                        //check if doctor id exist
                        if (checkDoctorIdExist(doctorId, doctors) == false) {

                            System.out.println("This doctor id is not exist");
                            continue;
                        }

                        // print the doctor data
                        System.out.println(getDocById(doctorId, doctors));

                        break;

                    case 7:

                        // case 7: dispaly specifc patient data
                        System.out.print("Enter patient id: ");
                        int pId = checkIfInt();

                        if (pId == -1) {

                            continue;
                        }

                        if (pId < 0) {

                            System.out.println("Enter a valid patient id");
                        }

                        if (checkPatientIdExist(pId, patients) == false) {

                            System.out.println("This patient id is not exist!");
                            continue;
                        }

                        // print the patient data
                        System.out.println(getPatById(pId, patients));

                        break;

                    case 8:

                        // case 8: print specific patient's bill
                        System.out.print("Enter patient id: ");
                        int patId = checkIfInt();

                        if (patId == -1) {

                            continue;
                        }

                        if (patId < 0) {

                            System.out.println("Enter a valid patient id");
                        }

                        // check if the patient id is exist
                        if (checkPatientIdExist(patId, patients) == false) {

                            System.out.println("This patient id is not exist!");
                            continue;
                        }

                        System.out.println("Patient Name: " + getPatById(patId, patients).getFirstName() + " " + getPatById(patId, patients).getLastName());
                        // print the patient's bill
                        System.out.println("Patient bill: " + getPatById(patId, patients).getBill() + " Sr");
                        break;

                    case 9:

                        // case 9: exist the program
                        System.out.println("Exiting from the program...");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;

                }

            }

        }

    }
}
