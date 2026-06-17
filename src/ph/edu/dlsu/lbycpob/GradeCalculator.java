package ph.edu.dlsu.lbycpob;

public class GradeCalculator {

    double computeRawGrade(double lab, double part, double eval, double exam, double proj){
        return (lab*0.40) + (part*0.05) + (eval*0.05) + (exam*0.20) + (proj*0.30);
    }

    double getNumericGrade(double rawScore){
        if (rawScore >= 95) {
            return 4.0;
        } else if (rawScore >= 89) {
            return 3.5;
        } else if (rawScore >= 83) {
            return 3.0;
        } else if (rawScore >= 78) {
            return 2.5;
        } else if (rawScore >= 72) {
            return 2.0;
        } else if (rawScore >= 66) {
            return 1.5;
        } else if (rawScore >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    String getLetterRank(double rawScore){
        double gpa = this.getNumericGrade(rawScore);

        if (gpa == 4.0) {
            return "S";
        } else if (gpa == 3.5) {
            return "A";
        } else if (gpa == 3.0) {
            return "B";
        } else if (gpa == 2.5) {
            return "C";
        } else if (gpa == 2.0) {
            return "D";
        } else if (gpa == 1.5) {
            return "E";
        } else if (gpa == 1.0) {
            return "P";
        } else {
            return "F";
        }
    }

    String getRemarks(double rawScore){
        return switch (String.valueOf(this.getNumericGrade(rawScore))) {
            case "4.0" -> "Excellent";
            case "3.5" -> "Superior";
            case "3.0" -> "Very Good";
            case "2.5" -> "Good";
            case "2.0" -> "Satisfactory";
            case "1.5" -> "Fair";
            case "1.0" -> "Poor/Passed";
            default -> "Failed";
        };
    }

    double computeHighest(Student[] students, int activeCount) {
        if (students == null || activeCount == 0) {
            return 0.0;
        }

        Student first = students[0];
        double highest = computeRawGrade(
                first.getLabPerformance(),
                first.getClassParticipation(),
                first.getTeachEval(),
                first.getPracExam(),
                first.getProject()
        );

        for (int i = 1; i < activeCount; i++){
            Student current = students[i];

            double currentScore = computeRawGrade(
                    current.getLabPerformance(),
                    current.getClassParticipation(),
                    current.getTeachEval(),
                    current.getPracExam(),
                    current.getProject()
            );

            if (currentScore > highest){
                highest = currentScore;
            }
        }

        return highest;
    }

    double computeLowest(Student[] students, int activeCount) {
        if (students == null || activeCount == 0){
            return 0;
        }

        Student first = students[0];
        double lowest = computeRawGrade(
                first.getLabPerformance(),
                first.getClassParticipation(),
                first.getTeachEval(),
                first.getPracExam(),
                first.getProject()
        );

        for (int i = 1; i < activeCount; i++){
            Student current = students[i];

            double currentScore = computeRawGrade(
                    current.getLabPerformance(),
                    current.getClassParticipation(),
                    current.getTeachEval(),
                    current.getPracExam(),
                    current.getProject()
            );

            if (currentScore < lowest){
                currentScore = lowest;
            }

        }

        return lowest;
    }

    double computeClassMean(Student[] students, int activeCount) {
        if (students == null || activeCount == 0) {
            return 0.0;
        }

        double totalSum = 0.0;

        for (int i = 0; i < activeCount; i++) {
            Student current = students[i];

            double currentScore = computeRawGrade(
                    current.getLabPerformance(),
                    current.getClassParticipation(),
                    current.getTeachEval(),
                    current.getPracExam(),
                    current.getProject()
            );

            totalSum += currentScore;

        }

        return totalSum/activeCount;
    }
}
