public class App {
    public static void main(String[] args) throws Exception {
        DataScientist datascientist = new DataScientist("John");
        Researcher researcher = new Researcher("Jane");       

        System.out.println(datascientist.getName() + " works as a " + datascientist.getWork() + " and he earns " + datascientist.getSalary());
        System.out.println(researcher.getName() + " works as a " + researcher.getWork() + " and she earns " + researcher.getSalary());
    }
}
