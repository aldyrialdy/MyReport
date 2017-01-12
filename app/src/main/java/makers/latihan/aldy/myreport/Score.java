package makers.latihan.aldy.myreport;

/**
 * Created by aldyrialdy on 09/01/17.
 */
public class Score {
    private String subjectName;
    private String subjectScore;

    public Score(String subjectName, String subjectScore) {
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(String subjectScore) {
        this.subjectScore = subjectScore;
    }
}
