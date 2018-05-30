package pl.koper.primerarch.model;

import java.sql.Timestamp;

public class Primer {
    private long id;
    private String sequence;
    private String description;
    private Timestamp timestamp;
    private User user;
    private int upVote;
    private int downVote;

    public Primer() {
    }

    public Primer(Primer primer) {
        this.id = primer.id;
        this.sequence = primer.sequence;
        this.description = primer.description;
        this.timestamp = new Timestamp(primer.timestamp.getTime());
        this.user = primer.user;
        this.upVote = primer.upVote;
        this.downVote = primer.downVote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Primer primer = (Primer) o;

        if (id != primer.id) return false;
        if (upVote != primer.upVote) return false;
        if (downVote != primer.downVote) return false;
        if (sequence != null ? !sequence.equals(primer.sequence) : primer.sequence != null) return false;
        if (description != null ? !description.equals(primer.description) : primer.description != null) return false;
        if (timestamp != null ? !timestamp.equals(primer.timestamp) : primer.timestamp != null) return false;
        return user != null ? user.equals(primer.user) : primer.user == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + upVote;
        result = 31 * result + downVote;
        return result;
    }

    @Override
    public String toString() {
        return "Primer{" +
                "id=" + id +
                ", sequence='" + sequence + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", user=" + user +
                ", upVote=" + upVote +
                ", downVote=" + downVote +
                '}';
    }
}
