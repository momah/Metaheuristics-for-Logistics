package main.java.abstracts.problem;

public abstract class Problem {
    protected String textInstances;

    protected Problem() {
        super();
    }

    public abstract String toString();

    /**
     * @return the textInstances
     */
    public String getTextInstances() {
        return textInstances;
    }

    /**
     * @param textInstances the textInstances to set
     */
    public void setTextInstances(String textInstances) {
        this.textInstances = textInstances;
    }
}
