package no.nith.pg5100.controller;

import no.nith.pg5100.dto.Location;
import no.nith.pg5100.dto.Subject;
import no.nith.pg5100.dto.User;
import no.nith.pg5100.infrastructure.subject.SubjectDao;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Model
public class SubjectController {
    @Inject
    private SubjectDao subjectDao;

    private int subjectId;
    private Subject subject;

    public List<Subject> getAll() {
        return subjectDao.getAll();
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void initSubject() {
        subject = subjectDao.findById(subjectId);
    }

    public String getSelectedLocation() {
        Location location = subject.getLocation();
        return location.getBuilding() + " - " + location.getRoom();
    }

    public List<String> getSelectedUsers() {
        List<User> users = subject.getUsers();
        return users.stream().map(User::getEmail).collect(Collectors.toList());
    }
}
