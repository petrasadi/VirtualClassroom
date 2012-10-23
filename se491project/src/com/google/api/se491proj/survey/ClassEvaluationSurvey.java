package com.google.api.se491proj.survey;

import java.util.HashMap;

public class ClassEvaluationSurvey {
	protected enum Answers {
		DNME("Does NOT Meet Expectations"), ME("Meets Expectations"), EE("Exceeds Expectations");
		private String answer;
		
		private Answers(String answer) {
			this.answer = answer;
		}
		
		public String getAnswer() {
			return this.answer;
		}
	}
	
	private HashMap<String, Answers[]> questions = new HashMap<String, Answers[]>();
	private HashMap<String, Answers> answers = new HashMap<String, Answers>();
	
	public ClassEvaluationSurvey() {
		questions.put("Course objectivs were clearly defined", Answers.values());
		questions.put("Information presented can be applied", Answers.values());
		questions.put("The content met my expectations", Answers.values());
		questions.put("This course was an appropriate length to cover the stated objectives", Answers.values());
		questions.put("The material was logically organized", Answers.values());
		questions.put("The instructor created an engaging learning environment", Answers.values());
		questions.put("The instructor was knowledgeable of the course content", Answers.values());
		questions.put("The instructor presented materials in an organized manner", Answers.values());
		questions.put("The instructor responded to questions thoroughly and carefully", Answers.values());
	}
	
	public HashMap<String, Answers[]> getQuestions() {
		return this.questions;
	}
	
	public boolean setAnswerME(String question) {
		if (!this.answers.containsKey(question)) {
			this.answers.put(question, Answers.ME);
			return true;
		}
		return false;
	}
	
	public boolean setAnswerEE(String question) {
		if (!this.answers.containsKey(question)) {
			this.answers.put(question, Answers.EE);
			return true;
		}
		return false;
	}
	
	public boolean setAnswerDNME(String question) {
		if (!this.answers.containsKey(question)) {
			this.answers.put(question, Answers.DNME);
			return true;
		}
		return false;
	}
	
	public HashMap<String, Answers> getAnswers() {
		return this.answers;
	}
}
