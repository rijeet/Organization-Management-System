
package tpd;

/**
 *
 * @author Swarnajit Saha
 */
public class OnlineConsult {
    String name,username,age,problem;

    public OnlineConsult(String name, String username, String age, String problem) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.problem = problem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
            
}
