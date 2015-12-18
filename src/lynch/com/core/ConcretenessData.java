package lynch.com.core;

public class ConcretenessData {

	private String word;
	private double bigram;
	private double concretenessM;
	private double concretenessSD;
	private double unknown;
	private double total;
	private float percentage;
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public double getBigram() {
        return bigram;
    }
    public void setBigram(double bigram) {
        this.bigram = bigram;
    }
    public double getConcretenessM() {
        return concretenessM;
    }
    public void setConcretenessM(double concretenessM) {
        this.concretenessM = concretenessM;
    }
    public double getConcretenessSD() {
        return concretenessSD;
    }
    public void setConcretenessSD(double concretenessSD) {
        this.concretenessSD = concretenessSD;
    }
    public double getUnknown() {
        return unknown;
    }
    public void setUnknown(double unknown) {
        this.unknown = unknown;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public float getPercentage() {
        return percentage;
    }
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
     
}