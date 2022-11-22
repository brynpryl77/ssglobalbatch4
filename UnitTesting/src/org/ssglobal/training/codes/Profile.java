package org.ssglobal.training.codes;

public class Profile {
    private String name;
    private Integer age;

    public Profile() {
        this.name = "";
        this.age = 18;
    }

    public String showProfile() {
        return String.join(" ", name, age.toString());
    }

    public int increaseAge(int gradient) {
        return this.age += gradient;
    }
}
