package HW13;

public class User {


        private Integer id;
        private String name;
        private String username;

        private String email;



        private String phone;

        private String website;



        public User(int i, String test_user, String test_username, String s){

        }

        public User(Integer id, String name, String username, String email,
                     String phone, String website) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.phone = phone;
            this.website = website;

        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public User withId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User withName(String name) {
            this.name = name;
            return this;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public User withUsername(String username) {
            this.username = username;
            return this;
        }

        public String getEmail() {
            return email;
        }


        public void setEmail(String email) {
            this.email = email;
        }

        public User withEmail(String email) {
            this.email = email;
            return this;
        }




        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public User withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public User withWebsite(String website) {
            this.website = website;
            return this;
        }




        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append(", \n");
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(", \n");
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null)?"<null>":this.name));
            sb.append(", \n");
            sb.append("username");
            sb.append(", \n");
            sb.append(((this.username == null)?"<null>":this.username));
            sb.append(", \n");
            sb.append("email");
            sb.append('=');
            sb.append(((this.email == null)?"<null>":this.email));
            sb.append(", \n");
            sb.append("phone");
            sb.append('=');
            sb.append(((this.phone == null)?"<null>":this.phone));
            sb.append(", \n");
            sb.append("website");
            sb.append('=');
            sb.append(((this.website == null)?"<null>":this.website));
            sb.append("\n");

            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

