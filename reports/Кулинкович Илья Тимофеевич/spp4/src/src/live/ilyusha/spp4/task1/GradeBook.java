package live.ilyusha.spp4.task1;

import java.util.ArrayList;

class GradeBook {

    private static class Exam {
        String subject;
        String lecturer;
        int grade;

        public Exam(String subject, String lecturer, int grade) {
            this.subject = subject;
            this.lecturer = lecturer;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("<Exam subject=\"%s\" teacher=\"%s\" mark=%d>", subject, lecturer, grade);
        }

    }

    private ArrayList<Exam> exams = new ArrayList<>();
    private String student;

    public GradeBook(String student) {
        this.student = student;
    }

    public void add(String subject, String lecturer, int grade) {
        exams.add(new Exam(subject, lecturer, grade));
    }

    public void log() {
        System.out.println(String.join("\n", exams.stream().map(Exam::toString).toArray(String[]::new)));
    }

}
