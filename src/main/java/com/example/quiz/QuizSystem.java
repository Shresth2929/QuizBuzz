package com.example.quiz;

import java.util.*;

public class QuizSystem {
    private Map<String, Collection<Question>> topicQuestions;
    private List<Question> currentQuestions;
    private int currentQuestionIndex;
    private int score;

    public static class Question {
        private String questionText;
        private List<String> options;
        private int correctAnswerIndex;
        private int selectedAnswerIndex;

        public Question(String questionText, List<String> options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
            this.selectedAnswerIndex = -1;
        }

        public String getQuestionText() { return questionText; }
        public List<String> getOptions() { return options; }
        public int getCorrectAnswerIndex() { return correctAnswerIndex; }
        public int getSelectedAnswerIndex() { return selectedAnswerIndex; }
        public void setSelectedAnswerIndex(int index) { this.selectedAnswerIndex = index; }
    }

    public QuizSystem() {
        topicQuestions = new LinkedHashMap<>();
        initializeQuestions();
        currentQuestions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;
    }

    private void initializeQuestions() {
        topicQuestions.put("ArrayList", Arrays.asList(
            new Question("What is the time complexity of ArrayList get operation?", 
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0),
            new Question("Which interface does ArrayList implement?", 
                Arrays.asList("Set", "List", "Map", "Queue"), 1),
            new Question("What is the default initial capacity of ArrayList?", 
                Arrays.asList("8", "10", "16", "20"), 1),
            new Question("Can ArrayList store null values?", 
                Arrays.asList("Yes", "No", "Only one", "Only as first element"), 0),
            new Question("What method adds an element to ArrayList?", 
                Arrays.asList("push()", "add()", "insert()", "append()"), 1)
        ));
        topicQuestions.put("HashSet", Arrays.asList(
            new Question("What is the time complexity of HashSet contains operation?", 
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0),
            new Question("Does HashSet allow duplicate elements?", 
                Arrays.asList("Yes", "No", "Sometimes", "Only strings"), 1),
            new Question("Which interface does HashSet implement?", 
                Arrays.asList("List", "Set", "Map", "Queue"), 1),
            new Question("What is the underlying data structure of HashSet?", 
                Arrays.asList("Array", "LinkedList", "HashMap", "Tree"), 2),
            new Question("Can HashSet store null values?", 
                Arrays.asList("Yes, multiple", "Yes, one", "No", "Only as first"), 1)
        ));
        topicQuestions.put("HashMap", Arrays.asList(
            new Question("What is the time complexity of HashMap get operation?", 
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0),
            new Question("What does HashMap store?", 
                Arrays.asList("Values only", "Keys only", "Key-value pairs", "Indexes"), 2),
            new Question("Which interface does HashMap implement?", 
                Arrays.asList("List", "Set", "Map", "Queue"), 2),
            new Question("What happens if you insert a duplicate key in HashMap?", 
                Arrays.asList("Error", "Value updated", "Key ignored", "Duplicate stored"), 1),
            new Question("Can HashMap have null keys?", 
                Arrays.asList("Yes, multiple", "Yes, one", "No", "Only as first"), 1)
        ));
        topicQuestions.put("Stack", Arrays.asList(
            new Question("What is the principle of Stack?", 
                Arrays.asList("FIFO", "LIFO", "Random", "Sorted"), 1),
            new Question("What is the time complexity of Stack push operation?", 
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0),
            new Question("Which method removes an element from Stack?", 
                Arrays.asList("pop()", "push()", "peek()", "poll()"), 0),
            new Question("What does Stack peek() return?", 
                Arrays.asList("Top element", "Bottom element", "Size", "Null"), 0),
            new Question("Can Stack be implemented using ArrayList?", 
                Arrays.asList("Yes", "No", "Only with LinkedList", "Only with Map"), 0)
        ));
        topicQuestions.put("Queue", Arrays.asList(
            new Question("What is the principle of Queue?", 
                Arrays.asList("LIFO", "FIFO", "Random", "Sorted"), 1),
            new Question("What is the time complexity of Queue offer operation?", 
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 0),
            new Question("Which method removes an element from Queue?", 
                Arrays.asList("pop()", "poll()", "peek()", "push()"), 1),
            new Question("What does Queue peek() return?", 
                Arrays.asList("Last element", "First element", "Size", "Null"), 1),
            new Question("Can Queue be implemented using LinkedList?", 
                Arrays.asList("Yes", "No", "Only with ArrayList", "Only with Map"), 0)
        ));
        topicQuestions.put("Binary Trees", Arrays.asList(
            new Question("What is the height of an empty binary tree?", 
                Arrays.asList("0", "1", "-1", "Null"), 2),
            new Question("What is the time complexity of binary tree traversal?", 
                Arrays.asList("O(1)", "O(n)", "O(log n)", "O(n^2)"), 1),
            new Question("Which traversal visits the root first?", 
                Arrays.asList("Inorder", "Preorder", "Postorder", "Level-order"), 1),
            new Question("What is a leaf node in a binary tree?", 
                Arrays.asList("Has one child", "Has no children", "Has two children", "Root node"), 1),
            new Question("What is the maximum number of nodes at height h?", 
                Arrays.asList("2^h", "2^(h+1)", "h^2", "h+1"), 0)
        ));
    }

    public List<String> getTopics() {
        return new ArrayList<>(topicQuestions.keySet());
    }

    public void startQuiz(String topic) {
        currentQuestions.clear();
        score = 0;
        currentQuestionIndex = 0;
        if (topicQuestions.containsKey(topic)) {
            currentQuestions.addAll(topicQuestions.get(topic));
        }
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            return currentQuestions.get(currentQuestionIndex);
        }
        return null;
    }

    public void submitAnswer(int answerIndex) {
        if (currentQuestionIndex < currentQuestions.size()) {
            Question currentQuestion = currentQuestions.get(currentQuestionIndex);
            currentQuestion.setSelectedAnswerIndex(answerIndex);
            if (currentQuestion.getCorrectAnswerIndex() == answerIndex) {
                score++;
            }
        }
    }

    public void nextQuestion() {
        if (currentQuestionIndex < currentQuestions.size()) {
            currentQuestionIndex++;
        }
    }

    public boolean hasPreviousQuestion() {
        return currentQuestionIndex > 0;
    }

    public void previousQuestion() {
        if (hasPreviousQuestion()) {
            currentQuestionIndex--;
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return currentQuestions.size();
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(currentQuestions);
    }
}