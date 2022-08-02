package hello.hellospring.domain;

public class Member {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Member setId(long id) {
        this.id = id;
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
