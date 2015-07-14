package com.epam.irasov.videolibrary.entity;

import java.time.LocalDate;
import java.util.List;

public class Movie extends NamedEntity {
    private LocalDate release;
    private List<Member> members;
    private String country;

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
