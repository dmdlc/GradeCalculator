package ph.edu.dlsu.lbycpob;

public class Student {
    private String name;
    private double labPerformance;
    private double classParticipation;
    private double teachEval;
    private double pracExam;
    private double project;

    Student(String name, double labPerformance, double classParticipation, double teachEval,
            double pracExam, double project){
        this.name = name;
        this.labPerformance = labPerformance;
        this.classParticipation = classParticipation;
        this.teachEval;
        this.pracExam;
    }

    double getLabPerformance(){
        return labPerformance;
    }

    double getClassParticipation(){
        return classParticipation;
    }

    double getTeachEval(){
        return teachEval;
    }

    double getPracExam(){
        return pracExam;
    }

    double getProject(){
        return project;
    }

    void setLabPerformance(double labPerformance){
        if (labPerformance <= 0 || labPerformance > 100){
            System.out.println("Invalid. Number must be between 0-100");
            return;
        }
        this.labPerformance = labPerformance;
    }

    void setClassParticipation(double classParticipation){
        if (classParticipation <= 0 || classParticipation > 100){
            System.out.println("Invalid. Number must be between 0-100");
            return;
        }
        this.classParticipation = classParticipation;
    }

    void setTeachEval(double teachEval){
        if (teachEval <= 0 || teachEval > 100){
            System.out.println("Invalid. Number must be between 0-100");
            return;
        }
        this.teachEval = teachEval;
    }

    void setPracExam(double pracExam){
        if (pracExam <= 0 || pracExam > 100){
            System.out.println("Invalid. Number must be between 0-100");
            return;
        }
        this.pracExam = pracExam;
    }

    void setProject(double project){
        if (project <= 0 || project > 100){
            System.out.println("Invalid. Number must be between 0-100");
            return;
        }
        this.project = project;
    }
}
