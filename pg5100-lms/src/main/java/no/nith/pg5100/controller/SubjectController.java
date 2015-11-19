package no.nith.pg5100.controller;

import no.nith.pg5100.dto.Subject;
import no.nith.pg5100.infrastructure.subject.SubjectDao;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class SubjectController {
    @Inject
    private SubjectDao subjectDao;

    public List<Subject> getAll() {
        return subjectDao.getAll();
    }
}
