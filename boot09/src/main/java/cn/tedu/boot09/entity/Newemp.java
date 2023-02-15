package cn.tedu.boot09.entity;

/**
 * 说明：id,name,salary,job
 *
 * @author: PYS
 * @date: 2023/2/9
 **/
public class Newemp {
    private Integer id;
    private String name;
    private Double salary;
    private String job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Newemp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }
}
