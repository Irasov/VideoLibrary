package com.epam.irasov.videolibrary.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie extends NamedEntity {
    private Date release;
    private List<Member> members;
    private String country;

    public Movie(){
        super();
        members = new ArrayList<Member>();
    }

    public Movie(Date release, String country){
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

    public void addMember(Member member){
        members.add(member);
    }

    public static class Member extends NamedEntity{
        private  LocalDate date;
        private  String memberRole;
        public  Member(){

        }

        public Member(Long id, String name, LocalDate date, String memberRole) {
            super(id, name);
            this.date = date;
            this.memberRole = memberRole;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
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
            if (date != null ? !date.equals(member.date) : member.date != null) return false;
            return !(memberRole != null ? !memberRole.equals(member.memberRole) : member.memberRole != null);

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
            return "Member{" +
                    "date=" + date +
                    ", memberRole='" + memberRole + '\'' +
                    '}';
        }
    }

}
