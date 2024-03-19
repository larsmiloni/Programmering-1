public class Property {

    private int municipalityNumber;
    private String municipalityName;
    private int lotNumber;
    private int sectionNumber;
    private String name;
    private double area;
    private String ownerName;

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String ownerName) {
        if (municipalityNumber < 101 || municipalityNumber > 5054){
            throw new IllegalArgumentException("Municipality number must be between 101 and 5054");
        }
        if (lotNumber <= 0){
            throw new IllegalArgumentException("Lot number must be a positive number");
        }
        if (sectionNumber <= 0){
            throw new IllegalArgumentException("Section number must be a positive number");
        }
        if(area <= 0){
            throw new IllegalArgumentException("Area must be a positive number");
        }
        if(municipalityName.isBlank()){
            throw new IllegalArgumentException("Municipality name can't be blank");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("Name can't be blank");
        }
        if(ownerName.isBlank()){
            throw new IllegalArgumentException("Owner name can't be blank");
        }


        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName.trim();
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name.trim();
        this.area = area;
        this.ownerName = ownerName.trim();
    }

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String ownerName) {
        if (municipalityNumber < 101 || municipalityNumber > 5054){
            throw new IllegalArgumentException("Municipality number must be between 101 and 5054");
        }
        if (lotNumber <= 0){
            throw new IllegalArgumentException("Lot number must be a positive number");
        }
        if (sectionNumber <= 0){
            throw new IllegalArgumentException("Section number must be a positive number");
        }
        if(area <= 0){
            throw new IllegalArgumentException("Area must be a positive number");
        }
        if(municipalityName.isBlank()){
            throw new IllegalArgumentException("Municipality name can't be blank");
        }
        if(ownerName.isBlank()){
            throw new IllegalArgumentException("Owner name can't be blank");
        }
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.ownerName = ownerName;
        this.area = area;
        this.name = "";
    }

    public Property(Property property) {
        this.municipalityNumber = property.getMunicipalityNumber();
        this.municipalityName = property.getMunicipalityName();
        this.lotNumber = property.getLotNumber();
        this.sectionNumber = property.getSectionNumber();
        this.ownerName = property.getOwnerName();
        this.name = property.getName();
        this.area = property.getArea();
    }

    /**
     * A property should be able to change its name
     * Method to set new property name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A property should be able to expand its area
     * Method to set new property area
     * @param area
     */
    public void setArea(double area) {
        if(area <= 0){
            throw new IllegalArgumentException("Area must be a positive number");
        }
        this.area = area;
    }

    /**
     * It should be able to transfer ownership of the property
     * Method to set new owners name
     * @param ownerName
     */
    public void setOwnerName(String ownerName) {
        if(ownerName.isBlank()){
            throw new IllegalArgumentException("Owner name can't be blank");
        }
        this.ownerName = ownerName;
    }

    public String getUniqueId(){
        return this.municipalityNumber + "-" + this.lotNumber + "/" + this.sectionNumber;
    }

    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "municipalityNumber=" + municipalityNumber +
                ", municipalityName='" + municipalityName + '\'' +
                ", lotNumber=" + lotNumber +
                ", sectionNumber=" + sectionNumber +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", ownerName='" + ownerName + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;

        Property property = (Property) o;
        return this.getUniqueId().equals(property.getUniqueId());
    }

    @Override
    public int hashCode() {
        int result = municipalityNumber;
        result = 31 * result + lotNumber;
        result = 31 * result + sectionNumber;
        return result;
    }
}