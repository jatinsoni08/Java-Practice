package in.jatinedtech.dto;

import java.io.Serializable;

public class Patient implements Serializable {

    private Integer pid;
    private String name;
    private Integer age;
    private String disease;
    private String address;

    public Patient() {

    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient [pid=" + pid + ", name=" + name + ", age=" + age +
               ", disease=" + disease + ", address=" + address + "]";
    }
}