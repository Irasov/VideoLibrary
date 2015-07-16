package com.epam.irasov.videolibrary.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie extends NamedEntity {
    private Date release;
    private List<Member> members;
    private String country;

    public Movie() {
        super();
        members = new ArrayList<Member>();
    }

    public Movie(Date release, String country) {
        this();
        this.release = release;
        this.country = country;

    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public static class Member extends NamedEntity {
        private Date date;
        private String memberRole;

        public Member() {

        }

        public Member(Long id, String name, Date date, String memberRole) {
            super(id, name);
            this.date = date;
            this.memberRole = memberRole;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getMemberRole() {
            return memberRole;
        }

        public void setMemberRole(String memberRole) {
            this.memberRole = memberRole;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Member)) return false;
            if (!super.equals(o)) return false;
            Member member = (Member) o;
            return !(date != null ? !date.equals(member.date) : member.date != null) && !(memberRole != null ? !memberRole.equals(member.memberRole) : member.memberRole != null);

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (date != null ? date.hashCode() : 0);
            result = 31 * result + (memberRole != null ? memberRole.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return super.toString() +
                    "date=" + date +
                    ", memberRole=" + memberRole;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return !(release != null ? !release.equals(movie.release) : movie.release != null) && !(members != null ? !members.equals(movie.members) : movie.members != null) && !(country != null ? !country.equals(movie.country) : movie.country != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (release != null ? release.hashCode() : 0);
        result = 31 * result + (members != null ? members.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = " release=" + release +
                     ", country=" + country +
                     ", members:\n";
        for (Member member : members) {
            str += member.toString() + "\n";
        }
        return super.toString()+str;
    }
}
