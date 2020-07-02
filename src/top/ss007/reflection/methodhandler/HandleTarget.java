package top.ss007.reflection.methodhandler;

public class HandleTarget {
    private String name="hello world";

    public HandleTarget() {
    }

    public HandleTarget(String name) {
        this.name = name;
    }

    public static String declaration(String author){
        return author+": " + "吾生也有涯，而知也无涯。以有涯随无涯，殆己";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void learnPrograming(String lang){
        System.out.println(String.format("I am learning %s ",lang));
    }


    @Override
    public String toString() {
        return "HandleTarget{" +
                "name='" + name + '\'' +
                '}';
    }
}
