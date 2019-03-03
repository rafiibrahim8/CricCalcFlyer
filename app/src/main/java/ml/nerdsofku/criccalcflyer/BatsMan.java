package ml.nerdsofku.criccalcflyer;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class BatsMan {
    private String name,outName;
    private boolean isOut,isOnStrike;
    private int run,four,six,ballPlayed;

    public BatsMan(){
        this.name = "";
        this.outName = "";
        this.isOut = this.isOnStrike = false;
        this.run = this.four = this.six = this.ballPlayed = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String exportToJson() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",this.name);
        jsonObject.put("isOut",this.isOut);
        jsonObject.put("isOnStrike",this.isOnStrike);
        jsonObject.put("run",this.run);
        jsonObject.put("four",this.four);
        jsonObject.put("six",this.six);
        jsonObject.put("ballPlayed",this.ballPlayed);
        jsonObject.put("outName",this.outName);
        return jsonObject.toString();
    }

    public void updateWithJson(String json) throws JSONException{
        JSONObject jsonObject = new JSONObject(json);
        this.name = jsonObject.getString("name");
        this.isOut = jsonObject.getBoolean("isOut");
        this.isOnStrike = jsonObject.getBoolean("isOnStrike");
        this.run = jsonObject.getInt("run");
        this.four = jsonObject.getInt("four");
        this.six = jsonObject.getInt("six");
        this.ballPlayed = jsonObject.getInt("ballPlayed");
        this.outName = jsonObject.getString("outName");
    }

    public String getName(){
        return this.name;
    }

    public String getOutName(){
        return this.outName;
    }

    public boolean isOnStrike(){
        return this.isOnStrike;
    }

    public boolean isOut(){
        return this.isOut;
    }

    public String getRun(){
        return this.run+"";
    }

    public String getFour(){
        return this.four+"";
    }

    public String getSix(){
        return this.six+"";
    }

    public String getBallPlayed(){
        return this.ballPlayed+"";
    }

    public String getSR(){
        double lsr;
        if(ballPlayed==0 || run==0)
            lsr=0;
        else
            lsr=(double) (run*100)/ballPlayed;;
        return new DecimalFormat("#0.0").format(lsr);
    }

    public String getFinalReport(){
        if(name.isEmpty())
            return "";
        return name+(isOut?" ("+outName+") ":"*")+"-"+run+"("+ballPlayed+")"+"-6("+six+")"+"-4("+four+")-"+"SR: "+getSR();
    }

    public void updateRun(int run0){
        run+=run0;
        ballPlayed++;
        if(run0==4)
            four++;
        else if(run0==6)
            six++;
    }

    public void setOuted(String type){
        isOut = true;
        outName = type;
    }

    public void setStrike(boolean arg){
        isOnStrike = arg;
    }
}