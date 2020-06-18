package uebung_11_1;

public class Person implements Comparable<Person> {

    public String name;
    public int size;
    public Job job;

    public Person(String name, int size, Job job) {
        this.name = name;
        this.size = size;
        this.job = job;
    }

    @Override
    public int compareTo(Person other) {
            
            if (this.getJob().getSalary() > other.getJob().getSalary()) {
                // this earns more than other 
                return 1;
            }
            
            else if(this.getJob().getSalary() < other.getJob().getSalary() ) {
                // this earns less than other
                return -1;
            } else {
                // this earns as much as other 
                if (this.getSize() < other.getSize()) {
                    // this size is smaller than others
                    return 1;
                } else if (this.getSize() > other.getSize()) {
                    // this size is bigger than others
                    return -1;
                }
                else {
                	return 0;
                }
            }
    
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public Job getJob() {
        return this.job;
    }
}
