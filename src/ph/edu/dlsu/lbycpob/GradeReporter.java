package ph.edu.dlsu.lbycpob;

public class GradeReporter {

    String generateReport(Student[] students, int activeCount, GradeCalculator calculator) {
        if (students == null || activeCount == 0) {
            return "No students records to create report from";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-15s %-12s %-10s %-12s %-12s\n",
                "NAME", "RAW SCORE", "GPA", "LETTER", "REMARKS"));

        for (int i = 0; i < activeCount; i++) {
            Student s = students[i];

            double raw = calculator.computeRawGrade(
                    s.getLabPerformance(), s.getClassParticipation(), s.getTeachEval(),
                    s.getPracExam(), s.getProject()
            );

            double gpa = calculator.getNumericGrade(raw);
            String letter = calculator.getLetterRank(raw);
            String remarks = calculator.getRemarks(raw);

            sb.append(String.format("%-15s %-12.2f %-10.1f %-12s %-12s\n",
                    s.getName(), raw, gpa, letter, remarks));
        }



        return sb.toString();
    }
}
