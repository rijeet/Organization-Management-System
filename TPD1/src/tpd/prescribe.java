/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

/**
 *
 * @author Gopal Saha
 */
public class prescribe {
    String username;
    String problem;
    String solution;

    public prescribe(String username, String problem, String solution) {
        this.username = username;
        this.problem = problem;
        this.solution = solution;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    
}
