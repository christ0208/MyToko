package org.codepository.mytoko.services;

import org.codepository.mytoko.models.dto.StaffCreateDto;
import org.codepository.mytoko.models.dto.StudentCreateDto;
import org.codepository.mytoko.models.dto.UserRemoveDto;
import org.codepository.mytoko.models.entity.Staff;
import org.codepository.mytoko.models.entity.Student;
import org.codepository.mytoko.models.enumeration.Campus;
import org.codepository.mytoko.models.enumeration.Division;
import org.codepository.mytoko.models.enumeration.Major;
import org.codepository.mytoko.repositories.UserRepository;

public class UserService {
    public Student handleCreateStudent(StudentCreateDto dto) {
        Student student = new Student(
                dto.getName(),
                convertToCampus(dto.getCampus()),
                convertToMajor(dto.getMajor())
        );
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.add(student);

        return student;
    }

    public Staff handleCreateStaff(StaffCreateDto dto) {
        Staff staff = new Staff(
                dto.getName(),
                convertToCampus(dto.getCampus()),
                convertToDivision(dto.getDivision()),
                dto.getPosition()
        );
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.add(staff);

        return staff;
    }

    public boolean handleRemoveUser(UserRemoveDto dto) {
        UserRepository userRepository = UserRepository.getInstance();

        return userRepository.remove(dto);
    }

    private Campus convertToCampus(String campus) {
        switch (campus) {
            case "Anggrek":
                return Campus.ANGGREK;
            case "Syahdan":
                return Campus.SYAHDAN;
            case "Kijang":
                return Campus.KIJANG;
        }

        return null;
    }

    private Major convertToMajor(String major) {
        major = major.toLowerCase();

        switch (major) {
            case "computer science":
                return Major.CS;
            case "information systems":
                return Major.IS;
        }

        return null;
    }

    private Division convertToDivision(String division) {
        switch (division) {
            case "SLC":
                return Division.SLC;
            case "SoCS":
                return Division.SOCS;
            case "IT":
                return Division.IT;
        }

        return null;
    }
}
