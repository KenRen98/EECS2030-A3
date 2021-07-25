package org.eecs.a3.teamafk.MLS;

public class Owner implements MLSInterface {

    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    /**
     * Set the firstname of the property
     * @param firstname of the property
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Set the lastname of the property
     * @param lastname of the property
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Set the phone of the property
     * @param phone of the property
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the email of the property
     * @param email of the property
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the firstname of the property
     * @return the firstname of the property
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Get the lastname of the property
     * @return the lastname of the property
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Get the phone of the property
     * @return the phone of the property
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get the email of the property
     * @return the email of the property
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String Display() {
        return "Firstname: " + firstname + "<br/>" + "Lastname: " + lastname + "<br/>" + "Phone: " + phone + "<br/>" + "Email: " + email;
    }

    /**
     * Builder design pattern to facilitate construction of an
     * MLS record.
     */
    public static class Builder{

        private String firstname;
        private String lastname;
        private String phone;
        private String email;

        /**
         * Set the firstname of the property
         * @param firstname of the property
         * @return the Builder object
         */
        public Builder firstnameOfOwner(String firstname) {
            this.firstname = firstname;
            return this;
        }

        /**
         * Set the lastname of the property
         * @param lastname of the property
         * @return the Builder object
         */
        public Builder lastnameOfOwner(String lastname) {
            this.lastname = lastname;
            return this;
        }

        /**
         * Set the phone of the property
         * @param phone of the property
         * @return the Builder object
         */
        public Builder phoneNumber(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * Set the email of the property
         * @param email of the property
         * @return the Builder object
         */
        public Builder emailAddress(String email) {
            this.email = email;
            return this;
        }

        /**
         * Finalize the construction of owner using Builder design pattern.
         * @return the MLS record using the previously collected information
         * provided to the Builder object.
         */
        public Owner build(){
            Owner ow = new Owner();
            ow.firstname = this.firstname;
            ow.lastname = this.lastname;
            ow.phone = this.phone;
            ow.email = this.email;
            return ow;
        }
    }
}
