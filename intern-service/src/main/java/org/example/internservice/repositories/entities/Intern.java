package org.example.internservice.repositories.entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.internservice.models.requests.CreateInternRequest;
import org.example.internservice.models.responses.InternResponse;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "interns")
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 1, max = 50)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be digits only, 8-15 characters")
    private String phoneNumber;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String university;
    private String degree;
    private String yearOfStudy;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<String> languages;

    @ElementCollection
    private List<String> certifications;

    @ElementCollection
    private List<String> interests;

    private Long currentInternshipId;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;


    //    public Intern(){
//        super();
//    }
//    public Intern(InternDto intern) {
//        this.university = intern.getUniversity();
//        this.degree = intern.getDegree();
//        this.yearOfStudy = intern.getYearOfStudy();
//        this.skills = intern.getSkills();
//        this.languages = intern.getLanguages();
//        this.certifications = intern.getCertifications();
//        this.interests = intern.getInterests();
//        this.firstName = intern.getFirstName();
//        this.lastName = intern.getLastName();
//        this.phoneNumber = intern.getPhoneNumber();
//        this.email = intern.getEmail();
//    }
    public Long getId() {
        return id;
    }


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Long  getCurrentInternship() {
        return currentInternshipId;
    }

    public void setCurrentInternship(Long currentInternshipId) {
        this.currentInternshipId = currentInternshipId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getCurrentInternshipId() {
        return currentInternshipId;
    }

    public void setCurrentInternshipId(Long currentInternshipId) {
        this.currentInternshipId = currentInternshipId;
    }

        public void requestToIntern(CreateInternRequest request){
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
        this.university = request.getUniversity();
        this.degree = request.getDegree();
        this.yearOfStudy = request.getYearOfStudy();
        this.skills = request.getSkills();
        this.languages = request.getLanguages();
        this.certifications = request.getCertifications();
        this.interests = request.getInterests();
        this.currentInternshipId = request.getCurrentInternshipId();
        this.joiningDate = request.getJoiningDate();
    }
    public InternResponse toResponse() {
        return new InternResponse(
                this.getId(),
                this.getFirstName(), this.getLastName(), this.getEmail(),
                this.getPhoneNumber(), this.getUniversity(), this.getDegree(),
                this.getYearOfStudy(), this.getSkills(), this.getLanguages(),
                this.getCertifications(), this.getInterests(), this.getCurrentInternshipId(),
                this.getJoiningDate(), this.getCreatedAt()
        );
    }
}
