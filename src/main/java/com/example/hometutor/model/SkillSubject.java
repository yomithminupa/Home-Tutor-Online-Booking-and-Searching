package com.example.hometutor.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
// Marks this class as a database entity
@Entity

// Used to identify this subclass type in inheritance    
@DiscriminatorValue("SKILL")
public class SkillSubject extends Subject {
    private String skillLevel;

    public SkillSubject() {
    }

    public SkillSubject(String id, String name, String gradeLevel, String description, String skillLevel) {
        super(id, name, gradeLevel, description);
        this.skillLevel = skillLevel;
    }

    @Override
    public String getCategory() {
        return "SKILL";
    }

    @Override
    public String displaySubject() {
        return getName() + " - " + skillLevel + " level";
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
}
