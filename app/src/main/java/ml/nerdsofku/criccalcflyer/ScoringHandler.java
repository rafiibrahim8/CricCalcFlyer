package ml.nerdsofku.criccalcflyer;

public interface ScoringHandler {
    public void popupforName();
    public String getScoreMain();
    public String getTarget();
    public String getRunReq();
    public String getExtraRun();
    public String getTotalOver();
    public String getOverRem();
    public String getOverDone();
    public String getCRR();
    public String getRRR();
    public String getBatman1Name();
    public String getBatman1Run();
    public String getBatman1Ball();
    public String getBatman14s();
    public String getBatman16s();
    public String getBatman1SR();
    public String getBatman2Name();
    public String getBatman2Run();
    public String getBatman2Ball();
    public String getBatman24s();
    public String getBatman26s();
    public String getBatman2SR();
    public String getBallmanRun();
    public String getBallmanWicket();
    public String getBallmanMaiden();
    public String getBallmanEco();
    public String getBallmanName();
    public String getBallmanOver();
    public void handleButtonClick(int button, String... args);
}