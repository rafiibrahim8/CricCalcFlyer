package ml.nerdsofku.criccalcflyer;

public class BattingHandler implements ScoringHandler {

    private Calculate c;
    private BatsMan bm1, bm2;
    private int wicket,extraRun;

    private int onStrike;


    public BattingHandler(int totalOver, int terget){
        c = new Calculate(totalOver,terget);
        bm1 = new BatsMan();
        bm2 = new BatsMan();
        setStrike(1);
        wicket = extraRun = 0;
    }

    public void setStrike(int who){
        onStrike = who;
        if(onStrike == 1){
            bm1.setStrike(true);
            bm2.setStrike(false);
        }
        else{
            bm1.setStrike(false);
            bm2.setStrike(true);
        }
    }

    @Override
    public void popupforName() {

    }

    @Override
    public String getScoreMain() {
        return " "+c.getRunDone()+"/"+wicket;
    }

    @Override
    public String getTarget() {
        return " "+c.getTarget();
    }

    @Override
    public String getRunReq() {
        return " "+c.getRunReq();
    }

    @Override
    public String getExtraRun() {
        return " "+extraRun;
    }

    @Override
    public String getTotalOver() {
        return " "+c.getTotalOver();
    }

    @Override
    public String getOverRem() {
        return " "+c.getOverRemain();
    }

    @Override
    public String getOverDone() {
        return " "+c.getOverDone();
    }

    @Override
    public String getCRR() {
        return " "+c.getCRR();
    }

    @Override
    public String getRRR() {
        return " "+c.getRRR();
    }

    @Override
    public String getBatman1Name() {
        return " "+bm1.getName();
    }

    @Override
    public String getBatman1Run() {
        return " "+bm1.getRun();
    }

    @Override
    public String getBatman1Ball() {
        return " "+bm1.getBallPlayed();
    }

    @Override
    public String getBatman14s() {
        return " "+bm1.getFour();
    }

    @Override
    public String getBatman16s() {
        return " "+bm1.getSix();
    }

    @Override
    public String getBatman1SR() {
        return " "+bm1.getSR();
    }

    @Override
    public String getBatman2Name() {
        return " "+bm2.getName();
    }

    @Override
    public String getBatman2Run() {
        return " "+bm2.getRun();
    }

    @Override
    public String getBatman2Ball() {
        return " "+bm2.getBallPlayed();
    }

    @Override
    public String getBatman24s() {
        return " "+bm2.getFour();
    }

    @Override
    public String getBatman26s() {
        return " "+bm2.getSix();
    }

    @Override
    public String getBatman2SR() {
        return " "+bm2.getSR();
    }

    @Override
    public String getBallmanRun() {
        return "";
    }

    @Override
    public String getBallmanWicket() {
        return "";
    }

    @Override
    public String getBallmanMaiden() {
        return "";
    }

    @Override
    public String getBallmanEco() {
        return "";
    }

    @Override
    public String getBallmanName() {
        return "";
    }

    @Override
    public String getBallmanOver() {
        return "";
    }

    @Override
    public void handleButtonClick(int button, String... args) {

    }
}
