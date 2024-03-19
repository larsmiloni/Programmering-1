import java.util.ArrayList;

public class PropertyRegister {

    /**
     * Chose ArrayList because...
     */
    private ArrayList<Property> properties;

    public PropertyRegister(){
        this.properties = new ArrayList<>();
    }

    public Property registerProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
                                     String name, double area, String ownerName){
        Property newProperty = new Property(municipalityNumber,municipalityName,lotNumber,sectionNumber,name,area,ownerName);
        // Bruker equals override
        if(properties.contains(newProperty)){
            throw new IllegalArgumentException("Property already registered");
        }
        properties.add(newProperty);

        //Hva er feil her? Må huske å dypkopiere!!!
        //(Vis hvordan, og kopikonstruktør)
        return newProperty;
        //return new Property(newProperty);
    }

    public Property registerProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
                                     double area, String ownerName){
        Property newProperty = new Property(municipalityNumber,municipalityName,lotNumber,sectionNumber,area,ownerName);
        if(properties.contains(newProperty)){
            throw new IllegalArgumentException("Property already registered");
        }
        properties.add(newProperty);
        //Hva er feil her? Må huske å dypkopiere!!!
        return newProperty;
        //return new Property(newProperty);
    }

    public Property findProperty(String uniqueId){
        for(Property p : properties){
            if (p.getUniqueId().equals(uniqueId)){
                return new Property(p);
            }
        }
        return null;
    }

    public Property findProperty(int municipalityNumber, int lotNumber, int sectionNumber){
        for(Property p : properties){
            if (p.getMunicipalityNumber() == municipalityNumber && p.getLotNumber() == lotNumber &&
                    p.getSectionNumber() == sectionNumber){
                return new Property(p);
            }
        }
        return null;
    }

    /**
     * Removes an property based on unique ID
     * @param uniqueId
     * @return if property not present returns false
     */
    public boolean removeProperty(String uniqueId){
        Property property = findProperty(uniqueId);
        if(property == null){
            return false;
        }
        return properties.remove(property);
    }

    public ArrayList<Property> findPropertiesByLotNumber(int lotNumber){
        ArrayList<Property> propertiesByLotNumber = new ArrayList<>();
        for(Property p : properties){
            if(p.getLotNumber() == lotNumber) {
                propertiesByLotNumber.add(new Property(p));
            }
        }
        return propertiesByLotNumber;
    }


    public int getNumberOfProperties(){
        return properties.size();
    }

    public double getAverageArea(){
        double sum = 0;
        for(Property p : properties){
            sum += p.getArea();
        }
        return sum/getNumberOfProperties();
    }

    public ArrayList<Property> getProperties() {
        ArrayList<Property> copy = new ArrayList<>();
        for(Property p : properties){
            copy.add(new Property(p));
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder propertiesToString = new StringBuilder("PropertyRegister\n");
        for(Property p : properties){
            propertiesToString.append(p.toString()).append("\n");
        }
        return String.valueOf(propertiesToString);
    }
}