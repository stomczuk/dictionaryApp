package app.model;

public class Test {

    private String test = "123";
    private String test2 = "345";

    public Test(String test, String test2) {
        this.test = test;
        this.test2 = test2;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
