package ml.nerdsofku.criccalcflyer;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class Bowler {
    private String name;
    private int run,wicket,ballPlayed,maiden;
    private int currentOverRun;

    public Bowler(){
        this.name="";
        maiden=run=wicket=ballPlayed=currentOverRun=0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String exportToJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",this.name);
        jsonObject.put("wicket",this.wicket);
        jsonObject.put("maiden",this.maiden);
        jsonObject.put("run",this.run);
        jsonObject.put("currentOverRun",this.currentOverRun);
        jsonObject.put("ballPlayed",this.ballPlayed);
        return jsonObject.toString();
    }

    public void updateWithJson(String json) throws JSONException{
        JSONObject jsonObject = new JSONObject(json);
        this.name = jsonObject.getString("name");
        this.wicket = jsonObject.getInt("wicket");
        this.maiden = jsonObject.getInt("maiden");
        this.run = jsonObject.getInt("run");
        this.currentOverRun = jsonObject.getInt("currentOverRun");
        this.ballPlayed = jsonObject.getInt("ballPlayed");
    }

    public String getEcon(){
        double ecn;
        if(ballPlayed==0 || run==0)
            ecn=0;
        else
            ecn=(double) (run*6)/ballPlayed;
        return new DecimalFormat("#0.0").format(ecn);
    }

    public String getOverPlayed(){
        return (ballPlayed/6)+"."+(ballPlayed%6);
    }

    public String getReport(){
        if(name.isEmpty())
            return "";
        return name+"-"+run+"("+getOverPlayed()+")-"+wicket+"W-"+maiden+"M-"+"ECN: "+getEcon();
    }

    public void doBall(boolean isValid, int run) {
        this.run+=run;
        currentOverRun+=run;
        if(isValid)
            ballPlayed++;
        if(ballPlayed%6==0){
            if(currentOverRun==0)
                maiden++;
            currentOverRun=0;
        }
    }
    public void doBall(boolean isValid, int run, boolean isWicket){
        if(isWicket) wicket++;
        doBall(isValid,run);
    }

    public void doBall(int run){
        doBall(true,run);
    }


    public String getName(){
        return name;
    }

    public String getRun(){
        return run+"";
    }

    public String getMaiden() {
        return maiden+"";
    }

    public String getWicket() {
        return wicket+"";
    }
}