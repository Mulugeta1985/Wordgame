
public class person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public person(String firstName) {
                this.firstName = firstName;
                this.lastName = "";
        }

        public person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
        }
}