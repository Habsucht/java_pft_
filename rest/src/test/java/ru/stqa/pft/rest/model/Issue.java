package ru.stqa.pft.rest.model;

public class Issue {

    private int id;
    private String subject;
    private String description;
    private String state;

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }

    public Issue setId(int id) {
        this.id = id;
        return this;
    }

    public Issue setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Issue setDescription(String description) {
        this.description = description;
        return this;
    }

    public Issue setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        return id == issue.id && (subject != null ? subject.equals(issue.subject) : issue.subject == null
                              && (description != null ? description.equals(issue.description) : issue.description == null));
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
