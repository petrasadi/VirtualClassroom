package edu.depaul.se491.formBeans;

import java.util.ArrayList;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import com.google.appengine.api.datastore.Key;

public class ClassSurveyFormBean {

	@NotEmpty
	private String q1 = "Course objectives were clearly defined";
	@NotEmpty
	private String q2 = "Information presented can be applied";
	@NotEmpty
	private String q3 = "The content met my expectations";
	@NotEmpty
	private String q4 = "This course was an appropriate length to cover the stated objectives";
	@NotEmpty
	private String q5 = "The material was logically organized";
	@NotEmpty
	private String q6 = "The instructor created an engaging learning environment";
	@NotEmpty
	private String q7 = "The instructor was knowledgeable of the course content";
	@NotEmpty
	private String q8 = "The instructor presented materials in an organized manner";
	@NotEmpty
	private String q9 = "The instructor responded to questions thoroughly and carefully"; 
	
	private String a1 = "Exceeds Expectations";
	
	private String a2 = "Meets Expectations";
	
	private String a3 = "Does NOT Meet Expectations";
	
	private ArrayList<String> questions;
	
	private ArrayList<String> answers;
	
	public ClassSurveyFormBean() {
		questions = new ArrayList<String>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		questions.add(q6);
		questions.add(q7);
		questions.add(q8);
		questions.add(q9);
		
		answers = new ArrayList<String>();
		answers.add("Exceeds Expectations");
		answers.add("Meets Expectations");
		answers.add("Does NOT Meet Expectations");
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	public String getQ1() {
		return q1;
	}

	public String getQ2() {
		return q2;
	}

	public String getQ3() {
		return q3;
	}

	public String getQ4() {
		return q4;
	}

	public String getQ5() {
		return q5;
	}

	public String getQ6() {
		return q6;
	}

	public String getQ7() {
		return q7;
	}

	public String getQ8() {
		return q8;
	}

	public String getQ9() {
		return q9;
	}
	
	public String getA1() {
		return a1;
	}
	
	public String getA2() {
		return a2;
	}
	
	public String getA3() {
		return a3;
	}
}
