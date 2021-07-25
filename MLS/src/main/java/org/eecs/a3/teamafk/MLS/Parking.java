package org.eecs.a3.teamafk.MLS;


public class Parking implements MLSInterface{

    private int size;
    private String type;
    private boolean isRVok;


    /**
     * Set the ID of the property
     * @param size of the property
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Set the ID of the property
     * @param type of the property
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the ID of the property
     * @param risRVok of the property
     */
    public void setIsRVok(boolean risRVok) {
        this.isRVok = isRVok;
    }

    /**
     * Get the size of the property
     * @return the size of the property
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the type of the property
     * @return the type of the property
     */
    public String getType() {
        return type;
    }

    /**
     * Get the IsRVok of the property
     * @return the IsRVok of the property
     */
    public boolean getIsRVok() {
        return isRVok;
    }

    @Override
    public String Display() {
        return "Parking information: <br/>" + "Type: " + type + "<br/>" + "Size: " + size + " Cars" + "<br/>" + "RV Space: " + stringhelper(isRVok) ;
    }


    /**
     * Builder design pattern to facilitate construction of an
     * MLS record.
     */
    public static class Builder {

        private int size;
        private String type;
        private boolean isRVok;

        /**
         * Set the size of the property
         * @param size of the property
         * @return the Builder object
         */
        public Builder sizeofParking(int size) {
            this.size = size;
            return this;
        }

        /**
         * Set the type of the property
         * @param type of the property
         * @return the Builder object
         */
        public Builder typeofParking(String type) {
            this.type = type;
            return this;
        }

        /**
         * Set the isRVok of the property
         * @param isRVok of the property
         * @return the Builder object
         */
        public Builder RVofParking(boolean isRVok) {
            this.isRVok = isRVok;
            return this;
        }

        /**
         * Finalize the construction of an parking object using Builder design pattern.
         * @return the MLS record using the previously collected information
         * provided to the Builder object.
         */
        public Parking build() {
            Parking pk = new Parking();
            pk.size = this.size;
            pk.type = this.type;
            pk.isRVok = this.isRVok;
            return pk;
        }
    }

    /**
     * Help to convert Boolean to string
     * @param something
     * @return A string of yes or no
     */
    protected String stringhelper(boolean something){
        if (something == true){
            return "YES";
        }
        return "NO";
    }

}
