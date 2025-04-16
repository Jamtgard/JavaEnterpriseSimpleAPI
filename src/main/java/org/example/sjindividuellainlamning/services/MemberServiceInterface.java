package org.example.sjindividuellainlamning.services;

import org.example.sjindividuellainlamning.entities.Member;

import java.util.List;

public interface MemberServiceInterface {

    List<Member> getMembers();
    Member getMemberById(int id);
    Member addNewMember(Member member);
    Member updateMember(int id, Member member);
    void deleteMember(int id);
}
