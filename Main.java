import java.util.Scanner;

/**
 * <h1>AgriTourism System - OOP Inheritance Demonstration</h1>
 * <p>
 * This program demonstrates all five types of OOP inheritance in Java:
 * <ul>
 *   <li><b>Single Inheritance</b>: Tourism Domain</li>
 *   <li><b>Multilevel Inheritance</b>: Agriculture Domain</li>
 *   <li><b>Hierarchical Inheritance</b>: Agriculture Domain</li>
 *   <li><b>Multiple Inheritance</b>: Agri-Tourism Integration (using Interfaces)</li>
 *   <li><b>Hybrid Inheritance</b>: Integrated Agri-Tourism Business (Combining Multilevel and Multiple)</li>
 * </ul>
 * </p>
 *
 * @author Student Name
 * @version 1.0
 */

// ============================================================================
// 1. SINGLE INHERITANCE (Domain: Tourism)
// ============================================================================

/**
 * Base class representing a general tourism activity.
 */
class TouristSpot {
    protected String name;
    protected String location;

    /**
     * Constructs a TouristSpot instance.
     * @param name Name of the tourist spot
     * @param location Geographical location
     */
    public TouristSpot(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void displaySpotDetails() {
        System.out.println("Spot Name: " + name + " | Location: " + location);
    }
}

/**
 * Derived class representing an Eco-Tourism Spot (Single Inheritance).
 */
class EcoTourismSpot extends TouristSpot {
    private String ecoActivity;

    /**
     * Constructs an EcoTourismSpot instance.
     * @param name Name of spot
     * @param location Location of spot
     * @param ecoActivity Primary eco-friendly activity
     */
    public EcoTourismSpot(String name, String location, String ecoActivity) {
        super(name, location);
        this.ecoActivity = ecoActivity;
    }

    public void displayEcoDetails() {
        displaySpotDetails();
        System.out.println("Eco Activity: " + ecoActivity);
    }
}

// ============================================================================
// 2. MULTILEVEL INHERITANCE (Domain: Agriculture)
// ============================================================================

/**
 * Top-level Base class for agricultural products.
 */
class Crop {
    protected String cropName;

    public Crop(String cropName) {
        this.cropName = cropName;
    }

    public void showCropInfo() {
        System.out.println("Crop Type: " + cropName);
    }
}

/**
 * Intermediate derived class representing organic crops (Multilevel Inheritance Level 1).
 */
class OrganicCrop extends Crop {
    protected String certificationBody;

    public OrganicCrop(String cropName, String certificationBody) {
        super(cropName);
        this.certificationBody = certificationBody;
    }

    public void showOrganicInfo() {
        showCropInfo();
        System.out.println("Certified Organic By: " + certificationBody);
    }
}

/**
 * Sub-derived class representing harvested organic produce (Multilevel Inheritance Level 2).
 */
class HarvestedOrganicCrop extends OrganicCrop {
    private double yieldInTons;

    public HarvestedOrganicCrop(String cropName, String certificationBody, double yieldInTons) {
        super(cropName, certificationBody);
        this.yieldInTons = yieldInTons;
    }

    public void showHarvestDetails() {
        showOrganicInfo();
        System.out.println("Harvest Yield: " + yieldInTons + " Tons");
    }
}

// ============================================================================
// 3. HIERARCHICAL INHERITANCE (Domain: Agriculture)
// ============================================================================

/**
 * Base class for general agricultural equipment.
 */
class FarmEquipment {
    protected String equipmentName;

    public FarmEquipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void displayEquipment() {
        System.out.println("Equipment: " + equipmentName);
    }
}

/**
 * Child 1 derived from FarmEquipment.
 */
class Tractor extends FarmEquipment {
    private int horsePower;

    public Tractor(String equipmentName, int horsePower) {
        super(equipmentName);
        this.horsePower = horsePower;
    }

    public void displayTractorInfo() {
        displayEquipment();
        System.out.println("Type: Tractor | Horsepower: " + horsePower + " HP");
    }
}

/**
 * Child 2 derived from FarmEquipment.
 */
class Harvester extends FarmEquipment {
    private double capacityInTonsPerHour;

    public Harvester(String equipmentName, double capacityInTonsPerHour) {
        super(equipmentName);
        this.capacityInTonsPerHour = capacityInTonsPerHour;
    }

    public void displayHarvesterInfo() {
        displayEquipment();
        System.out.println("Type: Harvester | Processing Capacity: " + capacityInTonsPerHour + " Tons/Hour");
    }
}

// ============================================================================
// 4. MULTIPLE INHERITANCE (Domain: Agriculture + Tourism Integration via Interfaces)
// ============================================================================

/**
 * Interface defining Agricultural Services.
 */
interface AgriculturalService {
    void offerFarmTour();
}

/**
 * Interface defining Hospitality Services in Tourism.
 */
interface HospitalityService {
    void offerLodgingAndDining();
}

/**
 * Class implementing multiple inheritance using interfaces.
 */
class FarmStayPackage implements AgriculturalService, HospitalityService {
    private String packageName;
    private double pricePerNight;

    public FarmStayPackage(String packageName, double pricePerNight) {
        this.packageName = packageName;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public void offerFarmTour() {
        System.out.println("Service 1: Guided Organic Farm Tour & Fruit Picking included.");
    }

    @Override
    public void offerLodgingAndDining() {
        System.out.println("Service 2: Eco-Cottage Lodging & Organic Farm-to-Table Dining included.");
    }

    public void showPackageInfo() {
        System.out.println("Package Name: " + packageName + " | Rate: $" + pricePerNight + "/night");
        offerFarmTour();
        offerLodgingAndDining();
    }
}

// ============================================================================
// 5. HYBRID INHERITANCE (Combining Multilevel Class Hierarchy + Multiple Interfaces)
// ============================================================================

/**
 * Base Enterprise Class
 */
class BusinessUnit {
    protected String regNumber;

    public BusinessUnit(String regNumber) {
        this.regNumber = regNumber;
    }
}

/**
 * Multilevel child class
 */
class AgriBusinessUnit extends BusinessUnit {
    protected String farmLocation;

    public AgriBusinessUnit(String regNumber, String farmLocation) {
        super(regNumber);
        this.farmLocation = farmLocation;
    }
}

/**
 * Hybrid Class inheriting from AgriBusinessUnit and implementing AgriculturalService & HospitalityService
 */
class IntegratedAgriTourismResort extends AgriBusinessUnit implements AgriculturalService, HospitalityService {
    private String resortName;

    public IntegratedAgriTourismResort(String regNumber, String farmLocation, String resortName) {
        super(regNumber, farmLocation);
        this.resortName = resortName;
    }

    @Override
    public void offerFarmTour() {
        System.out.println("Resort Feature: Interactive Agriculture & Crop Cultivation Workshops.");
    }

    @Override
    public void offerLodgingAndDining() {
        System.out.println("Resort Feature: Luxury Eco-Resort Stay with Vineyard Wine Tasting.");
    }

    public void displayResortSummary() {
        System.out.println("Resort Name: " + resortName);
        System.out.println("Registration No: " + regNumber + " | Location: " + farmLocation);
        offerFarmTour();
        offerLodgingAndDining();
    }
}

// ============================================================================
// MENU-DRIVEN MAIN CLASS
// ============================================================================

/**
 * Main application class executing the menu-driven system.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=======================================================");
            System.out.println("   AGRICULTURE & TOURISM OOP INHERITANCE DEMO SYSTEM   ");
            System.out.println("=======================================================");
            System.out.println("1. Single Inheritance (Tourism Domain)");
            System.out.println("2. Multilevel Inheritance (Agriculture Domain)");
            System.out.println("3. Hierarchical Inheritance (Agriculture Domain)");
            System.out.println("4. Multiple Inheritance (Agri-Tourism Integration)");
            System.out.println("5. Hybrid Inheritance (Agri-Tourism Enterprise)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1 and 6: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            System.out.println("-------------------------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println(">>> DEMONSTRATING SINGLE INHERITANCE <<<");
                    EcoTourismSpot ecoSpot = new EcoTourismSpot("Spice Plantation Sanctuary", "Goa, India", "Guided Botanical Walk");
                    ecoSpot.displayEcoDetails();
                    break;

                case 2:
                    System.out.println(">>> DEMONSTRATING MULTILEVEL INHERITANCE <<<");
                    HarvestedOrganicCrop organicRice = new HarvestedOrganicCrop("Basmati Rice", "USDA Organic", 45.5);
                    organicRice.showHarvestDetails();
                    break;

                case 3:
                    System.out.println(">>> DEMONSTRATING HIERARCHICAL INHERITANCE <<<");
                    Tractor tractor = new Tractor("Mahindra 575 DI", 45);
                    Harvester harvester = new Harvester("John Deere W70", 12.5);
                    System.out.println("[Child Class 1]");
                    tractor.displayTractorInfo();
                    System.out.println("\n[Child Class 2]");
                    harvester.displayHarvesterInfo();
                    break;

                case 4:
                    System.out.println(">>> DEMONSTRATING MULTIPLE INHERITANCE (via Interfaces) <<<");
                    FarmStayPackage package1 = new FarmStayPackage("Green Valley Agri-Stay", 150.00);
                    package1.showPackageInfo();
                    break;

                case 5:
                    System.out.println(">>> DEMONSTRATING HYBRID INHERITANCE <<<");
                    IntegratedAgriTourismResort resort = new IntegratedAgriTourismResort("REG-AGRI-2026-99", "Mahabaleshwar, India", "Highland Agro-Resort");
                    resort.displayResortSummary();
                    break;

                case 6:
                    System.out.println("Exiting the program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}