package org.example.sjindividuellainlamning.services;

import org.example.sjindividuellainlamning.entities.Address;
import org.example.sjindividuellainlamning.entities.Member;
import org.example.sjindividuellainlamning.exceptions.DuplicateResourceException;
import org.example.sjindividuellainlamning.exceptions.InvalidDataException;
import org.example.sjindividuellainlamning.exceptions.ResourceNotFoundException;
import org.example.sjindividuellainlamning.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberServiceInterface {

    private final MemberRepository memberRepository;
    private final AddressServiceImpl addressServiceImpl;

    @Autowired
    public MemberService(MemberRepository memberRepository, AddressServiceImpl addressServiceImpl) {
        this.memberRepository = memberRepository;
        this.addressServiceImpl = addressServiceImpl;
    }

// CRUD ----------------------------------------------------------------------------------------------------------------

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
    }

    @Override
    public Member addNewMember(Member member) {

        String firstName = validateData("Member", "firstName", member.getFirstName());
        String lastName = validateData("Member", "lastName", member.getLastName());
        String dateOfBirth = validateData("Member", "dateOfBirth", member.getDateOfBirth());
        String email = validateData("Member", "email", member.getEmail());

        if (memberRepository.existsByEmail(email)) {
            throw new DuplicateResourceException("Member", "email", email);
        }

        Integer addressId = validateData("Member", "address.id",
                member.getAddress() != null ? member.getAddress().getId() : null);
        Address existingAddress = addressServiceImpl.getAddressById(addressId);

        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setDateOfBirth(dateOfBirth);
        member.setPhone(member.getPhone());
        member.setEmail(email);
        member.setAddress(existingAddress);

        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(int id, Member member) {
        Member existingMember = memberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", id));

        if (member.getFirstName() != null) {
            existingMember.setFirstName(validateData("Member", "firstName", member.getFirstName()));
        }

        if (member.getLastName() != null) {
            existingMember.setLastName(validateData("Member", "lastName", member.getLastName()));
        }

        if (member.getDateOfBirth() != null) {
            existingMember.setDateOfBirth(validateData("Member", "dateOfBirth", member.getDateOfBirth()));
        }

        if (member.getEmail() != null) {
            String newEmail = validateData("Member", "email", member.getEmail());
            if (!newEmail.equals(existingMember.getEmail()) &&
                    memberRepository.existsByEmail(newEmail)) {
                throw new DuplicateResourceException("Member", "email", newEmail);
            }
            existingMember.setEmail(newEmail);
        }

        if (member.getAddress() != null && member.getAddress().getId() != 0) {
            int addressId = validateData("Member", "address.id", member.getAddress().getId());
            Address existingAddress = addressServiceImpl.getAddressById(addressId);
            existingMember.setAddress(existingAddress);
        }

        existingMember.setPhone(member.getPhone());

        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        memberRepository.deleteById(id);
    }

// ADDITIONS -----------------------------------------------------------------------------------------------------------

    public <T> T validateData(String resource, String field, T value) {
        if (value == null) {
            throw new InvalidDataException(resource, field, value);
        }
        return value;
    }


}
