package HW13;

public class Commentary {
    class Comment {
        private Integer postId;
        private Integer id;
        private String name;
        private String email;
        private String body;

        public Integer getPostId() {
            return postId;
        }

        public void setPostId(Integer postId) {
            this.postId = postId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\n");
            sb.append("name = ").append(name).append("\n");
            sb.append("body = ").append(body).append("\n");
            return sb.toString();
        }
    }
}
