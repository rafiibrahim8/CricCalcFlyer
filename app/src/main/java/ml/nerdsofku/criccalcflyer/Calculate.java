package ml.nerdsofku.criccalcflyer;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class Calculate {
    private  int totalBall, target, runReq, runDone, ballDone, ballRemain;
    double crr,rrr;

    public Calculate(int totalOver, int target){
        this.totalBall =totalOver*6;
        this.target = target;
        this.runReq = target;
        this.runDone = 0;
        this.ballDone = 0;
        calculate(false,0);
    }
    public void updateWithJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        this.totalBall = jsonObject.getInt("totalBall");
        this.target = jsonObject.getInt("target");
        this.runReq = jsonObject.getInt("runReq");
        this.runDone = jsonObject.getInt("runDone");
        this.ballDone = jsonObject.getInt("ballDone");
        calculate(false,0);
    }

    public String exportToJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalBall",this.totalBall);
        jsonObject.put("target",target);
        jsonObject.put("runReq",this.runReq);
        jsonObject.put("runDone",this.runDone);
        jsonObject.put("ballDone",this.ballDone);
        return  jsonObject.toString();
    }

    public void calculate(int run){
        calculate(true,run);
    }

    public void calculate(boolean willUpdateBall, int run){
        runDone+=run;
        if(willUpdateBall) ballDone++;
        runReq = target - runDone;
        ballRemain = totalBall - ballDone;
        try{
            rrr=6*(double)runReq/ballRemain;
        } catch (Exception ex){
            rrr=0;
        }

        try{
            crr=6*(double)runDone/ballDone;
        } catch (Exception ex){
            crr = 0;
        }
    }

    public String getCRR(){
        if(Double.isNaN(crr)) return "0.00";
        return new DecimalFormat("#0.00").format(crr);
    }

    public String getRRR(){
        if(Double.isNaN(rrr)) return "0.00";
        return new DecimalFormat("#0.00").format(rrr);
    }
    public String getOverDone(){
        return (ballDone/6)+"."+(ballDone % 6);
    }
    public String getOverRemain(){
        return (ballRemain/6)+"."+(ballRemain % 6);
    }

    public String getBallRemain() {
        return ""+ballRemain;
    }

    public int getRunReq() {
        return runReq;
    }

    public int getRunDone() {
        return runDone;
    }
    public int getTarget(){
        return target;
    }

    public String getTotalOver() {
        return totalBall/6+".0";
    }
}