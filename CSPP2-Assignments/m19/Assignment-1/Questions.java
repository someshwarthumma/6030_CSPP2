public class Questions{
	private String question;
	private String[] choices;
	private String correct;
	private int maxMarks;
	private int penalty;
	public Questions(String qu,String[] ch,String co,int ma,int pe){
		this.question=qu;
		this.choices = ch;
		this.correct = "choice "+co;
		this.maxMarks= ma;
		this.penalty = pe;
	}

	public String getQueston(){
		return this.question;
	}
	public String[] getChoices(){
		return this.choices;
	}
	public String getCorrect(){
		return this.correct;
	}
	public int getMaxMarks(){
		return this.maxMarks;
	}
	public int getPenalty(){
		return this.penalty;
	}



}