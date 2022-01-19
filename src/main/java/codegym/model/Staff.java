package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp = "^[A-Z][a-z]{4,48}$", message = "6-50 ki tu, bat dau bang chu Hoa")
    private String name;
    @Min(value = 18, message = "Min 18 Max 30")
    @Max(value = 30, message = "Min 18 Max 30")
    private int age;
    private long salary;

    @ManyToOne
    private Branch branch;

    public Staff() {
    }

    public Staff(String name, int age, long salary, Branch branch) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
