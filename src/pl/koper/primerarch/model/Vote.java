package pl.koper.primerarch.model;

import java.sql.Timestamp;

public class Vote {
    private long id;
    private long primerid;
    private long userid;
    private Timestamp date;
    private VoteType voteType;

    public Vote() {
    }

    public Vote(Vote vote) {
        this.id = vote.id;
        this.primerid = vote.primerid;
        this.userid = vote.userid;
        this.date = vote.date;
        this.voteType = vote.voteType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrimerid() {
        return primerid;
    }

    public void setPrimerid(long primerid) {
        this.primerid = primerid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (primerid != vote.primerid) return false;
        if (userid != vote.userid) return false;
        if (date != null ? !date.equals(vote.date) : vote.date != null) return false;
        return voteType == vote.voteType;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (primerid ^ (primerid >>> 32));
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (voteType != null ? voteType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", primerid=" + primerid +
                ", userid=" + userid +
                ", date=" + date +
                ", voteType=" + voteType +
                '}';
    }
}
